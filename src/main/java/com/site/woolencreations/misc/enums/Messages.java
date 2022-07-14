package com.site.woolencreations.misc.enums;

public enum Messages {
    SuccessMessage("Success"),
    FailMessage("Fail"),
    IncorrectPassword("The password is incorrect"),
    IncorrectUser("The User does not exist");

    String message;
    Messages(String s) {
        this.message = s;
    }
}
