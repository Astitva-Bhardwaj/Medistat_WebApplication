package com.example.hospital.controller;
import com.example.hospital.model.user.Rating;
import com.example.hospital.model.file.FileDB;
import com.example.hospital.model.user.DownloadRequest;
import com.example.hospital.model.user.User;
import com.example.hospital.model.user.UserRequest;
import com.example.hospital.repository.file.FileDBRepository;
import com.example.hospital.response.ResponseMessage;
import com.example.hospital.service.FileStorageService;
import com.example.hospital.service.RatingServiceImpl;
import com.example.hospital.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.core.io.*;

import java.text.AttributedString;


@Controller
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private FileStorageService storageService;

    @Autowired
    FileDBRepository fileDBRepository;

    @Autowired
    RatingServiceImpl ratingService;

    @GetMapping("/")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/registerUser")
    public String User(@ModelAttribute("user") User user) throws Exception {
        log.info(user.toString());
        userService.registerUser(user);
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        log.info("UserController -- login");
        UserRequest userRequest = new UserRequest();
        model.addAttribute("userRequest", userRequest);
        return "login";
    }

    @PostMapping("/loginUser")
    public String loginUser(@ModelAttribute("userRequest") UserRequest userRequest) {
        log.info("UserController -- loginUser");
        log.info(userRequest.toString());
        userService.loginUser(userRequest);
        storageService.getUsername(userRequest);
        return "login-home";
    }

    @GetMapping("/uploadForm")
    public String User() {
        log.info("UserController -- uploadForm");
        return "uploadForm";
    }

    @GetMapping("/viewer")
    public String Viewer(Model model) {
        log.info("UserController -- Viewer");
        DownloadRequest downloadRequest = new DownloadRequest();
        model.addAttribute("downloadRequest", downloadRequest);
        return "viewer";
    }


    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        log.info("UserController -- uploadFile");
        String message = "";
        try {
            FileDB fileDb = storageService.store(file);
            String fileId = fileDb.getId();
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, fileId));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/textToSpeech")
    public ModelAndView textToSpeech() {
        log.info("UserController -- textToSpeech");
        ModelAndView mav = new ModelAndView("index-home");
        return mav;
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile(@ModelAttribute("downloadRequest") DownloadRequest downloadRequest) throws Exception {
        FileDB fileDB = null;
        fileDB = storageService.getFile(downloadRequest.getFileId());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileDB.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "fileDB; filename=\"" + fileDB.getName() + "\"")
                .body(new ByteArrayResource(fileDB.getData()));
    }


    @GetMapping("/rating")
    public String main(Model model) {
        log.info("User Controller - main");
        model.addAttribute("rating", new Rating());
        return "rating";
    }

    @PostMapping("/ratingSaved")
    public String save(@ModelAttribute("rating") Rating rating ) {
        log.info("User Controller - save");
        //model.addAttribute("rating", rating);
        ratingService.addRating(rating);
        return "rating-saved";
    }

}

