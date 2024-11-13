package com.example.th3code.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "My_Certificates")
@EqualsAndHashCode(callSuper = true)
public class MyCertificatesEntity extends SuperEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseEntity course;

    @Column(name = "issue_date", nullable = false)
    private Timestamp issueDate;

    @Column(name = "completion_date", nullable = false)
    private Timestamp completionDate;

    @Column(name = "grade", precision = 5, scale = 2)
    @DecimalMin(value = "0.0", inclusive = false, message = "Grade must be greater than 0")
    @DecimalMax(value = "10.0", inclusive = true, message = "Grade must be less than or equal to 10")
    private BigDecimal grade;

    @Column(name = "certificate_url", nullable = false, columnDefinition = "TEXT")
    @NotBlank(message = "Certificate URL is required")
    private String certificateUrl;

    @Column(name = "status", nullable = false, length = 50)
    @NotBlank(message = "Status is required")
    @Size(max = 50, message = "Status must not exceed 50 characters")
    private String status;

    @Column(name = "issued_by", nullable = false, length = 100)
    @NotBlank(message = "Issued by is required")
    @Size(max = 100, message = "Issued by must not exceed 100 characters")
    private String issuedBy;
}
