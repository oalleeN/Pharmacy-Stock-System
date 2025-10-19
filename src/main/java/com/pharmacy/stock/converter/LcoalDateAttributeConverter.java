package com.pharmacy.stock.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Converter(autoApply = true)
public class LcoalDateAttributeConverter implements AttributeConverter<LocalDate, String> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public String convertToDatabaseColumn(LocalDate date) {
        return (date == null ? null : date.format(FORMATTER));
    }

    @Override
    public LocalDate convertToEntityAttribute(String dateStr) {
        return (dateStr == null ? null : LocalDate.parse(dateStr, FORMATTER));
    }
}
