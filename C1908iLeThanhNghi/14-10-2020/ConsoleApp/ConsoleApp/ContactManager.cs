using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApp
{
    class ContactManager
    {
        private Hashtable contacts = new Hashtable();
        public void AddNewContact() {
            try
            {
                Console.WriteLine("Enter contact's name : ");
                string contactName = Console.ReadLine();
                Console.WriteLine("Enter phone number : ");
                long phoneNumber = Convert.ToInt64(Console.ReadLine());
                //Nen cho validate vao day
                contacts[phoneNumber] = new Contact()
                {
                    PhoneNumber = phoneNumber,
                    ContactName = contactName
                };
                Console.WriteLine("Insert new contact successfully");
            }
            catch (Exception e) {
                Console.WriteLine("Cannot insert contact.Err : "+e.ToString());
            }
        }
        public void FindAContactByName() {
            Console.WriteLine("Enter name to search : ");
            string name = Console.ReadLine();
            List<Contact> result = contacts.Values.OfType<Contact>()
                .Where(eachContact => {
                    var xx = eachContact.ContactName.ToLower().Equals(name.Trim().ToLower());
                    return eachContact.ContactName.ToLower().Equals(name.Trim().ToLower());
                })
                .ToList();
            Display(result);
        }
        public void Display(List<Contact> result) {
            foreach (Contact contact in result)
            {
                Console.WriteLine(contact.ToString());
            }
        }
        public void DisPlayAll() {
            Display(contacts.Values.OfType<Contact>().ToList());
        }

    }
}
