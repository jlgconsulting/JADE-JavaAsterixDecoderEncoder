/**
 * Created by alexandru on 10/5/16.
 */
package jlg.jade.asterix;

import jlg.jade.asterix.cat004.Cat004Record;
import jlg.jade.asterix.cat034.Cat034Record;
import jlg.jade.asterix.cat048.Cat048Record;
import jlg.jade.asterix.cat062.Cat062Record;
import jlg.jade.asterix.cat065.Cat065Record;
import jlg.jade.asterix.cat150.Cat150Record;
import jlg.jade.common.Decodable;
import jlg.jade.common.Encodable;

import java.util.AbstractMap;

public interface AsterixRecord extends Decodable, Encodable {
    int getCategory();

    Cat062Record getCat062Record();

    Cat065Record getCat065Record();

    Cat004Record getCat004Record();

    Cat034Record getCat034Record();

    Cat048Record getCat048Record();

    Cat150Record getCat150Record();

    String getDebugString();

    AbstractMap<String, Object> getAdditionalInfo();
    
    String getSacSicCode();
}
