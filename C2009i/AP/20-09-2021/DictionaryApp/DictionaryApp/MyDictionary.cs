using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DictionaryApp
{
    public class MyDictionary
    {
        public Dictionary Dictionary { get; set; }
        //no-need constructor
        public void ShowMenu() {
            int choice = 0;
            Console.WriteLine("1.Add a Word");
            Console.WriteLine("2.Edit a word");
            Console.WriteLine("3.Remove a word");
            Console.WriteLine("4.List all words");
            Console.WriteLine("5.Search");
            Console.WriteLine("6.Clear Screen");
            Console.WriteLine("7.Exit");
            string word = "";
            string meaning = "";
            try 
            {
                while (true)
                {
                    Console.WriteLine("Enter your choice(1-7)");
                    choice = Convert.ToInt32(Console.ReadLine());
                    switch (choice)
                    {
                        case 1:
                            //Console.WriteLine("1");
                            word = "";
                            meaning = "";
                            while (word.Length == 0 || meaning.Length == 0)
                            {
                                Console.WriteLine("Enter word: ");
                                word = Console.ReadLine().Trim();
                                Console.WriteLine("Enter meaning: ");
                                meaning = Console.ReadLine().Trim();
                            }
                            this.Dictionary.AddWord(word, meaning);
                            break;
                        case 2:
                            //Console.WriteLine("2");
                            word = "";
                            meaning = "";
                            while (word.Length == 0 || meaning.Length == 0)
                            {
                                Console.WriteLine("Enter word: ");
                                word = Console.ReadLine().Trim();
                                Console.WriteLine("Enter meaning: ");
                                meaning = Console.ReadLine().Trim();
                            }
                            this.Dictionary.EditWord(word, meaning);
                            break;
                        case 3:
                            //Console.WriteLine("3");
                            word = "";
                            while (word.Length == 0)
                            {
                                Console.WriteLine("Enter word: ");
                                word = Console.ReadLine().Trim();
                            }
                            this.Dictionary.Remove(word);
                            break;
                        case 4:
                            //Console.WriteLine("4");
                            this.Dictionary.List();
                            break;
                        case 5:
                            //Console.WriteLine("5");
                            word = "";
                            while (word.Length == 0)
                            {
                                Console.WriteLine("Enter word: ");
                                word = Console.ReadLine().Trim();
                            }
                            this.Dictionary.Search(word);
                            break;

                        case 6:
                            //Console.WriteLine("6");
                            Console.Clear();
                            break;
                        case 7:
                            Console.WriteLine("Program exited");
                            Environment.Exit(0);
                            break;
                        default:
                            break;
                    }
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);                
            }
            
        }
    }
}
