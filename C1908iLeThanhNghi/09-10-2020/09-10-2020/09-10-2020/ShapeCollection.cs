using System;
using System.Collections.Generic;
using System.Text;

namespace _09_10_2020
{
    class ShapeCollection
    {
        public List<Shape> shapes = new List<Shape>();
        public void AddCircle() {
            try
            {
                Console.WriteLine("Enter radius : ");
                double radius = Convert.ToDouble(Console.ReadLine());
                Circle newCircle = new Circle()
                {
                    Radius = radius
                };
                shapes.Add(newCircle);
            }
            catch (Exception e) {
                Console.WriteLine($"Cannot add circle. Error : {e.ToString()}");
            }
        }
        public void AddRectangle()
        {
            try
            {
                Console.WriteLine("Enter width : ");
                double width = Convert.ToDouble(Console.ReadLine());
                
                Console.WriteLine("Enter height : ");
                double height = Convert.ToDouble(Console.ReadLine());

                shapes.Add(new Rectangle() { 
                    Width = width,
                    Height = height
                });
            }
            catch (Exception e)
            {
                Console.WriteLine($"Cannot add rectangle. Error : {e.ToString()}");
            }
        }
        public void showAllShapes() { 
            foreach(Shape shape in shapes) {
                if (shape is Rectangle)
                {
                    Console.WriteLine($"Rectangle, " +
                        $"width = {((Rectangle)shape).Width}" +
                        $"height = {((Rectangle)shape).Height}");
                }
                else if (shape is Circle) {
                    Console.WriteLine($"Circle, radius = {((Circle)shape).Radius}");
                }
            }
        }
    }
}
