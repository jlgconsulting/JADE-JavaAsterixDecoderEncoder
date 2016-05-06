/*
* Created by dan-geabunea on 5/4/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/

package jlg.jade.test.utils;

/**
 * A template that shall be implemneted by all test classes that check
 * the functionality of Asterix data fields. More specific tests can be added
 * to the concrete test classes
 */
public interface BasicRepeatableAsterixDataTestSuite {
    void repeatable_block_size_should_be_correct();

    void the_decode_method_should_calculate_correct_size();

    void the_decode_method_should_increment_offset_after_decoding_data();
}
