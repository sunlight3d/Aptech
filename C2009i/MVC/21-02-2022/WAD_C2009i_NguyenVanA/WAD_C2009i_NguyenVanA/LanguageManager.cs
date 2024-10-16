using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Threading;
using System.Web;
using WAD_C2009i_NguyenVanA.Models;

namespace WAD_C2009i_NguyenVanA
{
    public class LanguageManager
    {
        public static List<Language> AvailableLanguages = new List<Language> {
            new Language {
                LanguageFullName = "Vietnamese", LanguageCultureName = "vi-VN"
            },
            new Language {
                LanguageFullName = "English", LanguageCultureName = ""
            },            
        };
        public static bool IsLanguageAvailable(string language)
            => AvailableLanguages
                .Where(a => a.LanguageCultureName.Equals(language))
                .FirstOrDefault() != null;
        public static string GetDefaultLanguage() =>
            AvailableLanguages[0].LanguageCultureName;
        
        public void SetLanguage(string language)
        {
            try
            {
                if (!IsLanguageAvailable(language)) language = GetDefaultLanguage();                
                var cultureInfo = new CultureInfo(language);
                Thread.CurrentThread.CurrentUICulture = cultureInfo;
                Thread.CurrentThread.CurrentCulture = CultureInfo.CreateSpecificCulture(cultureInfo.Name);
                HttpCookie langCookie = new HttpCookie("culture", language);
                langCookie.Expires = DateTime.Now.AddYears(1);
                HttpContext.Current.Response.Cookies.Add(langCookie);
            }
            catch (Exception) { }
        }
    }    
}