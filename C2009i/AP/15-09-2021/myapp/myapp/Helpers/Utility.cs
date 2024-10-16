using System;
namespace myapp.Helpers
{
    public class Utility
    {
        public static DateTime convertStringToDateTime(String inputString)
        {
            //dd/mm/yyyy
            try
            {
                int day = Convert.ToInt32(inputString.Split("/")[0]);
                int month = Convert.ToInt32(inputString.Split("/")[1]);
                int year = Convert.ToInt32(inputString.Split("/")[2]);
                if (month < 0 || month > 12) {
                    throw new Exception("month must be 1-12");
                }
                if (year <= 1900)
                {
                    throw new Exception("Year must > 1900");
                }
                //exception cho day ?

                return new DateTime(year, month, day);
            }
            catch (Exception e) {
                //return DateTime.Now;//tu giai quyet
                throw new Exception(e.Message);
            }
        }
    }
}
