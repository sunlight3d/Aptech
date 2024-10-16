using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BookApp
{
    class SchoolBook:Book
    {
        public BookState BookState {  get; set;}
        //thanh tien => getTotalPrice(Java) 
        public override double TotalPrice { 
            get => (BookState == BookState.New) ?  Count * Price : Count * Price *0.5; 
        }
        //getter, NOT setter. VD: TotalMark(Math, Physics, Chemistry)
    }
}
