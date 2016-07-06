/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item200;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat150Item200Test {
    @Test
    public void should_set_correct_size() {
        //arrange
        byte[] input = {11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0};
        int offset = 0;
        Cat150Item200 cat150Item200 = new Cat150Item200();

        //act
        cat150Item200.decode(input, offset, input.length);

        //assert
        assertEquals("Size is not correct", 11, cat150Item200.getSizeInBytes());
    }

    @Test
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        //arrange
        byte[] input = {11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0};
        int offset = 0;
        Cat150Item200 cat150Item200 = new Cat150Item200();

        //act
        int result = cat150Item200.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not updated after data decoding", input.length,
                cat150Item200.getSizeInBytes());
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {5, 65, 66, 67, 68, 69};
        int offset = 0;
        Cat150Item200 cat150Item200 = new Cat150Item200();

        //act
        cat150Item200.decode(input, offset, input.length);

        //assert
        assertEquals("Item not decoded correctly", "ABCDE", cat150Item200.getText());
    }

}
