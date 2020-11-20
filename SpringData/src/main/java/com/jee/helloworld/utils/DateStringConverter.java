package com.jee.helloworld.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Converter(autoApply = true)
public class DateStringConverter implements AttributeConverter<String, Date> {

	@Override
	public Date convertToDatabaseColumn(String entityDate) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(entityDate);
		} catch (ParseException pE) {
			pE.printStackTrace();
		}
		return new Date();
	}

	@Override
	public String convertToEntityAttribute(Date databaseDate) {
		return databaseDate.toString();
	}
}