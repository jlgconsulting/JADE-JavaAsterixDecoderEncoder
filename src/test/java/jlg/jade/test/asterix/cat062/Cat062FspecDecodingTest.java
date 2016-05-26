/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062;

import jlg.jade.asterix.cat062.Cat062Fspec;
import jlg.jade.asterix.cat062.Cat062UAP;
import jlg.jade.common.Constants;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class Cat062FspecDecodingTest {

    private Logger logger;

    @Before
    public void init() {
        logger = LoggerFactory.getLogger(Constants.LOGGER_NAME);
    }

    /**
     * Array is constructed with data sample from ON (one packet). We can use C++ DAQ logs to generate test scenarios
     */

    @Test
    public void should_parse_fspec_information_correctly(){
        //arrange
        byte[] fspecInputData = new byte[]{(byte) 191,79, (byte) 173,3,2};

        //act
        Cat062Fspec fspec = new Cat062Fspec();
        fspec.decode(fspecInputData, 0, fspecInputData.length);

        //assert
        assertTrue(fspec.isItemInFspec(Cat062UAP.ITEM_010));
        assertFalse(fspec.isItemInFspec(Cat062UAP.SPAREBIT1));
        assertTrue(fspec.isItemInFspec(Cat062UAP.ITEM_015));
        assertTrue(fspec.isItemInFspec(Cat062UAP.ITEM_070));
        assertTrue(fspec.isItemInFspec(Cat062UAP.ITEM_105));
        assertTrue(fspec.isItemInFspec(Cat062UAP.ITEM_100));
        assertTrue(fspec.isItemInFspec(Cat062UAP.ITEM_185));
        assertTrue(fspec.isItemInFspec(Cat062UAP.FXBIT1));

        assertFalse(fspec.isItemInFspec(Cat062UAP.ITEM_210));
        assertTrue(fspec.isItemInFspec(Cat062UAP.ITEM_060));
        assertFalse(fspec.isItemInFspec(Cat062UAP.ITEM_245));
        assertFalse(fspec.isItemInFspec(Cat062UAP.ITEM_380));
        assertTrue(fspec.isItemInFspec(Cat062UAP.ITEM_040));
        assertTrue(fspec.isItemInFspec(Cat062UAP.ITEM_080));
        assertTrue(fspec.isItemInFspec(Cat062UAP.ITEM_290));
        assertTrue(fspec.isItemInFspec(Cat062UAP.FXBIT2));

        assertTrue(fspec.isItemInFspec(Cat062UAP.ITEM_200));
        assertFalse(fspec.isItemInFspec(Cat062UAP.ITEM_295));
        assertTrue(fspec.isItemInFspec(Cat062UAP.ITEM_136));
        assertFalse(fspec.isItemInFspec(Cat062UAP.ITEM_130));
        assertTrue(fspec.isItemInFspec(Cat062UAP.ITEM_135));
        assertTrue(fspec.isItemInFspec(Cat062UAP.ITEM_220));
        assertFalse(fspec.isItemInFspec(Cat062UAP.ITEM_390));
        assertTrue(fspec.isItemInFspec(Cat062UAP.FXBIT3));

        assertFalse(fspec.isItemInFspec(Cat062UAP.ITEM_270));
        assertFalse(fspec.isItemInFspec(Cat062UAP.ITEM_300));
        assertFalse(fspec.isItemInFspec(Cat062UAP.ITEM_110));
        assertFalse(fspec.isItemInFspec(Cat062UAP.ITEM_120));
        assertFalse(fspec.isItemInFspec(Cat062UAP.ITEM_510));
        assertFalse(fspec.isItemInFspec(Cat062UAP.ITEM_500));
        assertTrue(fspec.isItemInFspec(Cat062UAP.ITEM_340));
        assertTrue(fspec.isItemInFspec(Cat062UAP.FXBIT4));

        assertFalse(fspec.isItemInFspec(Cat062UAP.SPAREBIT2));
        assertFalse(fspec.isItemInFspec(Cat062UAP.SPAREBIT3));
        assertFalse(fspec.isItemInFspec(Cat062UAP.SPAREBIT4));
        assertFalse(fspec.isItemInFspec(Cat062UAP.SPAREBIT5));
        assertFalse(fspec.isItemInFspec(Cat062UAP.SPAREBIT6));
        assertFalse(fspec.isItemInFspec(Cat062UAP.RESERVED_EXPANSION));
        assertTrue(fspec.isItemInFspec(Cat062UAP.SPECIAL_PURPOSE));
        assertFalse(fspec.isItemInFspec(Cat062UAP.FXBIT5));
    }

    @Test
    public void should_populate_debug_message_after_parsing_fspec(){
        //arrange
        byte[] fspecInputData = new byte[]{(byte) 191,79, (byte) 173,3,2};

        //act
        Cat062Fspec fspec = new Cat062Fspec();
        fspec.decode(fspecInputData, 0, fspecInputData.length);    //5 octets => current index will increase by 5

        //assert
        logger.debug(fspec.getDebugString());
        assertNotNull(fspec.getDebugString());
    }

    @Test
    public void should_increase_current_index_after_parsing_fspec(){
        //arrange
        byte[] fspecInputData = new byte[]{(byte) 191,79, (byte) 173,3,2};

        //act
        Cat062Fspec fspec = new Cat062Fspec();
        int result = fspec.decode(fspecInputData, 0, fspecInputData.length);    //5 octets => current index will increase by 5

        //assert
        assertEquals(5, result);
    }
}
