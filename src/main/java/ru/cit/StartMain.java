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

        System.out.println("Контактов в базе: " + dbContacts.countContacts());
        dbContacts.displayContacts();

        Scanner reader = new Scanner(System.in);
        try {
            String exit = "no";
            while (!exit.equals("yes")) {
                System.out.println("Введите Фамилию Имя Отчество:");
                String lastName = reader.nextLine();
                Contact findCon = dbContacts.findContact(lastName);
                if (findCon != null){
                    //String dbLastName = findCon.getLastName();
                    System.out.println(findCon.rangingPhones());
                } else {
                    System.out.println("Такой Фамилии Имени Отчества нет в базе данных.");
                }
                System.out.println("Exit : yes/no ?");
                exit = reader.nextLine();
            }
        } finally {
            reader.close();
        }
    }
}
