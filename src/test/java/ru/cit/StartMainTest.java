package ru.cit;

import org.junit.Assert;
import org.junit.Test;
import ru.cit.DataBase.DbContact;
import ru.cit.entity.Contact;

import static org.junit.Assert.*;

/**
 * Main test class
 */
public class StartMainTest {

    @Test
    /**
     * Test main
     */
    public void testMain() {

        String[] args = { "Иванов И.И." };
        //StartMain.main(args);
        DbContact dbContacts = StartMain.getDbContact();
        assertEquals("1. +8 800 2000 500\n" +
                "2. +8 800 200 600\n", StartMain.findContact(args, dbContacts));
    }

    @Test
    /**
     * Test main
     */
    public void testMain_1() {

        String[] args = { "Сидоров С.С." };
        //StartMain.main(args);
        DbContact dbContacts = StartMain.getDbContact();
        assertEquals("1. +8 800 2000 800\n" +
                "2. +8 800 2000 900\n" +
                "3. +8 800 2000 000\n", StartMain.findContact(args, dbContacts));
    }

    @Test
    /**
     * Test main
     */
    public void testMainNot() {

        String[] args = { "Иванов И.И." };
        //StartMain.main(args);
        DbContact dbContacts = StartMain.getDbContact();
        assertNotEquals("1. +7 800 2000 500\n" +
                "2. +8 800 200 600\n", StartMain.findContact(args, dbContacts));
    }

    @Test
    /**
     * Test main
     */
    public void testMainNot_1() {

        String[] args = { "Сидоров В.С." };
        //StartMain.main(args);
        DbContact dbContacts = StartMain.getDbContact();
        assertNotEquals("1. +8 800 2000 800\n" +
                "2. +8 800 2000 900\n" +
                "3. +8 800 2000 000\n", StartMain.findContact(args, dbContacts));
    }
}