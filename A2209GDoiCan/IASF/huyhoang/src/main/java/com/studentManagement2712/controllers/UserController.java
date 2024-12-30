package com.studentManagement2712.controllers;

import com.studentManagement2712.models.User;
import com.studentManagement2712.repositories.UserRepository;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @Value("https://img.freepik.com/free-vector/young-prince-royal-attire_1308-176144.jpg")
    private String defaultAvatarUrl;

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "users/signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "users/signup";
        }

        Optional<User> existingUser = userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail());
        if (existingUser.isPresent()) {
            model.addAttribute("duplicatedError", "Username or email already exists");
            return "users/signup";
        }

        userRepository.save(user);

        return "redirect:/students";
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        model.addAttribute("errorMessage", "User not found");
        return "users/profile";
    }

    @GetMapping("/profile/{id}")
    public String showProfile(@PathVariable Long id, Model model) {
        Optional<User> user= userRepository.findById(id);
        //debug avatarPath in user object
        if (user.isPresent()) {
            model.addAttribute("defaultAvatarUrl", defaultAvatarUrl);
            model.addAttribute("timestamp", System.currentTimeMillis());
            model.addAttribute("user", user.get());
        } else {
            model.addAttribute("errorMessage", "User not found");
        }
        return "users/profile";
    }
    @GetMapping("/profile/images/{filename}")
    public ResponseEntity<UrlResource> getImage(@PathVariable String filename) {
        try {
            Path filePath = Paths.get("./uploads").resolve(filename);
            UrlResource resource = new UrlResource(filePath.toUri());
            if (!resource.exists() || !resource.isReadable()) {
                throw new RuntimeException("Could not read the file: " + filename);
            }

            // Return the file as a response
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Adjust this for other types like PNG
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/profile/upload-avatar")
    public String uploadAvatar(
            @RequestParam("avatar") MultipartFile file,
            @RequestParam("username") String username,
            Model model) throws IOException {

        if (!file.isEmpty()) {
            // Ensure the file type is valid (e.g., only images)
            String contentType = file.getContentType();
            if (contentType == null || !contentType.startsWith("image")) {
                model.addAttribute("errorMessage", "Invalid file type. Please upload an image.");
                return "redirect:/users/profile";
            }

            // Generate file name and define upload directory
            String fileName = username + "-avatar.jpg";
            Path uploadDir = Paths.get(uploadPath);

            // Create directory if it doesn't exist
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

            // Save the file
            Path filePath = uploadDir.resolve(fileName);
            if (Files.exists(filePath)) {
                Files.delete(filePath); // Delete the existing file
            }

// Write the new file (this will overwrite the old one if it exists)
            Files.write(filePath, file.getBytes(), StandardOpenOption.CREATE);

            // Update the user's avatar path in the database
            Optional<User> userOptional = userRepository.findByUsername(username);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                //String avatarPath = String.format("/uploads/%s", fileName);
                user.setAvatarPath(fileName);
                userRepository.save(user);

                return "redirect:/users/profile/" + user.getId();
            } else {
                model.addAttribute("errorMessage", "User not found.");
                return "redirect:/users/profile";
            }
        }
        model.addAttribute("errorMessage", "File is empty. Please select a valid file.");
        return "redirect:/users/profile";
    }
}
