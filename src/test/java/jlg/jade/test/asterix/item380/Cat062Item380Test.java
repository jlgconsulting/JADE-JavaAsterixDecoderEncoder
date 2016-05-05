/* 
* Created by dan-geabunea on 5/4/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item380;

import ch.qos.logback.core.net.AbstractSSLSocketAppender;
import jlg.jade.cat062.item380.Cat062Item380;
import jlg.jade.cat062.item380.Cat062Item380Fspec;
import org.junit.Test;

import static org.junit.Assert.*;

public class Cat062Item380Test {
    /**
     * This test will check the validity of the whole item, with the spec and all subfields.
     * We shall use 2 data samples, because not all samples are complete.
     */

    private byte[] first_sample = {
            (byte) 227,
            37,
            (byte) 177,
            12,
            75,
            (byte) 170,
            107,
            80,
            (byte) 134,
            113,
            92,
            40,
            32,
            67,
            (byte) 142,
            5,
            120,
            32,
            0,
            (byte) 255,
            (byte) 251,
            (byte) 255,
            (byte) 238,
            65,
            (byte) 224,
            8,
            46,
            1,
            8,
            0,
            98
    };

    @Test
    public void max_fspec_length_should_be_four_bytes() {
        //arrange
        Cat062Item380 item380 = new Cat062Item380();

        //assert
        assertEquals("Max FSPEC length is invalid", 4, item380.getMaxFspecSizeInBytes());
    }

    @Test
    public void with_sample_1_should_correctly_populate_fspec_info() {
        //arrange
        int offset = 0;
        int length = first_sample.length;
        Cat062Item380 item380 = new Cat062Item380();

        //act
        item380.decode(first_sample, offset, length);

        //assert
        assertEquals("Actual FSPEC length is invalid", 4, item380.getActualFspecSizeInBytes());

        assertEquals("Invalid Item380 Fspec #1", true, item380.isDataPresent(Cat062Item380Fspec.SUBFIELD_1));
        assertEquals("Invalid Item380 Fspec #2", true, item380.isDataPresent(Cat062Item380Fspec.SUBFIELD_2));
        assertEquals("Invalid Item380 Fspec #3", true, item380.isDataPresent(Cat062Item380Fspec.SUBFIELD_3));
        assertEquals("Invalid Item380 Fspec #7", true, item380.isDataPresent(Cat062Item380Fspec.SUBFIELD_7));
        assertEquals("Invalid Item380 Fspec #10", true, item380.isDataPresent(Cat062Item380Fspec.SUBFIELD_10));
        assertEquals("Invalid Item380 Fspec #13", true, item380.isDataPresent(Cat062Item380Fspec.SUBFIELD_13));
        assertEquals("Invalid Item380 Fspec #15", true, item380.isDataPresent(Cat062Item380Fspec.SUBFIELD_15));
        assertEquals("Invalid Item380 Fspec #17", true, item380.isDataPresent(Cat062Item380Fspec.SUBFIELD_17));
        assertEquals("Invalid Item380 Fspec #18", true, item380.isDataPresent(Cat062Item380Fspec.SUBFIELD_18));
        assertEquals("Invalid Item380 Fspec #26", true, item380.isDataPresent(Cat062Item380Fspec.SUBFIELD_26));
        assertEquals("Invalid Item380 Fspec #27", true, item380.isDataPresent(Cat062Item380Fspec.SUBFIELD_27));

        assertEquals(11, item380.getNbPresentDataFields());
    }

    @Test
    public void with_sample_1_should_correctly_decode_data() {
        //arrange
        int offset = 0;
        int length = first_sample.length;
        Cat062Item380 item380 = new Cat062Item380();

        //act
        item380.decode(first_sample, offset, length);

        //assert
        assertEquals("Invalid Item380 decoding #1", "75 170 107", item380.getSubfield1().getTargetAddress());
        assertNotNull("Invalid Item380 decoding #2", item380.getSubfield2());
        assertEquals("Invalid Item380 decoding #3", 17294, item380.getSubfield3().getMagneticHeading());
        assertEquals("Invalid Item380 decoding #7", 1400, item380.getSubfield7().getSelectedAltitude());
        assertFalse("Invalid Item380 decoding #7", item380.getSubfield7().isManageVerticalModeActive());
        assertFalse("Invalid Item380 decoding #7", item380.getSubfield7().isAltitudeHoldActive());
        assertFalse("Invalid Item380 decoding #7", item380.getSubfield7().isApproachModeActive());

        assertNotNull("Invalid Item380 decoding #10", item380.getSubfield10());
        assertEquals("Invalid Item380 decoding #13", -5, item380.getSubfield13().getBarometricVerticalRate());
        assertEquals("Invalid Item380 decoding #15", -18, item380.getSubfield15().getRollAngle());
        assertEquals("Invalid Item380 decoding #17", 16864, item380.getSubfield17().getTrackAngle());
        assertEquals("Invalid Item380 decoding #18", 2094, item380.getSubfield18().getGroundSpeed());
        assertEquals("Invalid Item380 decoding #26", 264, item380.getSubfield26().getIndicatedAirSpeed());
        assertEquals("Invalid Item380 decoding #27", 98, item380.getSubfield27().getMachNumber(), 0.01);
    }

    @Test
    public void with_sample_1_should_increment_offset_after_data_decoding() {
        //arrange
        int offset = 0;
        int length = first_sample.length;
        Cat062Item380 item380 = new Cat062Item380();

        //act
        int result = item380.decode(first_sample, offset, length);

        //assert
        assertEquals("Offset not incremented after decoding of data", first_sample.length, result);
    }

    

}
