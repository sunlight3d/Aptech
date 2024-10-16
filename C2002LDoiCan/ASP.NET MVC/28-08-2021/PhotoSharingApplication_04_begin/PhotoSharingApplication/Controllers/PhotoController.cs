using PhotoSharingApplication.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace PhotoSharingApplication.Controllers
{
    [ValueReporter]
    public class PhotoController : Controller
    {
        private PhotoSharingContext context = new PhotoSharingContext();
        // GET: Photo
        public ActionResult Index()
        {
            //hien view /Views/Photo/Index.cshtml
            return View("Index", context.Photos.ToList());
        }
        public ActionResult Display(int id)
        {
            //http:localhost:1234/Photo/Display
            //Views/Photo/Display.cshtml
            Photo photo = context.Photos.Find(id);
            if (photo == null)
            {
                return HttpNotFound();
            }
            return View("Display", photo);
        }
        [HttpGet]
        [ActionName("/Create")]
        public ActionResult Create()
        {
            //Views/Photo/Create.cshtml
            Photo newPhoto = new Photo();//thuoc tinh cua photo do nguoi dung nhap vao
            //o Create.cshtml
            newPhoto.CreatedDate = DateTime.Today;
            return View("Create", newPhoto);
        }
        [HttpPost]
        public ActionResult Create(Photo photo, HttpPostedFileBase image)
        {
            photo.CreatedDate = DateTime.Today;
            if (!ModelState.IsValid)
            {
                return View("Create", photo);
            }
            else
            {
                if (image != null)
                {
                    photo.ImageMimeType = image.ContentType;
                    photo.PhotoFile = new byte[image.ContentLength];
                    image.InputStream.Read(photo.PhotoFile, 0, image.ContentLength);
                }
                context.Photos.Add(photo);
                context.SaveChanges();
                return RedirectToAction(nameof(Index));
            }
        }
        [HttpGet]        
        //Di chuyen den trang /Photo/Delete.cshtml
        public ActionResult Delete(int id)
        {
            Photo photo = context.Photos.Find(id);

            if (photo == null)
            {
                return HttpNotFound();
            }
            return View("Delete", photo);            
        }
        [HttpPost]
        [ActionName("Delete")]
        public ActionResult DeleteConfirmed(int id)
        {
            Photo photo = context.Photos.Find(id);
            context.Photos.Remove(photo);
            context.SaveChanges();
            return RedirectToAction("Index");
        }
        //Not ActionResult

    }
}