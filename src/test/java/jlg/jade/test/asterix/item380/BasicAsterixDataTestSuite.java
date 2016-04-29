/* 
* Created by dan-geabunea on 4/28/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item380;

/**
 * A template that shall be implemneted by all test classes that check
 * the functionality of Asterix data fields. More specific tests can be added
 * to the concrete test classes
 */
public interface BasicAsterixDataTestSuite {

    void should_have_length_correct_length();

    void the_decode_method_should_increment_offset_after_decoding_data();
}
