package org.example;

public record Player(String firstName, String lastName, String team) {

    public String fullName(){
        return firstName + " " + lastName;
    }
}
