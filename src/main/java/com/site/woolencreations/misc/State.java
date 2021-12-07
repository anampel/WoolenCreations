package com.site.woolencreations.misc;

public enum State {
    IN_REVIEW("IN REVIEW"),
    PAID("PAID"),
    IN_PROGRESS("IN PROGRESS"),
    SENT("SENT");

    String state;

    State(String value){
        this.state =  value;

    }


}
