package it.cosenonjaviste.testableandroidapps.v4;

import it.cosenonjaviste.testableandroidapps.model.Post;

public class EmailSender {
    public void sendEmail(Post p) {
        System.out.println("email " + p.getTitle() + " sent!");
    }
}
