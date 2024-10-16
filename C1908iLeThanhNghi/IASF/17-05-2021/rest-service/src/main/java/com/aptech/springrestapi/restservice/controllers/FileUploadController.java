package com.aptech.springrestapi.restservice.controllers;

import com.aptech.springrestapi.restservice.controllers.storage.StorageFileNotFoundException;
import com.aptech.springrestapi.restservice.controllers.storage.StorageService;
import com.aptech.springrestapi.restservice.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/uploadImages")
public class FileUploadController {
    private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);
    private final StorageService storageService;
    @Autowired
    public FileUploadController(StorageService storageService) {
        //inject service
        this.storageService = storageService;
    }

    @GetMapping("/")
    //GET http://localhost:8080/uploadImages/
    //uploadImages
    public Hashtable<String, Object> listUploadedFiles(Model model) throws IOException {
        Hashtable<String, Object> dictResponse = new Hashtable<>();
        try {
            model.addAttribute("files", storageService.loadAll().map(
                    path -> {
                        return MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                                "serveFile", path.getFileName().toString()).build().toUri().toString();
                    })
                    .collect(Collectors.toList()));
            List<String> imageNames = storageService.loadAll().map(path -> path.getFileName().toString()).collect(Collectors.toList());
            log.info("debugging...");
            dictResponse.put("code", 200);
            dictResponse.put("message", "List uploaded files successful");
            dictResponse.put("data", imageNames);
            return  dictResponse;
        }catch (Exception e) {
            log.info("error...");
//            return "error";
            dictResponse.put("code", 300);
            dictResponse.put("message", String.format("List uploaded files failed: %s", e.toString()));
            dictResponse.put("data", null);
            return  dictResponse;
        }
    }

    @GetMapping("/files/{filename:.+}")
    //lay ra noi dung cua file(xem anh)
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/")
    //quan trong nhat
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        log.info("handleFileUpload");
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
