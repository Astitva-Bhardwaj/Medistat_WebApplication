package com.example.hospital.service;

import com.example.hospital.model.user.User;
import com.example.hospital.model.user.UserRequest;

import com.example.hospital.repository.user.UserRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;


    @Override
    public void registerUser(User user) throws Exception {
        userRepo.save(user);
        genrateQRCode(user);
    }

    public String genrateQRCode(@ModelAttribute("qr") User qrDetailsPOJO) {
        try {
            BufferedImage bufferedImage = generateQRCodeImage(qrDetailsPOJO);
            File outputfile = new File("C:\\Users\\astit\\OneDrive\\Desktop\\hospital-management-system\\src\\main\\resources\\static\\images\\image_"+qrDetailsPOJO.getName()+".jpg");
            ImageIO.write(bufferedImage, "jpg", outputfile);

//            model.addAttribute("qr", qrDetailsPOJO);

        }catch (Exception e) {
            e.getMessage();
        }
        return "Success";
    }

    public static BufferedImage generateQRCodeImage(User barcodeText) throws Exception {
        StringBuilder str = new StringBuilder();
        str = str.append("Name:").append(barcodeText.getName()).append("| |").append("Email:").append(barcodeText.getEmail()).append("| |").append("MobileNo:")
                .append(barcodeText.getPhone());
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =
                barcodeWriter.encode(str.toString(), BarcodeFormat.QR_CODE, 200, 200);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }




    public String loginUser(UserRequest userRequest) {
        log.info("UserServiceImpl -- loginUser");
        String flag = "Invalid User";
        String username = userRequest.getUsername();
        log.info("username : " + username);
        String passowrd = userRequest.getPassword();
        log.info("password : " + passowrd);
        Optional<User> userFromDb = userRepo.findByUsername(username);
        if(userFromDb.isPresent())
        {
            String dbPassword = userFromDb.get().getPassword();
            if(passowrd.equalsIgnoreCase(dbPassword))
            {
                flag = "Valid User";
            }
        }
        return flag;
    }

}

