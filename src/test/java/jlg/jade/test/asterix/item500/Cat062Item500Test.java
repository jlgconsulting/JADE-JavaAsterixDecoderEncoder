/* 
* Created by dan-geabunea on 5/13/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item500;

import jlg.jade.cat062.item500.Cat062Item500;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;

import static org.junit.Assert.assertEquals;

public class Cat062Item500Test extends MandatoryFspecAsterixTests<Cat062Item500> {
    @Override
    protected Cat062Item500 setDataFieldInstance() {
        return new Cat062Item500();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return 2;
    }

    private byte[] sampleInput = {
            (byte) 191,
            (byte) 128,
            0,
            35,
            0,
            33,
            0,
            28,
            0,
            41,
            47,
            1,
            8,
            12,
            1,
            2,
            15
    };

    @Override
    public void the_decode_method_should_correctly_populate_fspec_field() {
        //arrange
        int offset = 0;
        Cat062Item500 item500 = new Cat062Item500();

        //act
        item500.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertEquals("FSPEC actual length not correct", 2, item500.getActualFspecSizeInBytes());

        assertEquals("FSPEC not decoded correctly - #1", true, item500.fspecDataAtIndex(7));
        assertEquals("FSPEC not decoded correctly - #2", false, item500.fspecDataAtIndex(6));
        assertEquals("FSPEC not decoded correctly - #3", true, item500.fspecDataAtIndex(5));
        assertEquals("FSPEC not decoded correctly - #4", true, item500.fspecDataAtIndex(4));
        assertEquals("FSPEC not decoded correctly - #5", true, item500.fspecDataAtIndex(3));
        assertEquals("FSPEC not decoded correctly - #6", true, item500.fspecDataAtIndex(2));
        assertEquals("FSPEC not decoded correctly - #7", true, item500.fspecDataAtIndex(1));
        assertEquals("FSPEC not decoded correctly - #8", true, item500.fspecDataAtIndex(15));
    }

    @Override
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        int offset = 0;
        Cat062Item500 item500 = new Cat062Item500();

        //act
        item500.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertEquals("Subfield not decoded correctly - #1", 35, item500.getSubfield1().getAccuracyOfPositionX());
        assertEquals("Subfield not decoded correctly - #1", 33, item500.getSubfield1().getAccuracyOfPositionY());
        assertEquals("Subfield not decoded correctly - #3", 28, item500.getSubfield3().getAccurracyForPositionLat());
        assertEquals("Subfield not decoded correctly - #3", 41, item500.getSubfield3().getAccurracyForPositionLon());
        assertEquals("Subfield not decoded correctly - #4", 47, item500.getSubfield4()
                .getAccuracyForGeometricAltitude());
        assertEquals("Subfield not decoded correctly - #5", 1, item500.getSubfield5()
                .getAccuracyForBarometricAltitude());
        assertEquals("Subfield not decoded correctly - #6", 8, item500.getSubfield6().getAccuracyForVelocityX());
        assertEquals("Subfield not decoded correctly - #6", 12, item500.getSubfield6().getAccuracyForVelocityY());
        assertEquals("Subfield not decoded correctly - #7", 1, item500.getSubfield7().getAccuracyForAccelerationX());
        assertEquals("Subfield not decoded correctly - #7", 2, item500.getSubfield7().getAccuracyForAccelerationY());
        assertEquals("Subfield not decoded correctly - #8", 15, item500.getSubfield8().getAccuracyForRocd());
    }

    @Override
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        //arrange
        int offset = 0;
        Cat062Item500 item500 = new Cat062Item500();

        //act
        int result = item500.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertEquals("Offset not incremented after decoding data", sampleInput.length, result);
    }
}
