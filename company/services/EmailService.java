package com.company.services;

import com.company.model.Email;
import com.company.model.User;

public class EmailService extends Throwable  {

    public void addEmail(User user, Email email) {
            user.getEmails().add(email);

    }

    public String contactEmails(User user) {
        StringBuilder str = new StringBuilder("");
        try {
            for (Email email : user.getEmails()) {
                str.append(email.getType() + " " + email.getEmail() + "\n");
            }
        }
        catch (NullPointerException e){

        }
        return str.toString();
    }
}
