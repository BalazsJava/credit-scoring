package com.app.creditscoring.config.jdbc;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.lang.NonNull;

import java.util.List;

public class BeanSqlParameterSource extends BeanPropertySqlParameterSource {

    public BeanSqlParameterSource(Object object) {
        super(object);
    }

    public static BeanSqlParameterSource[] toParameters(List<? extends Object> entities) {
        return entities
                .stream()
                .map(BeanSqlParameterSource::new)
                .toArray(BeanSqlParameterSource[]::new);
    }

    @Override
    public Object getValue(@NonNull String paramName) {
        Object object = super.getValue(paramName);

        if (object == null) {
            return null;
        } else if (object instanceof Enum) {
            return object.toString();
        }
        return object;
    }
}