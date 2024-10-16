using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    public class MyDictionary
    {
        Dictionary dictionary = new Dictionary();
        public void DisplayTaskMenu() { 
        	int choice = 0;
			while(choice != 7){
				Console.WriteLine("1.Add a Word");
				Console.WriteLine("2.Edit a word");
				Console.WriteLine("3.Remove a word");
				Console.WriteLine("4.List all words");
				Console.WriteLine("5.Search");
				Console.WriteLine("6.Clear Screen");
				Console.WriteLine("7.Exit");
				Console.WriteLine("Enter your choice(1-7) :");
				choice = Convert.ToInt32(Console.ReadLine());
				switch (choice) {
					case 1:
						AddAWord();
						break;
					case 2:
						EditAWord();
						break;
					case 3:
						RemoveAWord();
						break;
					case 4:
						ListAllWords();
						break;
					case 5:
						Search();
						break;
					case 6:
						ClearScreen();
						break;
					case 7:
						Environment.Exit(0);
						break;
					default:
						Console.WriteLine("Please choose a value from 1 - 7");
						break;
				}
			}
			Environment.Exit(0);
		}
        private void AddAWord(){
			Console.WriteLine("Enter a word : ");
			string word = Console.ReadLine().Trim();
			Console.WriteLine("Enter meaning : ");
			string meaning = Console.ReadLine().Trim();
			dictionary.AddWord(word, meaning);
        }
        private void EditAWord(){
			Console.WriteLine("Enter a word : ");
			string word;
			word = Console.ReadLine().Trim();
			while(dictionary.IsEmptyWord(word) || !dictionary.WordExists(word)) {
				Console.WriteLine("word is empty or not exist");
				Console.WriteLine("Enter a word again: ");
				word = Console.ReadLine().Trim();				
			}
			Console.WriteLine("Enter meaning : ");
			string meaning = Console.ReadLine().Trim();
			dictionary.EditWord(word, meaning);
		}
        private void RemoveAWord(){
			Console.WriteLine("Enter a word : ");
			string word = Console.ReadLine().Trim();
			dictionary.Remove(word);
        }
        private void ListAllWords(){
			dictionary.List();
        }
        private void Search(){
			Console.WriteLine("Enter a word : ");
			string word = Console.ReadLine().Trim();
			dictionary.Search(word);
		}
        private void ClearScreen(){
			Console.Clear();
        }
    }
}
