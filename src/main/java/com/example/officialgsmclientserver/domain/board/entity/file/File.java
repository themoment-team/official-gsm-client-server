package com.example.officialgsmclientserver.domain.board.entity.file;

import com.example.officialgsmclientserver.domain.board.entity.post.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String fileSeq;

    private String fileUrl;

    private String fileName;

    @Enumerated(EnumType.STRING)
    private FileExtension fileExtension;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_seq")
    private Post post;
}
