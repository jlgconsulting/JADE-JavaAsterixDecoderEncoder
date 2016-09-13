/*
* Created by dan-geabunea on 4/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.utils;

import jlg.finalframe.FinalFrameReader;
import jlg.jade.asterix.AsterixDataBlock;
import jlg.jade.asterix.AsterixDecoder;
import jlg.jade.asterix.AsterixRecord;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TestHelper {
    public static File getFileFromResource(String fileName){
        String path = TestHelper.class.getClassLoader().getResource(fileName).getPath();
        File file = new File(path);

        return file;
    }

    public static InputStream getFileInputStreamFromResource(String fileName){
        InputStream fis = TestHelper.class.getClassLoader().getResourceAsStream(fileName);
        return fis;
    }

    public static  byte[] fromIntToByteArray(int val){
        return BigInteger.valueOf(val).toByteArray();
    }

    public static List<AsterixRecord> extractAsterixRecordsFromFile(String fileName) {
        File sampleFile = TestHelper.getFileFromResource(fileName);
        AsterixDecoder asterixDecoder = new AsterixDecoder();
        List<AsterixRecord> asterixRecords = new ArrayList<>();
        try (InputStream is = new FileInputStream(sampleFile)) {
            FinalFrameReader ffReader = new FinalFrameReader();

            while (is.available() > 0) {
                byte[] ffPayload = ffReader.read(is);
                if (ffPayload != null) {
                    List<AsterixDataBlock> asterixDataBlocks = asterixDecoder.decode(ffPayload, 0, ffPayload.length);
                    asterixDataBlocks.forEach((db) -> {
                        asterixRecords.addAll(db.getRecords());
                    });
                }
            }

            return asterixRecords;
        } catch (IOException e) {
        }
        return asterixRecords;
    }
}
