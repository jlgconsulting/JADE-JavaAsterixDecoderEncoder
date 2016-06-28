/**
 * Created by Dan Geabunea on 6/23/2016.
 */

package jlg.jade.test.asterix.cat004.item170_171;

import jlg.jade.asterix.cat004.item170_171.Cat004AircraftCharacteristicsSubfield7;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004AircraftCharacteristicsSubfield7Test {
    @Test
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        byte[] input = {1, 0};
        int offset = 0;
        Cat004AircraftCharacteristicsSubfield7 subfield7 = new
                Cat004AircraftCharacteristicsSubfield7();

        //act
        int result = subfield7.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after data decoding", 2, result);
    }
}
