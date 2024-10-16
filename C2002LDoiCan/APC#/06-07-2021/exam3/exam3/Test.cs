using System;

namespace exam3
{
    class Test
    {
        static void Main(string[] args)
        {
            ShapeCollection shapeCollection = new ShapeCollection();
            String choice = "";
            do {
                choice = Console.ReadLine();
                switch (choice.ToLower()) {
                    case "circle":
                        shapeCollection.AddCircle();
                        break;
                    case "rectangle":
                        shapeCollection.AddRectangle();
                        break;
                    case "show":
                        shapeCollection.ShowAllShapes();
                        break;
                    default:


                }
            } while (choice.ToLower() != "quit");
            Console.WriteLine("Program ended");
        }
    }
}

