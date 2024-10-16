using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using WAD_C2009i_NguyenVanA.Models;
using PagedList;

namespace WAD_C2009i_NguyenVanA.Controllers
{
    public class MyController:Controller
    {
        protected override IAsyncResult BeginExecuteCore(AsyncCallback callback, object state)
        {
            string language = null;
            HttpCookie langCookie = Request.Cookies["language"];
            if (langCookie != null)
            {
                language = langCookie.Value;
            }
            else
            {
                var userLanguage = Request.UserLanguages;
                var userLang = userLanguage != null ? userLanguage[0] : "";
                language = userLang != "" ? userLang : LanguageManager.GetDefaultLanguage();                
            }
            new LanguageManager().SetLanguage(language);
            return base.BeginExecuteCore(callback, state);
        }
        
    }
}