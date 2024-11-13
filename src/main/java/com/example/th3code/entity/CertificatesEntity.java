package com.example.th3code.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Certificates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificatesEntity extends SuperEntity{
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseEntity course;

    @Column(name = "name", nullable = false, length = 255)
    @NotBlank(message = "Course name is required")
    @Size(max = 255, message = "Course name must not exceed 255 characters")
    private String name;

    @Column(name = "code", nullable = false, length = 100, unique = true)
    @NotBlank(message = "Course code is required")
    @Size(max = 100, message = "Course code must not exceed 100 characters")
    private String code;

    @Column(name = "Describe", columnDefinition = "TEXT")
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String describe;
}
