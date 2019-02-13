package ru.cit;

import ru.cit.DataBase.DbContact;
import ru.cit.entity.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for start
 */
public class StartMain {

    public static void main(String[] args) {

        /**
         * Initializing and getting data base the contacts
         */
        DbContact dbContacts = getDbContact();


        /*String findContact = findContact(args, dbContacts);
        System.out.println(findContact);*/

        /*System.out.println("Контактов в базе: " + dbContacts.countContacts());
        dbContacts.displayContacts();*/

        Scanner reader = new Scanner(System.in);
        try {
            String exit = "нет";
            while (!exit.equals("да")) {
                System.out.println("Введите Фамилию Имя Отчество:");
                String lastName = reader.nextLine();
                Contact findCon = dbContacts.findContact(lastName);
                if (findCon != null){
                    System.out.println(findCon.rangingPhones());
                } else {
                    System.out.println("Такой Фамилии Имени Отчества нет в базе данных.");
                }
                System.out.println("Выйти из программы : да/нет ?");
                exit = reader.nextLine();
            }
        } finally {
            reader.close();
        }
    }

    public static String findContact(String[] args, DbContact dbContacts) {

        String strRang = "";
        for (String arg : args) {
            if (arg != null) {
                Contact findCon = dbContacts.findContact(arg);
                if (findCon != null) {
                    strRang = findCon.rangingPhones();
                } else {
                    strRang = "Такой Фамилии Имени Отчества нет в базе данных.";
                }
            } else {
                System.out.println("Вы не ввели Фамилию Имя Отчество при запуске программы.");
            }
        }

        return strRang;
    }

    /**
     * Initializing and getting data base the contacts
     * @return DbContact dbContacts
     */
    public static DbContact getDbContact() {
        List<String> phones1 = new ArrayList<String>();
        phones1.add(0, "+8 800 2000 500");
        phones1.add(1, "+8 800 200 600");

        List<String> phones2 = new ArrayList<String>();
        phones2.add(0, "+8 800 2000 700");

        List<String> phones3 = new ArrayList<String>();
        phones3.add(0, "+8 800 2000 800");
        phones3.add(1, "+8 800 2000 900");
        phones3.add(2, "+8 800 2000 000");

        Contact[] contacts = {new Contact("Иванов И.И.", phones1),
                                new Contact("Петров П.П.", phones2),
                                new Contact("Сидоров С.С.", phones3)};

        DbContact dbContacts = new DbContact();
        for (Contact contact : contacts) {
            dbContacts.addContact(contact);
        }
        return dbContacts;
    }
}
