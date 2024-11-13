package com.example.th3code.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "followed_user_id", nullable = false)
    private Integer followedUserId;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity category;

    @Column(name = "name", nullable = false, length = 255)
    @NotBlank(message = "Course name is required")
    @Size(max = 255, message = "Course name must not exceed 255 characters")
    private String name;

    @Column(name = "code", nullable = false, length = 100, unique = true)
    @NotBlank(message = "Course code is required")
    @Size(max = 100, message = "Course code must not exceed 100 characters")
    private String code;

    @Column(name = "description", columnDefinition = "TEXT")
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;

    @Column(name = "difficulty_level", length = 50)
    @Size(max = 50, message = "Difficulty level must not exceed 50 characters")
    private String difficultyLevel;

    @Column(name = "language", length = 50)
    @NotBlank(message = "Language is required")
    @Size(max = 50, message = "Language must not exceed 50 characters")
    private String language;

    @Column(name = "price", precision = 10, scale = 2)
    @DecimalMin(value = "0.0", inclusive = true, message = "Price must be at least 0")
    private BigDecimal price;

    @Column(name = "rating", precision = 3, scale = 2)
    @DecimalMin(value = "0.0", inclusive = true, message = "Rating must be at least 0")
    @DecimalMax(value = "5.0", inclusive = true, message = "Rating must not exceed 5")
    private BigDecimal rating;





    // Getters and setters
}
