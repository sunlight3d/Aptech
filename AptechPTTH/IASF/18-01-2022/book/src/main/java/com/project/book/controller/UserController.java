package com.project.book.controller;

import com.project.book.model.User;
import com.project.book.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping(path = "user")
//http://localhost:8083/user
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession httpSession; //DI

    //http://localhost:8083/user/login
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String Login (ModelMap modelMap){
        if(httpSession.getAttribute("username") != null){
            return "redirect:/book/booklist";
        }
        return "login"; //login.jsp
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String Login(ModelMap modelMap,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password){
        try {
            User user = userRepository.findUserByNameAndPassword(username, password);
            if(user != null){
                //login sucess
                httpSession.setAttribute("username", username);
                modelMap.addAttribute("error", "");
                return "redirect:/book/welcome"; //redirect to welcome
            } else {
                modelMap.addAttribute("error", "Wrong username/password");
            }
        }catch (Exception e){
            modelMap.addAttribute("error", "Login failed, Internal error: "+e.toString());
        }
        return "login";
    }


}
