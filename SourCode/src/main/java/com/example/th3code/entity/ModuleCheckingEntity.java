package com.example.th3code.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "module_checking")
@EqualsAndHashCode(callSuper = true)
public class ModuleCheckingEntity extends SuperEntity {

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private ModuleEntity module;

    @ManyToOne
    @JoinColumn(name = "my_course_id", nullable = false)
    private MyCourseEntity myCourse;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

}
