package br.terna.inter.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class CustomYearMonthSerializer extends StdSerializer<YearMonth> {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

    public CustomYearMonthSerializer() {
        this(null);
    }

    public CustomYearMonthSerializer(Class<YearMonth> t) {
        super(t);
    }

    @Override
    public void serialize(YearMonth value, JsonGenerator gen, SerializerProvider arg2) throws IOException, JsonProcessingException {
        gen.writeString(formatter.format(value));
    }
}