using ButterfliesShop.Models;
using ButterfliesShop.Services;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;

namespace ButterfliesShop.Controllers
{
    public class ButterflyController : Controller
    {
        private IDataService _dataService;
        private IWebHostEnvironment _environment;
        private IButterfliesQuantityService _butterfliesQuantityService;

        public ButterflyController(IDataService dataService, IWebHostEnvironment environment, IButterfliesQuantityService butterfliesQuantityService)
        {
            _dataService = dataService;
            _environment = environment;
            _butterfliesQuantityService = butterfliesQuantityService;
            InitializeButterfliesData();
        }
        private void InitializeButterfliesData()
        {
            if (_dataService.ButterfliesList == null)
            {
                List<Butterfly> butterflies = _dataService.ButterfliesInitializeData();
                foreach (var butterfly in butterflies)
                {
                    _butterfliesQuantityService.AddButterfliesQuantityData(butterfly);
                }
            }
        }
        public IActionResult Index()
        {
            IndexViewModel indexViewModel = new IndexViewModel();
            indexViewModel.Butterflies = _dataService.ButterfliesList;
            return View(indexViewModel);            
        }

        [HttpGet]
        public IActionResult Create()
        {
            return View();
        }
        [HttpPost]
        public IActionResult Create(Butterfly butterfly)
        {
            
                Butterfly lastButterfly = _dataService.ButterfliesList.LastOrDefault();
            butterfly.CreatedDate = DateTime.Today;
            if (butterfly.PhotoAvatar != null && butterfly.PhotoAvatar.Length > 0)
            {
                butterfly.ImageMimeType = butterfly.PhotoAvatar.ContentType;
                butterfly.ImageName = Path.GetFileName(butterfly.PhotoAvatar.FileName);
                butterfly.Id = lastButterfly.Id + 1;
                _butterfliesQuantityService.AddButterfliesQuantityData(butterfly);
                using (var memoryStream = new MemoryStream())
                {
                    butterfly.PhotoAvatar.CopyTo(memoryStream);
                    butterfly.PhotoFile = memoryStream.ToArray();
                }
                _dataService.AddButterfly(butterfly);
                return RedirectToAction("Index");
            }
            if (ModelState.IsValid)
            {
                
            }
            return View(butterfly);
        }
        public IActionResult GetImage(int id)
        {
            Butterfly requestedButterfly = _dataService.GetButterflyById(id);
            if (requestedButterfly != null)
            {
                string webRootpath = _environment.WebRootPath;
                string folderPath = "\\images\\";
                string fullPath = webRootpath + folderPath + requestedButterfly.ImageName;
                if (System.IO.File.Exists(fullPath))
                {
                    FileStream fileOnDisk = new FileStream(fullPath, FileMode.Open);
                    byte[] fileBytes;
                    using (BinaryReader br = new BinaryReader(fileOnDisk))
                    {
                        fileBytes = br.ReadBytes((int)fileOnDisk.Length);
                    }
                    return File(fileBytes, requestedButterfly.ImageMimeType);
                }
                else
                {
                    if (requestedButterfly.PhotoFile.Length > 0)
                    {
                        return File(requestedButterfly.PhotoFile, requestedButterfly.ImageMimeType);
                    }
                    else
                    {
                        return NotFound();
                    }
                }
            }
            else
            {
                return NotFound();
            }
        }
    }
}
