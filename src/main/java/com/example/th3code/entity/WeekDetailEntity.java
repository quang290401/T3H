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
@Table(name = "week_detail")
@EqualsAndHashCode(callSuper = true)
public class WeekDetailEntity extends SuperEntity {

    @ManyToOne
    @JoinColumn(name = "file_id", nullable = false)
    private FileEntity file;

    @ManyToOne
    @JoinColumn(name = "week_id", nullable = false)
    private WeekEntity week;

    @Column(name = "name", nullable = false, length = 255)
    @NotBlank(message = "Week detail name is required")
    @Size(max = 255, message = "Week detail name must not exceed 255 characters")
    private String name;

    @Column(name = "code", nullable = false, length = 100, unique = true)
    @NotBlank(message = "Week detail code is required")
    @Size(max = 100, message = "Week detail code must not exceed 100 characters")
    private String code;
}
