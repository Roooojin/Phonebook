/**
 * writing unit tests for each method of classes
 * If you have no idea about how to write unit tests, you can search the internet or check your first assignment
 * After each unit test you've written, please commit the changes and push to your repo

 * Hint: Your test coverage should be 100%
 * Attention:  We would check your commits and it will affect your score
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
public class Phonebook_Test {

    public void testAddContact() {
        Phonebook phonebook = new Phonebook();
        Person person = new Person("rojin", "09123456789");
        phonebook.addContact(person);
        assertEquals(1, phonebook.getAllContacts().size());
    }

    @Test
    public void testGetPhoneNumber() {
        Phonebook phonebook = new Phonebook();
        Person person = new Person("rojin", "09123456789");
        phonebook.addContact(person);
        assertEquals("09123456789", phonebook.getPhoneNumber("John"));
    }

    @Test
    public void testGetContact() {
        Phonebook phonebook = new Phonebook();
        Person person = new Person("rojin", "09123456789");
        phonebook.addContact(person);
        assertEquals(1, phonebook.getContact("John"));
    }

    @Test
    public void testupdateContactName() {
        Phonebook phonebook = new Phonebook();
        Person person = new Person("rojin", "09123456789");
        phonebook.addContact(person);
        String newName="mobina";
        int result=phonebook.updateContactName("rojin","mobina");
        assertEquals(1, result);
        assertEquals("mobina", phonebook.getAllContacts().get(0).getName());


    }

    @Test
    public void testUpdateContactNameContactNotFound() {
        Phonebook phonebook = new Phonebook();
        Person person = new Person("John", "09123456789");
        phonebook.addContact(person);

        int result = phonebook.updateContactName("Bob", "NewBob");

        assertEquals(0, result);
    }

    @Test
    public void testUpdateContactPhoneNumber() {
        Phonebook phonebook = new Phonebook();
        Person person = new Person("rojin", "09123456789");
        phonebook.addContact(person);

        int result=phonebook.updateContactPhoneNumber("rojin","09133456789");
        assertEquals(1,result);
        assertEquals("09133456789",phonebook.getAllContacts().get(0).getPhone());

    }

    @Test
    public void testUpdateContactPhoneNumberContactNotFound() {
        Phonebook phonebook = new Phonebook();
        Person person = new Person("John", "09123456789");
        phonebook.addContact(person);

        int result = phonebook.updateContactPhoneNumber("Bob", "09121234567");

        assertEquals(0, result);
    }


    @Test
    public void testDeleteContact() {
        Phonebook phonebook = new Phonebook();
        Person person = new Person("John", "09123456789");
        phonebook.addContact(person);

        int result = phonebook.deleteContact("John");
        assertEquals(1, result);


        assertEquals(0, phonebook.getAllContacts().size());
    }

    @Test
    public void testDeleteNonExistentContact() {
        Phonebook phonebook = new Phonebook();

        int result = phonebook.deleteContact("somebody");
        assertEquals(0, result);
        assertEquals(0, phonebook.getAllContacts().size());
    }


    @Test
    public void testGetAllContacts() {
        Phonebook phonebook = new Phonebook();

        Person person1 = new Person("John", "09123456789");
        Person person2 = new Person("Alice", "09876543210");


        phonebook.addContact(person1);
        phonebook.addContact(person2);


        ArrayList<Person> allContacts = phonebook.getAllContacts();
        assertEquals(2, allContacts.size());

        assertEquals(true, allContacts.contains(person1));
        assertEquals(true, allContacts.contains(person2));
    }

    @Test
    public void testGetAllContactsEmpty() {
        Phonebook phonebook = new Phonebook();
        ArrayList<Person> allContacts = phonebook.getAllContacts();
        assertEquals(0, allContacts.size());
    }

    @Test
    public void testSetAllContactsHidden() {
        Phonebook phonebook = new Phonebook();
        Person person1 = new Person("John", "09123456789");
        Person person2 = new Person("Alice", "09876543210");


        phonebook.addContact(person1);
        phonebook.addContact(person2);

        phonebook.setAllContactsHidden();


        for (Person contact : phonebook.getAllContacts()) {
            assertEquals(true, contact.isHidden());


        }
    }

    @Test
    public void testSetAllContactsUnHidden() {
        Phonebook phonebook = new Phonebook();

        Person person1 = new Person("John", "09123456789");
        Person person2 = new Person("Alice", "09876543210");

        phonebook.addContact(person1);
        phonebook.addContact(person2);

        phonebook.setAllContactsHidden();

        phonebook.setAllContactsUnHidden();


        for (Person contact : phonebook.getAllContacts()) {
            assertEquals(false, contact.isHidden());
        }
    }

    }












