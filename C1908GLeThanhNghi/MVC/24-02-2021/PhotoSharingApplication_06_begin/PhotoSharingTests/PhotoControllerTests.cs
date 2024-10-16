using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhotoSharingApplication.Controllers;
using PhotoSharingApplication.Models;
using PhotoSharingTests.Doubles;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Mvc;

namespace PhotoSharingTests
{
    [TestClass]
    public class PhotoControllerTests
    {
        [TestMethod]
        public void Test_Index_Return_View()
        {
            var context = new FakePhotoSharingContext();
            var controller = new PhotoController(context);
            var result = controller.Index() as ViewResult;//Opem Chrome, http://Index.cshtml
            Assert.AreEqual("Index", result.ViewName);
        }
        [TestMethod]
        public void Test_PhotoGallery_Model_Type()
        {
            var context = new FakePhotoSharingContext();
            context.Photos = new[] {
                new Photo(),
                new Photo(),
                new Photo(),
                new Photo()
             }.AsQueryable();
            var controller = new PhotoController(context);            
            var result = controller._PhotoGallery() as PartialViewResult;
            Assert.AreEqual(typeof(List<Photo>), result.Model.GetType());
        }
        [TestMethod]
        public void Test_GetImage_Return_Type()
        {
            var context = new FakePhotoSharingContext();
            context.Photos = new[] {
                 new Photo{ PhotoID = 1, PhotoFile = new byte[1], ImageMimeType = "image/jpeg"},
                 new Photo{ PhotoID = 2, PhotoFile = new byte[1], ImageMimeType = "image/jpeg"},
                 new Photo{ PhotoID = 3, PhotoFile = new byte[1], ImageMimeType = "image/jpeg"},
                 new Photo{ PhotoID = 4, PhotoFile = new byte[1], ImageMimeType = "image/jpeg"}
              }.AsQueryable();
            var controller = new PhotoController(context);
            var result = controller.GetImage(1) as ActionResult;
            Assert.AreEqual(typeof(FileContentResult), result.GetType());
        }
        [TestMethod]
        public void Test_PhotoGallery_No_Parameter()
        {
            var context = new FakePhotoSharingContext();
            context.Photos = new[] {
             new Photo(),
             new Photo(),
             new Photo(),
             new Photo()
          }.AsQueryable();
            var controller = new PhotoController(context);
            var result = controller._PhotoGallery() as PartialViewResult;
            var modelPhotos = (IEnumerable<Photo>)result.Model;
            Assert.AreEqual(4, modelPhotos.Count());
        }
        [TestMethod]
        public void Test_PhotoGallery_Int_Parameter()
        {
            var context = new FakePhotoSharingContext();
            context.Photos = new[] {
             new Photo(),
             new Photo(),
             new Photo(),
             new Photo()
          }.AsQueryable();
            var controller = new PhotoController(context);
            var result = controller._PhotoGallery(3) as PartialViewResult;
            var modelPhotos = (IEnumerable<Photo>)result.Model;
            Assert.AreEqual(3, modelPhotos.Count());
        }
    }
}
