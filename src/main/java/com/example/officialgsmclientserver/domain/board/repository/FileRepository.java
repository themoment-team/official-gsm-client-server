package com.example.officialgsmclientserver.domain.board.repository;

import com.example.officialgsmclientserver.domain.board.entity.file.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, String> {
}
