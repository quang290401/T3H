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
@Table(name = "week")
@EqualsAndHashCode(callSuper = true)
public class WeekEntity extends SuperEntity {

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private ModuleEntity module;

    @Column(name = "name", nullable = false, length = 255)
    @NotBlank(message = "Week name is required")
    @Size(max = 255, message = "Week name must not exceed 255 characters")
    private String name;

    @Column(name = "code", nullable = false, length = 100, unique = true)
    @NotBlank(message = "Week code is required")
    @Size(max = 100, message = "Week code must not exceed 100 characters")
    private String code;
}
