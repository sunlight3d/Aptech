using Microsoft.VisualStudio.TestTools.UnitTesting;
using OperasWebsites.Controllers;
using System;
using System.Diagnostics;
using System.Web.Mvc;

namespace OperasWebsitesTests
{
    [TestClass]
    public class HomeControllerTests
    {
        [TestMethod]
        public void Test_Index_Return_View()
        {
            HomeController controller = new HomeController();
            var result = controller.Index() as ViewResult;
            Debug.WriteLine(result.ViewName);
            Assert.AreEqual("Index", result.ViewName);
        }
    }
}
