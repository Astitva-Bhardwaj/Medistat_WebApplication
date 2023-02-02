package com.example.hospital.repository.file;

import com.example.hospital.model.file.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

    Optional<FileDB> findByName(String fileName);

    Optional<FileDB> findByUserId(int userId);
}
