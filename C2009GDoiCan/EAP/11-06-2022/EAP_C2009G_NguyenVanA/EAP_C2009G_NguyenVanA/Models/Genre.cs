using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq; //Language Integrated Query
using System.Web;

namespace EAP_C2009G_NguyenVanA.Models
{
    public class Genre
    {

        public int GenreId { get; set; }        
        [Required]
        public string GenreName { get; set; }
        //virtual = can be overrided
        public virtual ICollection<Movie> Movies { get; set; }
        public Genre() {
            this.Movies = new HashSet<Movie>();
        }

        //private int _x; //field = variable
        //full-form property
        /*
        public int X { 
            get {
                return _x;
            }
            set{
                _x = value;
            }
        }
        private float math, physics, chemistry;
        // this is a property = function
        //calculated value
        public float Total {
            get {
                return math + physics + chemistry;
            }
        }
        */
        //private int total; //what's wrong ?

        //property

        /*
        private static void TestSomething() { 
            Genre genre1 = new Genre() { 
                
            };
            //genre1.Total = 123;
        }
        */
    }
}