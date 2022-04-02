package com.company;

import com.company.controller.Controller;
import com.company.model.Email;
import com.company.model.EmailType;
import com.company.model.Number;
import com.company.model.PhoneNumberType;

import java.lang.invoke.SwitchPoint;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GUI {
    static Scanner sc = new Scanner(System.in);
    static Controller controller = new Controller();

    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean stop = false;
        while (!stop) {
            System.out.println("Add new contact.... press 1");
            System.out.println("Add in existing contact... press 2");
            System.out.println("Update existing contact...press 3");
            System.out.println("Add email in existing contact4");
            System.out.println("Show all contacts...press5");
            System.out.println("Delete contact...press6");
            System.out.println("For exit...press 0");

            int step = sc.nextInt();

            switch (step) {
                case 1 -> addNew();
                case 2 -> addNumberInExist();
                case 3 -> updateExistingNumber();
                case 5 -> showAll();
                case 4 -> addEmailInExist();
                case 6 -> delete();
                case 0 -> stop = true;
                default -> {
                }
            }
        }
    }

    public void addNew() {
        System.out.println("Add contact name");
        String name = sc.next();


        System.out.println("Add number");
        String number = sc.next();


        List<Number> numbers = new LinkedList<>();
        numbers.add(new Number(number, selectPhoneType()));


        String company = "";

        boolean isCorrectAnswer = false;

        while (!isCorrectAnswer) {
            System.out.println("Add Company Y/N");
            String answer = sc.next();
            switch (answer) {

                case "Y":
                    System.out.println("Insert company name");
                    company = sc.next();
                    isCorrectAnswer = true;
                    break;

                case "N":
                    isCorrectAnswer = true;
                    break;
                default:
                    System.out.println("Choose correct answer");
            }
        }


        controller.create(name, numbers, addEmail(name), company);
    }

    public void addNumberInExist() {
        if (controller.getAllNames() == "") {
            System.out.println("Empty list");
            start();
        } else {
            System.out.println(controller.getAllNames());
            System.out.println("Choose contact");
            String name = sc.next();

            System.out.println("Add number");
            String number = sc.next();

            controller.addNumberInExisting(name, number, selectPhoneType());
        }
    }

    public void addEmailInExist() {
        if (controller.getAllNames() == "") {
            System.out.println("Empty list");
            start();
        } else {
            System.out.println(controller.getAllNames());
            System.out.println("Choose contact");
            String name = sc.next();
            System.out.println("New Email");
            String email = sc.next();
            EmailType emailType = selectEmailType();
            controller.addEmailInExisting(name, email, emailType);


        }
    }

    public void showAll() {
        controller.showAll();
    }

    public void delete() {
        System.out.println(controller.getAllNames());

        System.out.println("Choose contact");
        String name = sc.next();
        controller.delete(name);
    }

    public void updateExistingNumber() {
        if (controller.getAllNames() == "") {
            System.out.println("Empty list");
            start();
        } else {
            System.out.println(controller.getAllNames());

            System.out.println("Choose contact");
            String name = sc.next();

            System.out.println(controller.showUserAllNumber(name));

            System.out.println("What row you want update?");
            int index = sc.nextInt();

            System.out.println("Add new number");
            String number = sc.next();

            controller.update(name, number, selectPhoneType(), index);
        }
    }

    private static PhoneNumberType selectPhoneType() {
        System.out.println("Add number type");
        System.out.println("""
                1: HOME
                2: SCHOOL
                3: WORK
                4: MOBILE
                """);
        int numberType = sc.nextInt();
        PhoneNumberType phoneNumberType = PhoneNumberType.HOME;
        switch (numberType) {
            case 1:
                phoneNumberType = PhoneNumberType.HOME;
                break;
            case 2:
                phoneNumberType = PhoneNumberType.SCHOOL;
                break;
            case 3:
                phoneNumberType = PhoneNumberType.WORK;
                break;
            case 4:
                phoneNumberType = PhoneNumberType.MOBILE;
        }
        return phoneNumberType;
    }

    private static EmailType selectEmailType() {
        System.out.println("Add email type");
        System.out.println("""
                1: GMAIL
                2: ICLOUD
                3: OTHER
                """);
        int email = sc.nextInt();
        EmailType emailType = EmailType.OTHER;
        switch (email) {
            case 1:
                emailType = EmailType.GMAIL;
                break;
            case 2:
                emailType = EmailType.ICLOUD;
                break;
            case 3:
                emailType = EmailType.OTHER;
                break;
        }
        return emailType;
    }

    private List<Email> addEmail(String name) {

        List<Email> emails = null;
        boolean isCorrectAnswer = false;
        String email = "";
        while (!isCorrectAnswer) {
            System.out.println("Add email Y/N");
            String answer = sc.next();
            switch (answer) {
                case "Y": {
                    System.out.println("email");
                    email = sc.next();
                    emails = new LinkedList<>();
                    emails.add(new Email(email, selectEmailType()));
                    isCorrectAnswer = true;
                    break;
                }
                case "N":
                    email = null;
                    isCorrectAnswer = true;
                    break;
                default:
                    System.out.println("Choose correct answer");
            }
        }
        return emails;

    }

}

