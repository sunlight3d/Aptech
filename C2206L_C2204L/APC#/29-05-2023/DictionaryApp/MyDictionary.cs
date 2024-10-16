using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DictionaryApp
{
    internal class MyDictionary
    {
        private DictionaryApp.Dictionary dictionary = new DictionaryApp.Dictionary();
        public void ShowMenu() {
            int choice = 0;            
            while (choice != 7) {
                Console.WriteLine("1.Add a Word");
                Console.WriteLine("2.Edit a word");
                Console.WriteLine("3.Remove a word");
                Console.WriteLine("4.List all words");
                Console.WriteLine("5.Search");
                Console.WriteLine("6.Clear Screen");
                Console.WriteLine("7.Exit");
                Console.WriteLine("Enter your choice(1-7)");
                choice = int.Parse(Console.ReadLine() ?? "1");
                string word = "";
                string meaning = "";
                switch (choice)
                {
                    case 1:
                        Console.WriteLine("Add a word: ");
                        word = (Console.ReadLine() ?? "").Trim().ToLower();
                        Console.WriteLine("Meaning: ");
                        meaning = Console.ReadLine() ?? "";
                        dictionary.AddWord(word, meaning);
                        break;
                    case 2:
                        Console.WriteLine("Enter a word: ");
                        word = (Console.ReadLine() ?? "").Trim().ToLower();
                        Console.WriteLine("Meaning: ");
                        meaning = Console.ReadLine() ?? "";
                        dictionary.EditWord(word, meaning);
                        break;
                    case 3:
                        Console.WriteLine("Enter a word: ");
                        word = (Console.ReadLine() ?? "").Trim().ToLower();
                        dictionary.Remove(word);
                        break;
                    case 4:
                        dictionary.List();
                        break;
                    case 5:
                        Console.WriteLine("Enter a word: ");
                        word = (Console.ReadLine() ?? "").Trim().ToLower();
                        dictionary.Search(word);
                        break;
                    case 7:                        
                        break;
                    case 6:
                        Console.Clear();
                        break;                    
                    default:
                        Console.WriteLine("Please select 1-7");
                        break;
                }
            }
        }
    }
}

/*
 * Them mot so chuc nang:
 * Hien danh sach, hien luon tong so phan tu
 * Edit thanh cong thi bao success, 
 * ko co gi thay doi thi bao "no change"
 */