/**
 * Created by alexandru on 9/14/16.
 */
package jlg.jade.asterix.cat048;

public enum Cat048Item260BitSetIndexes {
    // TTI
    TTI_BIT1_INDEX(27),
    TTI_BIT0_INDEX(26),
    BIT_C1_INDEX(25),
    // TID Altitude ModeC indexes in order
    BIT_A1_INDEX(24),
    BIT_C2_INDEX(39),
    BIT_A2_INDEX(38),
    BIT_C4_INDEX (37),
    BIT_A4_INDEX(36),
    BIT_B1_INDEX(34),
    BIT_B2_INDEX(32),
    BIT_D2_INDEX(47),
    BIT_B4_INDEX(46),
    BIT_D4_INDEX(45),
    // TID Range indexes in bit set
    BIT_TID_RANGE1_INDEX(44),
    BIT_TID_RANGE2_INDEX(43),
    BIT_TID_RANGE3_INDEX(42),
    BIT_TID_RANGE4_INDEX(41),
    BIT_TID_RANGE5_INDEX(40),
    BIT_TID_RANGE6_INDEX(55),
    BIT_TID_RANGE7_INDEX(54),
    // TID Bearing indexes in bit set
    BIT_TID_BEARING1_INDEX(53),
    BIT_TID_BEARING2_INDEX(52),
    BIT_TID_BEARING3_INDEX(51),
    BIT_TID_BEARING4_INDEX(50),
    BIT_TID_BEARING5_INDEX(49),
    BIT_TID_BEARING6_INDEX(48),
    // ARA - bits 41-50
    ARA_BIT41_INDEX(15),
    ARA_BIT42_INDEX(14),
    ARA_BIT43_INDEX(13),
    ARA_BIT44_INDEX(12),
    ARA_BIT45_INDEX(11),
    ARA_BIT46_INDEX(10),
    ARA_BIT47_INDEX(9),
    ARA_BIT48_INDEX(8),
    ARA_BIT49_INDEX(23),
    ARA_BIT50_INDEX(22),
    // MTI / MTE
    MTI_BIT_INDEX(28),
    // RAT
    RAT_BIT_INDEX(29),
    // RAC
    RAC_BIT1_INDEX(17),
    RAC_BIT2_INDEX(16),
    RAC_BIT3_INDEX(31),
    RAC_BIT4_INDEX(30);

    private final int value;

    Cat048Item260BitSetIndexes(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
