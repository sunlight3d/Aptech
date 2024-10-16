using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Text;

namespace _09_10_2020
{
    public class Test
    {
        public static void Main(string[] args) {
            ShapeCollection shapeCollection = new ShapeCollection();
            string choice = "";
            while (choice.ToLower() != "quit") {
                Console.WriteLine("Please enter: Circle, Rectangle, Show");
                choice = Console.ReadLine();
                switch (choice.ToLower()) {
                    case "circle":
                        shapeCollection.AddCircle();
                        break;
                    case "rectangle":
                        shapeCollection.AddRectangle();
                        break;
                    case "show":
                        shapeCollection.showAllShapes();
                        break;
                    default:
                        Console.WriteLine("Enter quit to exit");
                        break;
                }
            }
        }
    }
}
