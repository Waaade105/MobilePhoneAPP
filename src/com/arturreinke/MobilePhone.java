package com.arturreinke;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    private int findContact(Contact contact) {
            return this.myContacts.indexOf(contact);
    }

    private int findContact (String nameOfContact) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(nameOfContact)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addMyContacts(Contact contact) {
        if (findContact(contact) >= 0 ) {            // findContact(contact.getName()) >= 0
            System.out.println("The contact is already on file");
            return false;
        } else {
            myContacts.add(contact);
            System.out.println("The contact has been added to the list");
        }
        return true;
    }

    public void printMyContacts (){
        System.out.println("You have " + myContacts.size() + " contacts on your list.");
        for( int i = 0 ; i < this.myContacts.size(); i++){
            Contact contact = myContacts.get(i);
            System.out.println(i+1 + "." + contact.getName() + " = "+ contact.getPhoneNumber());
        }
    }

    public String queryMyContacts (Contact contact){

        int position = findContact(contact);
        if ( position >= 0 ){
           return contact.getName();
//            System.out.println("The contact "+ contact + " has the following phone number: " + myContacts.get(position).getPhoneNumber());
        }else{
            return null;
//            System .out.println("The contact " + contact +  " is not on file");
        }
    }

    public Contact queryMyContacts(String name) {
        int position = findContact(name);
        if (position  >= 0) {
            return this.myContacts.get(position);
        }else{
            return null;
        }
    }


    public boolean modifyMyContacts (Contact oldContact, Contact newContact){
        int position = findContact(oldContact);
        if (position < 0) {
            System.out.println("The contact " + oldContact + " is not on file. ");
            return false;
        }else if(findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name "+ newContact.getName() + " is already exists. " +
                    "Update was not successful. ");
            return false;
        }

        this.myContacts.set(position, newContact);
        System.out.println("The contact has been modified. The new contact is " + newContact.getName() + " = "
                + newContact.getPhoneNumber());
        return true;
    }



    public boolean removeContact (Contact contact){
        int position = findContact(contact);
        if ( position < 0 ){
            System.out.println("The contact "+ contact.getName() + " was not found");
            return false;
        }else{
            this.myContacts.remove(position);
            System.out.println("The contact " + contact.getName() + " was deleted.");
        }
        return true;
    }




}




















