package br.com.xml.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class JsonDateTimeDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        try {
            return Date.from(Instant.parse(jsonParser.getText()));
        } catch (Exception e) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(DateUtils.FormatType.YYYY_MM_DD.getFormat());
                return formatter.parse(jsonParser.getText());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
