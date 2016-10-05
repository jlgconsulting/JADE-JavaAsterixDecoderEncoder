/**
 * Created by alexandru on 8/9/16.
 */
package jlg.jade.test.asterix.counters;

import jlg.jade.asterix.AsterixDataBlock;
import jlg.jade.asterix.AsterixRecord;
import jlg.jade.asterix.StandardAsterixRecord;
import jlg.jade.asterix.cat048.Cat048Item010;
import jlg.jade.asterix.cat048.Cat048Item020;
import jlg.jade.asterix.cat048.Cat048Item140;
import jlg.jade.asterix.cat048.Cat048Record;
import jlg.jade.asterix.counters.Cat048ItemCounter;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

public class Cat048ItemCounterTest {

    @Test
    public void the_item_counter_should_correctly_count_present_items() {
        // arrange
        Cat048ItemCounter counter = new Cat048ItemCounter();
        Cat048Record cat048RecordMock = Mockito.mock(Cat048Record.class);
        AsterixDataBlock adbMock = Mockito.mock(AsterixDataBlock.class);

        List<AsterixRecord> asterixRecordList = new ArrayList<>();
        AsterixRecord asterixRecordOne = Mockito.mock(StandardAsterixRecord.class);

        asterixRecordList.add(asterixRecordOne);

        // act
        when(cat048RecordMock.getItem010()).thenReturn(new Cat048Item010());
        when(cat048RecordMock.getItem140()).thenReturn(new Cat048Item140());
        when(cat048RecordMock.getItem020()).thenReturn(new Cat048Item020());

        when(asterixRecordOne.getCat048Record()).thenReturn(cat048RecordMock);
        when(adbMock.getRecords()).thenReturn(asterixRecordList);

        counter.increment(adbMock);

        // assert
        assertEquals("Number of Item010 in counter should be 1", 1, counter.getItem010Present());
        assertEquals("Number of invalid item 010 in counter should be 0", 0, counter.getItem010Invalid());

        assertEquals("Number of Item140 in counter should be 1", 1, counter.getItem140Present());
        assertEquals("Number of invalid item 140 in counter should be 0", 0, counter.getItem140Invalid());

        assertEquals("Number of Item020 in counter should be 1", 1, counter.getItem020Present());
        assertEquals("Number of invalid item 020 in counter should be 0", 0, counter.getItem020Invalid());


    }
}
