package com.arturreinke;

import java.util.Scanner;

public class Main {

        private static Scanner scanner = new Scanner(System.in);
        private static MobilePhone mobilePhone = new MobilePhone("212122");

    public static void main(String[] args) {

        boolean quit = false;
        startphone();
        System.out.println("Welcome to main manu.");
        printInstructions();
        while(!quit){
            System.out.println("\nEnter action: (To display options press 6...)");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    mobilePhone.printMyContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    searchContact();
                    break;
                case 5:
                    removeContact();
                    break;
                case 6:
                    printInstructions();
                    break;
                case 7:
                    System.out.println("Shutting down...");
                    quit = true;
                    break;
            }

        }

    }
    private static void startphone(){
        System.out.println("Starting phone...");
    }

    private static void printInstructions(){

        System.out.println("Press:" +
                "\n1 - to print a list of contacts " +
                "\n2 - to add a new contact " +
                "\n3 - to modify an existing contact"+
                "\n4 - to search a contact"+
                "\n5 - to remove a contact"+
                "\n6 - to print instructions" +
                "\n7 - to quit");
    }

    private static void addContact(){
        System.out.println("Enter a name: ");
        String name = scanner.nextLine();
        System.out.println("Enter a phone number: ");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phoneNumber);     // czy jest jaaks roznica ?
//        mobilePhone.addMyContacts(new Contact(name,phoneNumber));

        mobilePhone.addMyContacts(newContact);
    }

    private static void modifyContact(){
        System.out.println("Enter the name of existing contact: ");
        String name = scanner.nextLine();
        Contact exsistingContactRecord = mobilePhone.queryMyContacts(name);        //////////////////////
        if (exsistingContactRecord == null){
            return;
        }

        System.out.println("Enter a new contact name: ");
        String newContactName = scanner.nextLine();
        System.out.println("Enter a phone number: ");
        String phone = scanner.nextLine();

        Contact newContact = Contact.createContact(newContactName, phone);    /////////////////
//        mobilePhone.modifyMyContacts(name, new Contact(newContactName, phone));
        mobilePhone.modifyMyContacts(exsistingContactRecord,newContact);

    }

    private static void searchContact(){
        System.out.println("Enter a contact you would like to search for: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryMyContacts(name);

        if (existingContact == null){
            System.out.println("Contact not found");
        }

        System.out.println("Name: " + existingContact.getName() + "  phone number is: " + existingContact.getPhoneNumber());

    }


    private static void removeContact(){
        System.out.println("Enter the name you would like to remove: ");
        String name = scanner.nextLine();
        Contact exsistingContactRecord = mobilePhone.queryMyContacts(name);

        if(exsistingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }else{
            mobilePhone.removeContact(exsistingContactRecord);
        }
    }


}

