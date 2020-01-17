package com.arturreinke;

public class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String number){
        this.name = name;
        this.phoneNumber = number;
    }
    public String getName(){
        return name;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Contact)obj).getName());
    }

    public static Contact createContact(String name, String phoneNumber){
        return new Contact(name, phoneNumber);
    }
}
