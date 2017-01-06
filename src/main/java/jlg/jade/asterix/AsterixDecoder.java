/* 
* Created by dan-geabunea on 4/20/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Main class for decoding raw data from the input communication medium.
 *
 * @implNote It is recommended to create a single instance of this class and use the decode method
 * multiple times
 */
public class AsterixDecoder {
    private final HashMap<Integer, Boolean> allowedCategories;
    private final HashMap<Integer, Integer> nbOfDataBlocks;
    private final HashMap<Integer, ReservedFieldFactory> customReservedFieldFactories;

    private AsterixDecoder() {
        allowedCategories = new HashMap<>();
        allowedCategories.put(4, false);
        allowedCategories.put(34, false);
        allowedCategories.put(48, false);
        allowedCategories.put(62, false);
        allowedCategories.put(65, false);
        allowedCategories.put(150, false);

        nbOfDataBlocks = new HashMap<>();
        nbOfDataBlocks.put(4, 0);
        nbOfDataBlocks.put(34, 0);
        nbOfDataBlocks.put(48, 0);
        nbOfDataBlocks.put(62, 0);
        nbOfDataBlocks.put(65, 0);
        nbOfDataBlocks.put(150, 0);

        customReservedFieldFactories = new HashMap<>();
    }

    public AsterixDecoder(int... categoriesToDecode) {
        this();
        for (int category : categoriesToDecode) {
            allowedCategories.put(category, true);
            nbOfDataBlocks.put(category, 0);
        }
    }


    public AsterixDecoder(String categoriesToDecode) {
        this();
        if (categoriesToDecode.contains("4")) {
            allowedCategories.put(4, true);
        }
        if (categoriesToDecode.contains("34")) {
            allowedCategories.put(34, true);
        }
        if (categoriesToDecode.contains("48")) {
            allowedCategories.put(48, true);
        }
        if (categoriesToDecode.contains("62")) {
            allowedCategories.put(62, true);
        }
        if (categoriesToDecode.contains("65")) {
            allowedCategories.put(65, true);
        }
        if (categoriesToDecode.contains("150")) {
            allowedCategories.put(150, true);
        }
    }

    public AsterixDecoder(List<Integer> categoriesToDecode) {
        this();
        allowedCategories.clear();
        nbOfDataBlocks.clear();
        for (int category : categoriesToDecode) {
            allowedCategories.put(category, true);
            nbOfDataBlocks.put(category, 0);
        }
    }

    /**
     * Decodes the Asterix data from the given input source.
     *
     * @param input  The raw data
     * @param offset The start offset in the raw data, at which reading should begin
     * @param length The number of bytes to read
     * @return The list of decoded Asterix data blocks
     */
    public List<AsterixDataBlock> decode(byte[] input, int offset, int length) {
        List<AsterixDataBlock> dataBlocks = new ArrayList<>();
        int inputIndex = offset;

        while (inputIndex < length) {
            int dataBlockCategory = Byte.toUnsignedInt(input[inputIndex]);
            int dataBlockSize = Byte.toUnsignedInt(
                    input[inputIndex + 1]) * 256 + Byte.toUnsignedInt(input[inputIndex + 2]);

            Boolean shouldDecodeCategory = allowedCategories.get(dataBlockCategory);
            if (shouldDecodeCategory != null && shouldDecodeCategory) {

                AsterixDataBlock dataBlock = buildAsterixDataBlock(
                        dataBlockCategory,
                        getCustomReservedFieldFactory(dataBlockCategory)
                );

                inputIndex += 3;

                if (inputIndex > 0) {
                    /**
                     * If raw data contains more data blocks, and offset greater
                     * than 0 (already processed a data block), then we need to add the input
                     * offset to the data block
                     * size.
                     */
                    inputIndex = dataBlock.decode(input, inputIndex,
                            dataBlockSize + inputIndex - 3);
                } else {
                    /**
                     * If raw data is at begining, then offset is 0. No need to add anything to
                     * data block size.
                     */
                    inputIndex = dataBlock.decode(input, inputIndex, dataBlockSize);
                }
                dataBlocks.add(dataBlock);
                int nbDataBlocks = this.nbOfDataBlocks.get(dataBlockCategory);
                this.nbOfDataBlocks.replace(dataBlockCategory, nbDataBlocks + 1);
            } else {
                // Data block not in allowed categories. Skip decoding and add length to existing
                // offset
                inputIndex += dataBlockSize;
            }
        }
        return dataBlocks;
    }

    public HashMap<Integer, Boolean> getAllowedCategories() {
        return allowedCategories;
    }

    public HashMap<Integer, Integer> getNbOfDataBlocks() {
        return nbOfDataBlocks;
    }

    /**
     * Attach a custom reserved field implementation (decoding,encoding of SP,RE) for a given
     * Asterix category. If there is a factory associated with the category, the old
     * entry shall be replaced with the new one.
     *
     * @param category
     * @param reservedFieldFactory
     */
    public void attachCustomReservedFieldFactory(int category,
                                                 ReservedFieldFactory reservedFieldFactory) {
        Assert.notNull(reservedFieldFactory);
        this.customReservedFieldFactories.put(category, reservedFieldFactory);
    }

    /**
     * Get the custom reserved field implementation factory for a given Asterix category,
     * if it has been attached. Will return NULL if no factory is associated with the category
     *
     * @param category
     * @return
     */
    public ReservedFieldFactory getCustomReservedFieldFactory(int category) {
        return this.customReservedFieldFactories.get(category);
    }

    private AsterixDataBlock buildAsterixDataBlock(int category, ReservedFieldFactory customReservedFieldFactory) {
        AsterixDataBlock dataBlock;
        if (customReservedFieldFactory == null) {
            dataBlock = new AsterixDataBlock(category);
        } else {
            dataBlock = new AsterixDataBlock(
                    category,
                    customReservedFieldFactory
            );
        }

        return dataBlock;
    }
}
