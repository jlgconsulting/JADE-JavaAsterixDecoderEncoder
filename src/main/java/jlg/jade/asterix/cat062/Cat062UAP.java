/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

/**
 * The UAP enum maps the Asterix Cat-062 UAP bits. The order and value of the enum are
 * extremely important as the enum value will be used as in index to read the Cat062 FSPEC.
 * The order of the items has been taken from the Cat-062 ICD, page 129. For each byte of
 * data, we have mapped the position of each bit (reverse order as this is the way data is
 * represented as BitSet
 */
public enum Cat062UAP {
    //first byte
    FXBIT1,
    ITEM_185,
    ITEM_100,
    ITEM_105,
    ITEM_070,
    ITEM_015,
    SPAREBIT1,
    ITEM_010,

    //second byte
    FXBIT2,
    ITEM_290,
    ITEM_080,
    ITEM_040,
    ITEM_380,
    ITEM_245,
    ITEM_060,
    ITEM_210,

    //third byte
    FXBIT3,
    ITEM_390,
    ITEM_220,
    ITEM_135,
    ITEM_130,
    ITEM_136,
    ITEM_295,
    ITEM_200,

    //fourth byte
    FXBIT4,
    ITEM_340,
    ITEM_500,
    ITEM_510,
    ITEM_120,
    ITEM_110,
    ITEM_300,
    ITEM_270,

    //fifth byte
    FXBIT5,
    SPECIAL_PURPOSE,
    RESERVED_EXPANSION,
    SPAREBIT2,
    SPAREBIT3,
    SPAREBIT4,
    SPAREBIT5,
    SPAREBIT6
}
