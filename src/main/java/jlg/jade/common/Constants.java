/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.common;

public class Constants {
    public static final String LOGGER_NAME = "jlg.jade.logger";
    public static final double LAT_LONG_WGS_PRECISION_CAT062 = 0.000005364;   //180 divided by 2^25
    public static final int FROM_ASTERIX_TO_METERS_PER_SECOND = 4;            //0.25 meters per second * 4 => 1 meter per second
    public static final double FROM_ASTERIX_MAGENTIC_HEADING_TO_DEGREES = 0.0055;
    public static final double FROM_ASTERIX_ROLL_ANGLE_TO_DEGREES = 0.01;
    public static final double FROM_ASTERIX_GROUND_SPEED_TO_KNOTS = 0.22;
    public static final double FROM_KNOT_TO_NM_PER_SECOND = 0.000277778;
}
