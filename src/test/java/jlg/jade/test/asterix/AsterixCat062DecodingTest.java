/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;

import jlg.finalframe.FinalFrameReader;
import jlg.jade.test.utils.TestHelper;
import org.junit.Test;

import java.io.*;
import java.util.BitSet;

public class AsterixCat062DecodingTest {

    @Test
    public void should_decode_cat_062_message() throws IOException {
        //arrange
        try(InputStream is = TestHelper.getFileInputStreamFromResource("final_frame_correct_sample_one_packet.ff")){
            FinalFrameReader ffReader = new FinalFrameReader();
            while (is.available() > 0){
                byte[] ffPayload = ffReader.read(is);
                if(ffPayload != null){
                    int category = Byte.toUnsignedInt(ffPayload[0]);
                    int length = Byte.toUnsignedInt(ffPayload[1])*256 + Byte.toUnsignedInt(ffPayload[2]);
                    for(int i=0; i<length-3;i++){
                        int val = Byte.toUnsignedInt(ffPayload[i]);
                        System.out.printf(i + ": ");
                        System.out.printf(String.valueOf(Byte.toUnsignedInt(ffPayload[i])) + " - ");
                        BitSet bs = BitSet.valueOf(new byte[]{(byte) val});
                        System.out.printf(bs.toString());
                        System.out.println();
                    }
                }
            }
        }
    }
}
