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
@Table(name = "module")
@EqualsAndHashCode(callSuper = true)
public class ModuleEntity extends SuperEntity {

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseEntity course;

    @Column(name = "name", nullable = false, length = 255)
    @NotBlank(message = "Module name is required")
    @Size(max = 255, message = "Module name must not exceed 255 characters")
    private String name;

    @Column(name = "code", nullable = false, length = 100, unique = true)
    @NotBlank(message = "Module code is required")
    @Size(max = 100, message = "Module code must not exceed 100 characters")
    private String code;
}
