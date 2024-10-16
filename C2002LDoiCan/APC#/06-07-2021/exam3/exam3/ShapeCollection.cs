using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace exam3
{
    public class ShapeCollection
    {

        public List<Shape> Shapes { get; set; }
        ShapeCollection() {
            Shapes = new List<Shape>();
        }
        public void AddCircle() {
            try
            {
                Circle circle = new Circle();
                Console.WriteLine("Enter radius : ");
                circle.Radius = Convert.ToDouble(Console.ReadLine());
                Shapes.Add(circle);
            }
            catch (Exception exception) {
                Console.WriteLine("Cannot add circle, error: " + exception.ToString());
            }
        }
        public void AddRectangle()
        {
            try
            {
                Rectangle rectangle = new Rectangle();
                Console.WriteLine("Enter width : ");
                rectangle.Width = Convert.ToDouble(Console.ReadLine());
                Console.WriteLine("Enter height : ");
                rectangle.Height = Convert.ToDouble(Console.ReadLine());
                Shapes.Add(rectangle);
            }
            catch (Exception exception)
            {
                Console.WriteLine("Cannot add rectangle, error: " + exception.ToString());
            }
        }
        public void ShowAllShapes() {
            foreach (Shape shape in this.Shapes) {
                Console.WriteLine(shape.ToString());
                //ve nha viet ham ToString() cua tung object
            }
        }
    }
}
