package com.example.hospital.service;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

import com.example.hospital.model.file.FileDB;
import com.example.hospital.model.user.User;
import com.example.hospital.model.user.UserRequest;
import com.example.hospital.repository.file.FileDBRepository;
import com.example.hospital.repository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class FileStorageService {

    @Autowired
    private FileDBRepository fileDBRepository;

    @Autowired
    UserRepository userRepository;

    // new code started

    String username = null;
    public void getUsername(UserRequest userRequest)
    {
        username = userRequest.getUsername();
    }
    // new code ended
    public FileDB store(MultipartFile file) throws IOException {
        log.info("FileStorageService -- store");
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        log.info("fileName : " + fileName);
        log.info("username : " + username);
        Optional<User> user = userRepository.findByUsername(username);
        User notOptionalObject =  user.get();

      // FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
        FileDB fileDB =  FileDB.builder()
                .user(notOptionalObject)
                .name(fileName)
                .type(file.getContentType())
                .data(file.getBytes())
                .build();

        //return fileDBRepository.save(fileDB);
        // new code started

        FileDB savedFileInDB = fileDBRepository.save(fileDB);
        String fileId = savedFileInDB.getId();
        return savedFileInDB;
        // new code ended

    }

    public FileDB getFile(String id) throws Exception {
        return fileDBRepository.findById(id)
                .orElseThrow(() -> new Exception("File not found with Id : " + id));

    }

    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
}
