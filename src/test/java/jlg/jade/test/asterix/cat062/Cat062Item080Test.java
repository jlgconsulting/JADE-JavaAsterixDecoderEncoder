/* 
* Created by dan-geabunea on 4/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062;

import jlg.jade.asterix.cat062.Cat062Item080;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat062Item080Test {

    @Test
    public void the_decode_method_should_correctly_determine_length() {
        //arrange
        byte[] input = {1, 1, 1, 0};
        int offset = 0;
        Cat062Item080 item = new Cat062Item080();

        //act
        item.decode(input, offset, input.length);

        //assert
        int expectedLength = 4;
        assertEquals("Item length is not correct", expectedLength, item.getSizeInBytes());
    }


    @Test
    public void should_increment_offset_after_decoding_the_data() {
        //arrange
        byte[] input = {1, 1, 1, 0};
        int offset = 0;
        Cat062Item080 item = new Cat062Item080();

        //act
        int newOffset = item.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after decoding data", 4, newOffset);
    }

    @Test
    @Parameters({"2,1","0,0"})
    public void the_decode_method_should_correctly_decode_cnf_info(byte firstOctet, int expectedCfn) {

        /**
         * @implNote We assume only the first octet is present to simplify
         * 2 = 0000 0010 => cfn present
         * 0 = 0000 0000 => cfn absent
         */

        //arrange
        byte[] input = {firstOctet};
        int offset = 0;
        Cat062Item080 item = new Cat062Item080();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("CFN not decoded correctly", expectedCfn, item.getCfnValue());
    }

    @Test
    @Parameters({"0,0","4,1","8,2", "12,3","16,4","20,5","24,6","28,7"})
    public void the_decode_method_should_correctly_decode_src_info(byte firstOctet, int expectedSrc){
        /**
         * @implNote We assume only the first octet is present to simplify
         */

        //arrange
        byte[] input = {firstOctet};
        int offset = 0;
        Cat062Item080 item = new Cat062Item080();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("SRC not decoded correctly", expectedSrc, item.getSrcValue());
    }

    @Test
    @Parameters({"0,0","32,1"})
    public void the_decode_method_should_correctly_decode_mrh_info(byte firstOctet, int expectedMrh) {

        /**
         * @implNote We assume only the first octet is present to simplify
         * 32 = 0010 0000 => mrh present
         * 0  = 0000 0000 => mrh absent
         */

        //arrange
        byte[] input = {firstOctet};
        int offset = 0;
        Cat062Item080 item = new Cat062Item080();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("MRH not decoded correctly", expectedMrh, item.getMrhValue());
    }

    @Test
    @Parameters({"0,0","64,1"})
    public void the_decode_method_should_correctly_decode_spi_info(byte firstOctet, int expectedSpi) {

        /**
         * @implNote We assume only the first octet is present to simplify
         * 64 = 0100 0000 => spi present
         * 0  = 0000 0000 => spi absent
         */

        //arrange
        byte[] input = {firstOctet};
        int offset = 0;
        Cat062Item080 item = new Cat062Item080();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("SPI not decoded correctly", expectedSpi, item.getSpiValue());
    }

    @Test
    @Parameters({"0,0","128,1"})
    public void the_decode_method_should_correctly_decode_mon_info(int firstOctet, int expectedMon) {

        /**
         * @implNote We assume only the first octet is present to simplify
         * 128 = 1000 0000 => mon present
         * 0   = 0000 0000 => mon absent
         */

        //arrange
        byte[] input = {(byte) firstOctet};
        int offset = 0;
        Cat062Item080 item = new Cat062Item080();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("MON not decoded correctly", expectedMon, item.getMonValue());
    }

    @Test
    @Parameters({"1,0,0","1,16,1"})
    public void the_decode_method_should_correctly_decode_fpc_info(int firstOctet, int secondOctet, int expectedFpc) {

        /**
         * @implNote We assume only the first two octest are present to simplify. The first octet is 1, in order
         * to conuinue to read the first extent
         * 16 = 0001 0000 => fpc present
         * 0  = 0000 0000 => fpc absent
         */

        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat062Item080 item = new Cat062Item080();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("FPC not decoded correctly", expectedFpc, item.getFpcValue());
    }


    @Test
    @Parameters({"1,0,0","1,128,1"})
    public void the_decode_method_should_correctly_decode_sim_info(int firstOctet, int secondOctet, int expectedSim) {

        /**
         * @implNote We assume only the first two octest are present to simplify. The first octet is 1, in order
         * to conuinue to read the first extent
         * 128 = 1000 0000 => sim present
         * 0   = 0000 0000 => sim absent
         */

        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat062Item080 item = new Cat062Item080();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("SIM not decoded correctly", expectedSim, item.getSimValue());
    }

    @Test
    @Parameters({"1, 0, 0", "1, 64, 1"})
    public void the_decode_method_should_correctly_decode_tse_info(int firstOctet, int secondOctet, int expectedTse) {

        /**
         * @implNote We assume only the first two octets are present to simplify. The first octet is 1, in order
         * to continue to read the first extent
         * 64 = 0100 0000 => TSE present
         * 0   = 0000 0000 => TSE absent ( default value )
         */

        // arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat062Item080 item = new Cat062Item080();

        // act
        item.decode(input, offset, input.length);

        // assert
        assertEquals("TSE not decoded correctly", expectedTse, item.getTseValue());
    }

}
