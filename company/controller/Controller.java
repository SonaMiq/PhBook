package com.company.controller;

import com.company.Contact;
import com.company.model.*;
import com.company.model.Number;
import com.company.services.EmailService;
import com.company.services.PhoneService;
import com.company.services.UserService;

import java.util.LinkedList;
import java.util.List;

public class Controller {
    PhoneService phoneService = new PhoneService();
    UserService userService = new UserService();
    EmailService emailService = new EmailService();

    public void create(String userName, List<Number> numbers, List<Email> emails, String company) {
        phoneService.addNew(userName, new User(numbers, emails, company));
    }

    public void delete(String name) {
        phoneService.delete(name);
    }

    public void addNumberInExisting(String userName, String number, PhoneNumberType phoneNumberType) {
        userService.addNumber(Contact.contacts.get(userName), new Number(number, phoneNumberType));
    }

    public void addEmailInExisting(String userName, String email, EmailType emailType) {
       try {
           emailService.addEmail(Contact.contacts.get(userName), new Email(email, emailType));
       }
       catch (NullPointerException e) {
           List<Email> emails=new LinkedList<>() ;
           emails.add(new Email(email, emailType));
           Contact.contacts.get(userName).setEmails(emails);
       }
    }

    public void update(String userName, String number, PhoneNumberType phoneNumberType, int index) {
        phoneService.update(userName, number, phoneNumberType, index);
    }

    public String showUserAllNumber(String name) {
        return userService.contactNumbers(Contact.contacts.get(name));
    }

    public String getAllNames() {
        return phoneService.printContactNames();
    }

    public void showAll() {
        System.out.println("---------------");
        for (String name : Contact.contacts.keySet()) {
            User user = Contact.contacts.get(name);
            System.out.println(name + "\n" + userService.contactNumbers(user) +emailService.contactEmails(user)+
                    " " + user.getCompany());
            System.out.println("---------------");
        }
    }
}

