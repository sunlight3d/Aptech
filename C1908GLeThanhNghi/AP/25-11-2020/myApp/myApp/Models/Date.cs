using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;
namespace myApp.Models
{
    public class Date
    {
        private int day, month, year;
        private string stringMonth;
        private Dictionary<string, int> dictMonth = new Dictionary<string, int>() {
            { "jan", 1},
            { "feb", 2},
            { "mar", 3},
            { "apr", 4},
            { "may", 5},
            { "june", 6},
            { "july", 7},            
            { "aug", 8},
            { "sep", 9},
            { "oct", 10},
            { "nov", 11},
            { "dec", 12},
        };
        public string StringMonth {
            get {
                
                return $"{stringMonth.Substring(0, 1).ToUpper()}{stringMonth.Substring(1)}";
            }
            set {                
                if (!dictMonth.ContainsKey(stringMonth.Trim().ToLower())) {
                    return;
                }
                month = dictMonth[stringMonth.Trim().ToLower()];                
                stringMonth = value;
            }
        }
        public int Month {
            get {
                return month;
            }
            set {
                month = value;
                if (month < 1 || month > 12) {
                    return;
                }
                stringMonth = dictMonth.ToDictionary(x => x.Value, x => x.Key)[month];                
            }
        }
        //strignMonth and month => dependent
        public Date(int day, int month, int year) {
            this.day = day;
            this.month = month;
            Month = month;
            this.year = year;
                 
        }
        public string ToMMDDYYYY() => $"{Month}/{day}/{year}";
        public string ToMMdd_yyyy() => $"{StringMonth} {day}, {year}";
    }
}
