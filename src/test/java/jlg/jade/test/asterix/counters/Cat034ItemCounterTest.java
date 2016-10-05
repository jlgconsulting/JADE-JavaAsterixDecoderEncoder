/**
 * Created by alexandru on 7/12/16.
 */
package jlg.jade.test.asterix.counters;

import jlg.jade.asterix.AsterixDataBlock;
import jlg.jade.asterix.AsterixRecord;
import jlg.jade.asterix.AsterixRecordBase;
import jlg.jade.asterix.cat034.Cat034Item000;
import jlg.jade.asterix.cat034.Cat034Item010;
import jlg.jade.asterix.cat034.Cat034Item030;
import jlg.jade.asterix.cat034.Cat034Record;
import jlg.jade.asterix.counters.Cat034ItemCounter;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class Cat034ItemCounterTest {

    @Test
    public void the_item_counter_should_correctly_count_present_items() {
        // arrange
        Cat034ItemCounter counter = new Cat034ItemCounter();
        Cat034Record cat034RecordMock = Mockito.mock(Cat034Record.class);
        AsterixDataBlock adbMock = Mockito.mock(AsterixDataBlock.class);

        List<AsterixRecord> asterixRecordList = new ArrayList<>();
        AsterixRecord asterixRecordOne = Mockito.mock(AsterixRecordBase.class);

        asterixRecordList.add(asterixRecordOne);

        // act

        // add items to mocked cat 034 record
        when(cat034RecordMock.getItem010()).thenReturn(new Cat034Item010());
        when(cat034RecordMock.getItem000()).thenReturn(new Cat034Item000());
        when(cat034RecordMock.getItem030()).thenReturn(new Cat034Item030());

        // mock the asterixRecordOne getCat034Record() to return our cat 034 record mock
        when(asterixRecordOne.getCat034Record()).thenReturn(cat034RecordMock);

        // mock the Asterix data block getRecords() method to return the list with our AsterixRecordBase
        when(adbMock.getRecords()).thenReturn(asterixRecordList);

        counter.increment(adbMock);

        // assert
        assertEquals("Number of Item 010 in counter should be 1", 1, counter.getItem010Present());
        assertEquals("Number of invalid item 010 in counter should be 0", 0,
                     counter.getItem010Invalid());

        assertEquals("Number of Item 000 in counter should be 1", 1, counter.getItem000Present());
        assertEquals("Number of invalid item 010 in counter should be 0", 0,
                     counter.getItem000Invalid());

        assertEquals("Number of Item 030 in counter should be 1", 1, counter.getItem030Present());
        assertEquals("Number of invalid item 030 in counter should be 0", 0,
                     counter.getItem030Invalid());

    }
}
