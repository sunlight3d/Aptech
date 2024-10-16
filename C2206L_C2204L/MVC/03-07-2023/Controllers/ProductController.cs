using _03_07_2023.DTOs;
using _03_07_2023.Models;
using _03_07_2023.Services;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Options;
using System.Collections.Generic;

namespace _03_07_2023.Controllers
{
    public class ProductController : Controller
    {
        //http://localhost:port/Product/Index
        private readonly IProductService _productService;
        private readonly Utilities.Environments _environments;
        public ProductController(
            IProductService productService,
            IOptions<Utilities.Environments> environments) //fully qualified 
        {
            _productService = productService;
            _environments = environments.Value;
            //productService & productRepository tạo ra khi nào?
        }
        public IActionResult Index()
        {
            /*
            ViewBag.x = 123;
            ViewData["y"] = 345;            
            ViewBag.productA = new Product //Buider pattern
            {
                Description = "This is an iphone",
                Id = 1,
                Name="iphone 14",
                Price=1234.0f,                
                Count = 2
            };
            ViewBag.products = new List<Product>()
            {
                new Product //Buider pattern
                    {
                        Description = "aaaa",
                        Id = 1,
                        Name="p1111",
                        Price=2224.0f,
                        Count = 10
                    },
                new Product //Buider pattern
                    {
                        Description = "a222",
                        Id = 1,
                        Name="p2223",
                        Price=3344.0f,
                        Count = 30
                    }
            };
            */
            return View();//Views/Product/Index.cshtml
        }
        //https://localhost:port/Product/DoSomething
        public IActionResult DoSomething(string x, string y) {
            return View(); //Views/Product/DoSomething.cshtml
        }
        //lấy ra tất cả sản phẩm(sau này phải paging)
        //[HttpGet("products")]
        //https://localhost:port/Product/products
        /*
        public IActionResult GetProducts(int? page, int? limit) { 
            IEnumerable<Product> products =  _productService.GetAllProducts(page ?? 1, limit ?? 10);
            return View(products); //Views/Product/GetProducts
        }
        */
        //Validate từ request(Data Transfer Object)
        public IActionResult GetProducts(PageDTO pageDTO)
        {
            pageDTO.Page = pageDTO.Page == 0 ? _environments.Page : pageDTO.Page;
            pageDTO.Limit = pageDTO.Limit == 0 ? _environments.Limit : pageDTO.Limit;
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            IEnumerable<Product> products = _productService.GetAllProducts(pageDTO.Page, pageDTO.Limit);
            return View(products); //Views/Product/GetProducts
        }

        /* phần thêm sản phẩm mới:
         * -Có 1 form nhập thông tin cần thêm(action request GET)
         * -phần xử lý sau khi người dùng nhập xong thông tin và bấm nút "Insert"
         * -nếu insert thành công => redirect sang trang "danh sách sản phẩm"
         */
        //-Có 1 form nhập thông tin cần thêm(action request GET)        
        public IActionResult AddProduct(ProductDTO productDTO) {
            //productDTO = new ProductDTO();
            if (!ModelState.IsValid)
            {                                
                return View();//Views/Product/AddProduct.cshtml
            }
            //validate ok
            _productService.CreateProduct(productDTO);
            //thành công
            return RedirectToAction(nameof(GetProducts));            
        }
        [HttpGet]
        public IActionResult Edit(int id) {
            Product? existingProduct = _productService.GetProductById(id);
            if (existingProduct == null) {
                return RedirectToAction(nameof(GetProducts));
            }

            return View("EditProduct", existingProduct);
        }
        [HttpPost]
        public IActionResult EditProduct(Product product) {
            if (!ModelState.IsValid)
            {
                return View();//Views/Product/EditProduct.cshtml
            }
            _productService.UpdateProduct(product);
            //thành công
            return RedirectToAction(nameof(GetProducts));
        }
    }


    /*
     Viết cho tôi 1 form đăng ký người dùng(.cshtml) có các trường email, fullname, password, retype password 
    - Một UserController kèm theo action đăng ký
    - Controller truyền model xuống cho view
    Tôi sử dụng asp .net core mvc
    

     */
}
