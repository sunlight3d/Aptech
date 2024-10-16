using System;
namespace myapp.Helpers
{
    public class Utility
    {
        public static DateTime? convertStringToDateTime(String inputString)
        {
            //dd/mm/yyyy
            try
            {
                String[] arrayOfString = inputString.Split("/");
                if (arrayOfString.Length != 3) {
                    Console.WriteLine("incorrect datetime format");
                    return null;
                }
                int day = Convert.ToInt32(arrayOfString[0]);
                int month = Convert.ToInt32(arrayOfString[1]);
                int year = Convert.ToInt32(arrayOfString[2]);
                if (month < 0 || month > 12) {
                    //throw new Exception("month must be 1-12");
                    Console.WriteLine("month must be 1-12");
                    return null;
                }
                if (year <= 1900)
                {
                    Console.WriteLine("Year must > 1900");
                    return null;
                    //throw new Exception("Year must > 1900");
                }
                //exception cho day ?

                return new DateTime(year, month, day);
            }
            catch (Exception e) {
                //return DateTime.Now;//tu giai quyet
                //throw new Exception(e.Message);                
                return null;
            }
        }
    }
}
