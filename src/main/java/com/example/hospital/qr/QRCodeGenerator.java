//package com.example.hospital.qr;
//
//import com.example.hospital.model.user.User;
//import com.google.zxing.*;
//import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.common.HybridBinarizer;
//import com.google.zxing.qrcode.QRCodeWriter;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.nio.file.FileSystems;
//import java.nio.file.Path;
//
//@Component
//@Slf4j
//public class QRCodeGenerator {
//
//
//    private String QRCODE_PATH = "C:\\Users\\astit\\OneDrive\\Desktop\\QRCODE-SERVER";
//
//    public String writeQRCode(User user) throws Exception{
//        log.info("writeQRCode");
//        String qrcode = QRCODE_PATH + user.getUsername() + "-QRCODE.png";
//        QRCodeWriter writer = new QRCodeWriter();
//        BitMatrix bitMatrix = writer.encode(user.getUsername() + "\n" + user.getEmail() + "\n" + user.getPassword(), BarcodeFormat.QR_CODE, 350, 350);
//        Path path = FileSystems.getDefault().getPath(qrcode);
//        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
//        return "QR code is generated succesfully";
//     }
//
//     public String readQRCode(String qrcodeImage) throws Exception
//     {
//         log.info("readQRCode");
//         BufferedImage bufferedImage = ImageIO.read(new File(qrcodeImage));
//         LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
//         BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
//         Result result = new MultiFormatReader().decode(binaryBitmap);
//         return result.getText();
//     }
//}
