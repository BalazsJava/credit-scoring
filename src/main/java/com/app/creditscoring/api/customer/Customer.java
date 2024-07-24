package com.app.creditscoring.api.customer;

public final class Customer {

    private Long id;
    private String name;
    private Integer age;
    private Long monthlyIncome;
    private Integer dependents;

    public Customer() {
        // Needed for JDBC
    }

    public Customer(Long id, String name, Integer age, Long monthlyIncome, Integer dependents) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.monthlyIncome = monthlyIncome;
        this.dependents = dependents;
    }

    public Customer(Long id, Customer customer) {
        this(
                id,
                customer.name(),
                customer.age(),
                customer.monthlyIncome(),
                customer.dependents()
        );
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

}
