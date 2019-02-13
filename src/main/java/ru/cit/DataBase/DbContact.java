package ru.cit.DataBase;

import ru.cit.entity.Contact;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class DataBase contact
 */
public class DbContact {

    /**
     *  Field for storage contacts
     */
    private Map<String, List<String>> dbContacts;

    /**
     *  Constructor for initialization field dbContacts
     *  without parameters
     */
    public DbContact() {
        dbContacts = new HashMap<String, List<String>>();
    }

    /**
     *  Adding contact to DataBase contact
     *  @param contact
     */
    public void addContact(Contact contact) {

       dbContacts.put(contact.getLastName(), contact.getNumberPhone());
    }


    /**
     *  Find contact in DataBase contacts
     *  @param lastName
     *  @return Contact contact
     */
    public Contact findContact(String lastName) {
        Contact contact = null;
        if (dbContacts.containsKey(lastName)) {
            List<String> phones = dbContacts.get(lastName);
            contact = new Contact(lastName, phones);
        }

        return contact;
    }

    /**
     *  Display count contacts
     *  @return int size dbContacts
     */
    public int countContacts() {

        return dbContacts.size();
    }

    /**
     *  Display list contacts
     */
    public void displayContacts() {

        for (Map.Entry<String, List<String>> listEntry : dbContacts.entrySet()) {
            System.out.println(listEntry);
        }
    }
}
