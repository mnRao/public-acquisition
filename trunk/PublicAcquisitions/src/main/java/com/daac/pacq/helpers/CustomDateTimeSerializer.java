package com.daac.pacq.helpers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class CustomDateTimeSerializer extends JsonSerializer<Date> {

	@Override
	    public void serialize(Date value, JsonGenerator gen, SerializerProvider prov)
	            throws IOException, JsonProcessingException {
	 
	        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
	        String formattedDate = formatter.format(value);
	 
	        gen.writeString(formattedDate);
	    }
	
}
