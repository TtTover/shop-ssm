package com.gec.config;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        //将接受到的日期格式转换层日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(s);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}