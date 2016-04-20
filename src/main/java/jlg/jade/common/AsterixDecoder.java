/* 
* Created by dan-geabunea on 4/20/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AsterixDecoder {
    private HashMap<Integer,Boolean> allowedCategories;
    private HashMap<Integer,Integer> nbOfDataBlocks;

    protected AsterixDecoder(){
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
        this();
        for(int category : categoriesToDecode){
            allowedCategories.replace(category, true);
        }
    }

    public List<AsterixDataBlock> decode(byte[] inputData, int inputLength){
        List<AsterixDataBlock> dataBlocks = new ArrayList<>();
        int inputIndex = 0;

        while(inputIndex < inputLength) {
            int dataBlockCategory = Byte.toUnsignedInt(inputData[inputIndex]);
            int dataBlockSize = Byte.toUnsignedInt(inputData[inputIndex+1]) * 256 + Byte.toUnsignedInt(inputData[inputIndex+2]);
            inputIndex += 3;

            if (allowedCategories.containsKey(dataBlockCategory)) {
                AsterixDataBlock dataBlock = new AsterixDataBlock(dataBlockCategory, dataBlockSize);
                dataBlocks.add(dataBlock);
                inputIndex = dataBlock.parseData(inputData, inputIndex);

                int nbDataBlocks = this.nbOfDataBlocks.get(dataBlockCategory);
                this.nbOfDataBlocks.replace(dataBlockCategory, nbDataBlocks + 1);
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
