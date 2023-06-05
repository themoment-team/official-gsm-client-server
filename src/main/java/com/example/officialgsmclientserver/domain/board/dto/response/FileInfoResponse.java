package com.example.officialgsmclientserver.domain.board.dto.response;

import com.example.officialgsmclientserver.domain.board.entity.file.File;
import com.example.officialgsmclientserver.domain.board.entity.file.FileExtension;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FileInfoResponse {

    private String fileUrl;
    private String fileName;
    private FileExtension fileExtension;

    public FileInfoResponse(File file) {
        this.fileUrl = file.getFileUrl();
        this.fileName = file.getFileName();
        this.fileExtension = file.getFileExtension();
    }
}
