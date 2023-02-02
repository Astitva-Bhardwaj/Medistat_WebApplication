//package com.example.hospital.service;
//
//import com.example.hospital.model.user.User;
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.WriterException;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.QRCodeWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.sql.DataSource;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class QRCodeServiceImpl {
//
//    @Autowired
//    private DataSource dataSource;
//
//    public void createQRCodeAndSave(User user) throws WriterException, IOException, SQLException {
//        String data = user.getName() + "," + user.getEmail();
//        BitMatrix bitMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, 200, 200);
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        MatrixToImageWriter.writeToStream(bitMatrix, "png", baos);
//        byte[] imageInByte = baos.toByteArray();
//
//        Connection connection = dataSource.getConnection();
//        PreparedStatement statement = connection.prepareStatement("INSERT INTO users (name, username, email, password, cpassword, phone, gender, qr_code) values (?, ?, ?, ?, ?, ?, ?, ?)");
//        statement.setString(1, user.getName());
//        statement.setString(2, user.getEmail());
//        statement.setBytes(3, imageInByte);
//        statement.executeUpdate();
//        connection.close();
//    }
//}
