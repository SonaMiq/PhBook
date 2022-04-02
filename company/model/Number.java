package com.company.model;

public class Number {
  private   String number;
  private   PhoneNumberType type;

    public Number(String number, PhoneNumberType type) {
        this.number = number;
        this.type = type;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneNumberType getType() {
        return type;
    }

    public void setType(PhoneNumberType type) {
        this.type = type;
    }
}
