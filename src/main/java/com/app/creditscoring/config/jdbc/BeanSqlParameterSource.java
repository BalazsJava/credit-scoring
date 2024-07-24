package com.app.creditscoring.config.jdbc;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.lang.NonNull;

public class BeanSqlParameterSource extends BeanPropertySqlParameterSource {

    public BeanSqlParameterSource(Object object) {
        super(object);
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