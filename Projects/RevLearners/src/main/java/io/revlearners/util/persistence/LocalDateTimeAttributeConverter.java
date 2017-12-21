package io.revlearners.util.persistence;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime ldt) {
		return ldt == null ? null : Timestamp.valueOf(ldt);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp ts) {
		return ts == null ? null : ts.toLocalDateTime();
	}

}
