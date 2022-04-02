package com.company.model;

import java.util.List;

public class User {

    private List<Number> numbers;
    private List<Email> emails;
    private String company;

    public User(List<Number> numbers, List<Email> emails, String company) {
        this.numbers = numbers;
        this.emails = emails;
        this.company = company;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public String getCompany() {
        return company;
    }
}
