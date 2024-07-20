package com.app.creditscoring.api.customer;

import java.util.Objects;

public final class Customer {
    private Long id;
    private String name;
    private Integer age;
    private Long monthlyIncome;
    private Integer dependents;

    public Customer() {
    }

    public Customer(Long id, String name, Integer age, Long monthlyIncome, Integer dependents) {
        // These may not be null, or an error will occur
//        Objects.requireNonNull(name);
//        Objects.requireNonNull(age);
//        Objects.requireNonNull(monthlyIncome);
        this.id = id;
        this.name = name;
        this.age = age;
        this.monthlyIncome = monthlyIncome;
        this.dependents = dependents;
    }

    public Customer(Long id, Customer customer) {
        this(id, customer.name(), customer.age(),
                customer.monthlyIncome(), customer.dependents());
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Integer age() {
        return age;
    }

    public Long monthlyIncome() {
        return monthlyIncome;
    }

    public Integer dependents() {
        return dependents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Long monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public Integer getDependents() {
        return dependents;
    }

    public void setDependents(Integer dependents) {
        this.dependents = dependents;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Customer) obj;
        return Objects.equals(this.id, that.id) &&
               Objects.equals(this.name, that.name) &&
               Objects.equals(this.age, that.age) &&
               Objects.equals(this.monthlyIncome, that.monthlyIncome) &&
               Objects.equals(this.dependents, that.dependents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, monthlyIncome, dependents);
    }

    @Override
    public String toString() {
        return "Customer[" +
               "id=" + id + ", " +
               "name=" + name + ", " +
               "age=" + age + ", " +
               "monthlyIncome=" + monthlyIncome + ", " +
               "dependents=" + dependents + ']';
    }

}
