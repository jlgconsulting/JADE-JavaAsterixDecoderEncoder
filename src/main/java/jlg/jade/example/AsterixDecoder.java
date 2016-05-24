/* 
* Created by dan-geabunea on 4/20/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.example;

import jlg.jade.asterix.AsterixDataBlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Main class for decoding raw data from the input communication medium.
 * @implNote It is recommended to create a single instance of this class and use the decode method
 * multiple times
 */
public class AsterixDecoder {
    private final HashMap<Integer,Boolean> allowedCategories;
    private final HashMap<Integer,Integer> nbOfDataBlocks;

    private AsterixDecoder(){
        allowedCategories = new HashMap<>();
        allowedCategories.put(4, false);
        allowedCategories.put(34, false);
        allowedCategories.put(48, false);
        allowedCategories.put(62, false);
        allowedCategories.put(65, false);
        allowedCategories.put(150, false);

        nbOfDataBlocks = new HashMap<>();
        nbOfDataBlocks.put(4,0);
        nbOfDataBlocks.put(34,0);
        nbOfDataBlocks.put(48,0);
        nbOfDataBlocks.put(62,0);
        nbOfDataBlocks.put(65,0);
        nbOfDataBlocks.put(150,0);
    }

    public AsterixDecoder(int... categoriesToDecode){
        allowedCategories = new HashMap<>();
        nbOfDataBlocks = new HashMap<>();
        for(int category : categoriesToDecode){
            allowedCategories.put(category, true);
            nbOfDataBlocks.put(category ,0);
        }
    }

    /**
     * Decodes the Asterix data from the given input source.
     * @param input The raw data
     * @param offset The start offset in the raw data, at which reading should begin
     * @param length The number of bytes to read
     * @return The list of decoded Asterix data blocks
     */
    public List<AsterixDataBlock> decode(byte[] input, int offset, int length){
        List<AsterixDataBlock> dataBlocks = new ArrayList<>();
        int inputIndex = offset;

        while(inputIndex < length) {
            int dataBlockCategory = Byte.toUnsignedInt(input[inputIndex]);
            int dataBlockSize = Byte.toUnsignedInt(input[inputIndex+1]) * 256 + Byte.toUnsignedInt(input[inputIndex+2]);

            if (allowedCategories.containsKey(dataBlockCategory)) {
                AsterixDataBlock dataBlock = new AsterixDataBlock(dataBlockCategory);
                inputIndex += 3;
                inputIndex = dataBlock.decode(input, inputIndex, dataBlockSize);
                dataBlocks.add(dataBlock);
                int nbDataBlocks = this.nbOfDataBlocks.get(dataBlockCategory);
                this.nbOfDataBlocks.replace(dataBlockCategory, nbDataBlocks + 1);
            }
            else{
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
}
