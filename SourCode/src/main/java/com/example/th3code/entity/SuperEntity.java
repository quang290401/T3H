package com.example.th3code.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "last_modified_at")
    private Timestamp lastModifiedAt;

    @Column(name = "created_by", nullable = false, length = 255)
    @NotBlank(message = "Created by is required")
    @Size(max = 255, message = "Created by must not exceed 255 characters")
    private String createdBy;

    @Column(name = "last_modified_by", length = 255)
    @Size(max = 255, message = "Last modified by must not exceed 255 characters")
    private String lastModifiedBy;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;




}



