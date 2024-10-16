package controllers;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repositories.UserRepository;
@Controller // This means that this class is a Controller
@RequestMapping(path="/users") // This means URL's start with /demo (after
public class UserController {
    @Autowired // This means to get the bean called userRepository
    private UserRepository userRepository;//injection
    //Routing
    //localhost:8080/users/addNewUser
    @PostMapping(path="/addNewUser") // Map ONLY POST Requests
    public @ResponseBody
    User addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }
    //localhost:8080/users/getAllUsers
    @GetMapping(path="/getAllUsers")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
