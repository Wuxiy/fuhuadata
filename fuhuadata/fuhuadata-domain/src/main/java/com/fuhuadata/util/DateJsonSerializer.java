package com.fuhuadata.util;


import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * date序列化json
 * Created by intanswer on 2017/2/8.
 */
public class DateJsonSerializer extends JsonSerializer<Date> {

    public static final SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeString(format.format(date));
    }

}
