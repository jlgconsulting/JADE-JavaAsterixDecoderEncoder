/**
 * Created by Dan Geabunea on 7/8/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item030MessageType;
import jlg.jade.asterix.cat150.Cat150Item110RvsmStatus;
import jlg.jade.asterix.cat150.Cat150Record;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;

import static org.junit.Assert.assertEquals;

public class Cat150RecordTest extends MandatoryFspecAsterixTests<Cat150Record> {
    @Override
    protected Cat150Record setDataFieldInstance() {
        return new Cat150Record();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return 4;
    }

    private final byte[] SAMPLE_INPUT = {
            57, (byte) 255, (byte) 227, 4, 2, 1, (byte) 224, 68, 76, 72,
            54, 51, 49, 32, 79, 77, 68, 66, 69, 68, 68,
            70, 0, 0, 48, 48, 65, 51, 52, 54,
            72, 52, 48, 48, 8, 1, 77, 69, 71, 73, 75,
            32, 32, 32, 32, 32, 32, 1, 88, 90, 87,
            57, 57, 32, 32, 32, 32, 32, 32, 1, 80,
            65, 84, 65, 75, 32, 32, 32, 32, 32, 32,
            1, 76, 65, 76, 69, 83, 32, 32, 32, 32, 32, 32,
            1, 52, 56, 53, 51, 78, 48, 49, 55, 51, 56, 69,
            1, 66, 65, 66, 85, 83, 32, 32, 32, 32, 32, 32,
            1, 83, 79, 80, 71, 65, 32, 32, 32, 32, 32, 32,
            1, 82, 65, 80, 69, 84, 32, 32, 32, 32, 32, 32,
            8, 0, (byte) 203, (byte) 207, 115, (byte) 251, (byte) 230, 100, 117,
            (byte) 131, (byte) 238, (byte) 229, 124, (byte) 148, 46, (byte) 148,
            (byte) 211, (byte) 193, 99, (byte) 230, 27, 74, (byte) 238, (byte) 190, 64, (byte)
            207, 48,
            28, 105, 102, 16, (byte) 211, (byte) 162, 8, 48, 50, 49, 51, 48,
            50, 50, 57, 48, 50, 51, 48, 48, 50, 51, 57, 48, 50, 52,
            48, 48, 50, 52, 50, 48, 51, 48, 55, 48, 51, 48, 57,
            8, 52, 48, 48, 52, 48, 48, 52, 48, 48, 52, 48, 48, 52, 48, 48,
            52, 48, 48, 52, 48, 48, 52, 48, 48, 30, 117, 8, 52, 48, 48,
            52, 48, 48, 52, 48, 48, 52, 48, 48, 52, 48, 48, 52, 48, 48,
            52, 48, 48, 52, 48, 48
    };

    @Override
    public void the_decode_method_should_correctly_populate_fspec_field() {
        //arrange
        int offset = 0;
        Cat150Record cat150Record = new Cat150Record();

        //act
        cat150Record.decode(SAMPLE_INPUT, offset, SAMPLE_INPUT.length);

        //assert
        assertEquals("FSPEC actual size invalid", 4, cat150Record.getActualFspecSizeInBytes());
        assertEquals("Nb of present fields is invalid", 15, cat150Record.getNbPresentDataFields());

        assertEquals("FSPEC not decoded correctly - 030", true, cat150Record.fspecDataAtIndex(5));
        assertEquals("FSPEC not decoded correctly - 040", true, cat150Record.fspecDataAtIndex(4));
        assertEquals("FSPEC not decoded correctly - 050", true, cat150Record.fspecDataAtIndex(3));
        assertEquals("FSPEC not decoded correctly - 080", true, cat150Record.fspecDataAtIndex(15));
        assertEquals("FSPEC not decoded correctly - 090", true, cat150Record.fspecDataAtIndex(14));
        assertEquals("FSPEC not decoded correctly - 100", true, cat150Record.fspecDataAtIndex(13));
        assertEquals("FSPEC not decoded correctly - 110", true, cat150Record.fspecDataAtIndex(12));
        assertEquals("FSPEC not decoded correctly - 120", true, cat150Record.fspecDataAtIndex(11));
        assertEquals("FSPEC not decoded correctly - 130", true, cat150Record.fspecDataAtIndex(10));
        assertEquals("FSPEC not decoded correctly - 140", true, cat150Record.fspecDataAtIndex(9));
        assertEquals("FSPEC not decoded correctly - 150", true, cat150Record.fspecDataAtIndex(23));
        assertEquals("FSPEC not decoded correctly - 160", true, cat150Record.fspecDataAtIndex(22));
        assertEquals("FSPEC not decoded correctly - 170", true, cat150Record.fspecDataAtIndex(21));
        assertEquals("FSPEC not decoded correctly - 210", true, cat150Record.fspecDataAtIndex(17));
        assertEquals("FSPEC not decoded correctly - 171", true, cat150Record.fspecDataAtIndex(26));
    }

    @Override
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        int offset = 0;
        Cat150Record cat150Record = new Cat150Record();

        //act
        cat150Record.decode(SAMPLE_INPUT, offset, SAMPLE_INPUT.length);

        //assert
        assertEquals("Item nor decoded correctly - 030",
                Cat150Item030MessageType.FLIGHT_PLAN_MODIFICATION,
                cat150Record.getItem030().getMessageType());
        assertEquals("Item not decoded correctly - 040",
                480, cat150Record.getItem040().getPlanNumber());
        assertEquals("Item not decoded correctly - 050",
                "DLH631", cat150Record.getItem050().getCallsign());
        assertEquals("Item not decoded correctly - 080",
                "OMDB", cat150Record.getItem080().getDepartureAerodrome());
        assertEquals("Item not decoded correctly - 090",
                "EDDF", cat150Record.getItem090().getDestinationAerodrome());
        assertEquals("Item not decoded correctly - 100", false,
                cat150Record.getItem100().getGatFlag());
        assertEquals("Item not decoded correctly - 100", false,
                cat150Record.getItem100().getCplFlag());
        assertEquals("Item not decoded correctly - 100", false,
                cat150Record.getItem100().getOatFlag());
        assertEquals("Item not decoded correctly - 100", false,
                cat150Record.getItem100().getSpnFlag());
        assertEquals("Item not decoded correctly - 110", Cat150Item110RvsmStatus.UNKNOWN,
                cat150Record.getItem110().getRvsmStatus());
        assertEquals("Item not decoded correctly - 110", false,
                cat150Record.getItem110().getHoldFlag());
        assertEquals("Item not decoded correctly - 120", 0,
                cat150Record.getItem120().getNumberOfAircraft());
        assertEquals("Item not decoded correctly - 120", "A346",
                cat150Record.getItem120().getTypeOfAircraft());
        assertEquals("Item not decoded correctly - 120", "H",
                cat150Record.getItem120().getWakeTurbulence());
        assertEquals("Item not decoded correctly -130", 400,
                cat150Record.getItem130().getClearedFLightLevel());

    }
}
