package com.app.creditscoring.config.jdbc;

import org.springframework.dao.support.DataAccessUtils;

import java.util.List;
import java.util.Optional;

public class JdbcUtil {

    public static  <T> Optional<T> singleResult(List<T> object) {
        T singleResult = DataAccessUtils.singleResult(object);
        return Optional.ofNullable(singleResult);
    }

}
