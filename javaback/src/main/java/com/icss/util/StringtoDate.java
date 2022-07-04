package com.icss.util;


import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringtoDate implements Converter<String, Date> {
    private SimpleDateFormat simpleDateFormat;

    @Override
    public Date convert(String source) {
        try {
            if (source.indexOf("/") != -1) {
                simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            }
            if (source.indexOf("-") != -1) {
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            }
            Date d = simpleDateFormat.parse(source);
            return d;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
