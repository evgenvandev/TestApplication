package ru.cit.entity;

import java.util.List;

/**
 * Class contact from the phone book
 */
public class Contact {

    /**
     * Last name
     */
    private String lastName;

    /**
     * List number phone
     */
    private List<String> numberPhone;

    /**
     * Cunstructor with two arguments
     * @param lastName, numberPhone
     */
    public Contact(String lastName, List<String> numberPhone) {
        this.lastName = lastName;
        this.numberPhone = numberPhone;
    }

    // Start block getters and setters
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(List<String> numberPhone) {
        this.numberPhone = numberPhone;
    }
    // End block getters and setters

    /**
     * Display ranging list phones
     * @return String ranging list phones
     */
    public String rangingPhones() {
        String rangStr = "";
        int i = 1;
        for (String number : numberPhone) {
            rangStr = String.format("%s%s", rangStr, String.format("%d. %s\n", i, number));
            i++;
        }
        return rangStr;
    }

    /**
     * String representation contact
     * @return String contact
     */
    @Override
    public String toString() {
        return String.format("Фамилия Имя Отчество: %s\n" +
                "номера телефонов: %s", lastName, numberPhone);
    }
}
