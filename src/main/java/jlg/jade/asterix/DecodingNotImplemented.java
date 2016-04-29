package jlg.jade.asterix;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface DecodingNotImplemented {
    String reason();

}
