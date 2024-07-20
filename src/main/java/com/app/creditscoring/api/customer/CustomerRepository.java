package com.app.creditscoring.api.customer;

import com.app.creditscoring.config.jdbc.BeanSqlParameterSource;
import com.app.creditscoring.config.jdbc.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public class CustomerRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CustomerRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long save(Customer entity) {
        String sql = """
                INSERT INTO customer
                (name, age, monthly_income, dependents) VALUES
                (:name, :age, :monthlyIncome, :dependents)
                                
                ON DUPLICATE KEY UPDATE
                    name = VALUES(name),
                    age = VALUES(age),
                    monthly_income = VALUES(monthly_income),
                    dependents = VALUES(dependents)
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                sql,
                new BeanSqlParameterSource(entity),
                keyHolder
        );

        return Optional.ofNullable(keyHolder.getKeyAs(BigInteger.class))
                .orElseThrow()
                .longValue();
    }

    public Optional<Customer> findById(String customerId) {
        String sql = """
                SELECT name, age, monthly_income, dependents
                FROM customer
                WHERE id = :id
                """;

        return JdbcUtil.singleResult(
                jdbcTemplate.query(
                        sql,
                        new MapSqlParameterSource("id", customerId),
                        BeanPropertyRowMapper.newInstance(Customer.class)
                )
        );
    }

}
