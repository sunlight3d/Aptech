package com.aptech.bookapp.controllers;

import com.aptech.bookapp.models.User;
import com.aptech.bookapp.services.IUserService;
import com.aptech.bookapp.viewmodels.UserLoginViewModel;
import com.aptech.bookapp.viewmodels.UserRegisterModel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    //inject service
    private final IUserService userService;
    @GetMapping("/login")
    //view model = Data Transfer Object = Request Object
    public ModelAndView login(Model model) {
        //model.addAttribute("book", 1book);//gủi dữ liệu từ controller => view
        return new ModelAndView("user/login"); //ten view: login.html
    }

    @GetMapping("/register")
    //view model = Data Transfer Object = Request Object
    public ModelAndView register(Model model) {
        model.addAttribute("userRegisterModel", new UserRegisterModel());
        ModelAndView modelAndView = new ModelAndView("user/register"); // Đổi tên view thành tên view của bạn
        modelAndView.addObject("userRegisterModel", new UserRegisterModel());
        return modelAndView;
    }
    //Sau khi user bam nut "Register"
    @PostMapping("/register")
    public ModelAndView registerUser(@Valid UserRegisterModel model, BindingResult result) {
        User newUser = userService.register(model);
        if (newUser == null) {
            ModelAndView modelAndView = new ModelAndView("user/register");
            modelAndView.addObject("error", "Cannot register new user");
            return modelAndView;
        }
        return new ModelAndView("user/login");
    }
    //sau khi bam login, gui reques post den ham nay
    @PostMapping("/login")
    public ModelAndView loginUser(@Valid UserLoginViewModel model, BindingResult result) {

        //xử lý nghiệp vụ(gọi service)
        User user = userService.login(model.getUsername(), model.getPassword());
        //new sai mat khau hoac user ko ton tai
        if (user == null) {
            ModelAndView modelAndView = new ModelAndView("user/login");
            modelAndView.addObject("error", "Invalid credentials or user does not exist.");
            return modelAndView;
        }

        return new ModelAndView("home/index"); // tên view: login.html
    }
}
