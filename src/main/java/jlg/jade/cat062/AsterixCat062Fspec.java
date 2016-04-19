/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.common.DebugMessageSource;
import jlg.jade.common.AsterixDecodingException;

import java.util.BitSet;

/**
 * This class maps the FSPEC structure of Asterix Cat-062. Internally, it uses an array of booleans that
 * are true if the item is in the message and false otherwise. You can use this array in conjuction with the
 * AsterixCat062UAP enum to make code more understandable.
 */
public class AsterixCat062Fspec extends DebugMessageSource {
    private final int FSPEC_LENGTH = 40;
    private final int FSPEC_MAX_BYTES = 5;
    private final int BYTE_LENGTH = 8;
    boolean[] fspecList;

    public AsterixCat062Fspec(){
        this.fspecList = new boolean[FSPEC_LENGTH];
    }

    public int parseData(byte[] inputData, int currentIndex){
        appendDebugMsg("## FSPEC Data:");

        BitSet bs;
        for(int i=0;i<FSPEC_MAX_BYTES;i++){
            int fspecOctet = Byte.toUnsignedInt(inputData[currentIndex+i]);
            appendDebugMsg(String.format("%-5s %-1s value: %-10s", "Octet",i+1, fspecOctet));

            bs = BitSet.valueOf(new byte[]{inputData[currentIndex+i]});
            for(int j=0;j<BYTE_LENGTH;j++){
                fspecList[j + (i*8)] = bs.get(j);
                if(bs.get(j)) {
                    appendDebugMsg("Cat062 " + AsterixCat062UAP.values()[j + (i * 8)] + " has been added to FSPEC with a value of 1");
                }
            }

            //field extension is 0 => do not continue
            if(!bs.get(0)){
                currentIndex += i+1;
                return currentIndex;
            }
        }
        //the FXBIT was never 0, so there is a problem with the FSPEC
        throw new AsterixDecodingException.UndeterminedFspecEnd();
    }

    /**
     * Checks if the given cat062 item exists in the FSPEC array.
     * @param cat062Item the cat 062 item to verify
     * @return true, if the given item exists in the FSPEC, false otherwise
     */
    public boolean isItemInFspec(AsterixCat062UAP cat062Item){
        return fspecList[cat062Item.ordinal()];
    }

    public int getLength(){
        return fspecList.length;
    }
}
