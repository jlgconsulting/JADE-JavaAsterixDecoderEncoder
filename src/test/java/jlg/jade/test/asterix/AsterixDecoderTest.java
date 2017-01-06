/**
 * Created by alexandru on 9/21/16.
 */
package jlg.jade.test.asterix;

import jlg.finalframe.FinalFrameReader;
import jlg.jade.asterix.AsterixDataBlock;
import jlg.jade.asterix.AsterixDecoder;
import jlg.jade.asterix.AsterixRecord;
import jlg.jade.test.utils.TestHelper;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AsterixDecoderTest {

    /**
     * The sample file for this test contains:
     * Cat062 records: 22396
     * Cat065 records: 6057
     */
    @Test
    public void the_decode_method_should_decode_only_specified_categories_from_the_large_sample() {
        // arrange
        File sampleFile = TestHelper
                .getFileFromResource("final_frame_062_065_large_packet_30min.ff");
        AsterixDecoder asterixDecoder = new AsterixDecoder(62);
        List<AsterixRecord> asterixRecords = new ArrayList<>();

        // act
        try (InputStream is = new FileInputStream(sampleFile)) {
            FinalFrameReader ffReader = new FinalFrameReader();

            while (is.available() > 0) {
                byte[] ffPayload = ffReader.read(is);
                if (ffPayload != null) {
                    List<AsterixDataBlock> asterixDataBlocks = asterixDecoder
                            .decode(ffPayload, 0, ffPayload.length);
                    asterixDataBlocks.forEach((db) -> {
                        asterixRecords.addAll(db.getRecords());
                    });
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // assert
        assertEquals("Number of decoded Cat062 items is not correct", 22396, asterixRecords.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void attachCustomReservedFieldFactory_should_throw_if_custom_reserved_field_factory_argument_is_null(){
        AsterixDecoder decoder = new AsterixDecoder(62);
        decoder.attachCustomReservedFieldFactory(62, null);

    }
}
