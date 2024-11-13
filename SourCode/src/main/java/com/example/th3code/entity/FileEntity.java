package com.example.th3code.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "file")
@EqualsAndHashCode(callSuper = true)
public class FileEntity extends SuperEntity {

    @Column(name = "url", nullable = false, columnDefinition = "TEXT")
    @NotBlank(message = "URL is required")
    private String url;

    @Column(name = "file_name", nullable = false, length = 255)
    @NotBlank(message = "File name is required")
    @Size(max = 255, message = "File name must not exceed 255 characters")
    private String fileName;

    @Column(name = "extention", nullable = false, length = 50)
    @NotBlank(message = "File extension is required")
    @Size(max = 50, message = "File extension must not exceed 50 characters")
    private String extention;

}
