package contact;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class main {

    
    static class Contact {
        private String name;
        private String phoneNumber;
        private String email;

        public Contact(String name, String phoneNumber, String email) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

      
        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getEmail() {
            return email;
        }

       
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Contact contact = (Contact) o;
            return phoneNumber.equals(contact.phoneNumber); 
        }

        @Override
        public int hashCode() {
            return phoneNumber.hashCode();
        }

        @Override
        public String toString() {
            return "Contact{name='" + name + "', phoneNumber='" + phoneNumber + "', email='" + email + "'}";
        }
    }

    
    static class ContactManager {
        
        private Set<Contact> contacts;
       
        private Map<String, Contact> contactMap;

        public ContactManager() {
            contacts = new HashSet<>();
            contactMap = new HashMap<>();
        }

       
        public boolean addContact(Contact contact) {
            boolean added = contacts.add(contact); 
            if (added) {
                contactMap.put(contact.getName(), contact); 
            }
            return added;
        }

       
        public Contact findContactByName(String name) {
            return contactMap.get(name); 
        }

        
        public boolean removeContactByName(String name) {
            Contact contact = contactMap.remove(name); 
            if (contact != null) {
                return contacts.remove(contact); 
            }
            return false;
        }

       
        public void displayContacts() {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();

       
        Contact contact1 = new Contact("sunny", "123-456-7890", "sunny@example.com");
        Contact contact2 = new Contact("bunny", "987-654-3210", "bunny@example.com");
        Contact contact3 = new Contact("rahul", "555-555-5555", "rahul@example.com");

        
        manager.addContact(contact1);
        manager.addContact(contact2);
        manager.addContact(contact3);

       
        System.out.println("All contacts:");
        manager.displayContacts();

        
        System.out.println("\nContact found by name 'Alice':");
        Contact foundContact = manager.findContactByName("Alice");
        System.out.println(foundContact);

        
        System.out.println("\nRemoving contact 'Bob':");
        boolean removed = manager.removeContactByName("Bob");
        if (removed) {
            System.out.println("Bob removed successfully.");
        } else {
            System.out.println("Bob not found.");
        }

       
        System.out.println("\nAll contacts after removal:");
        manager.displayContacts();
    }
}
