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
@Table(name = "week_detail_checking")
@EqualsAndHashCode(callSuper = true)
public class WeekDetailCheckingEntity extends SuperEntity {

    @ManyToOne
    @JoinColumn(name = "week_checking_id", nullable = false)
    private WeekCheckingEntity weekChecking;

    @ManyToOne
    @JoinColumn(name = "file_id", nullable = false)
    private FileEntity file;

    @Column(name = "complete", nullable = false)
    private Boolean complete = false;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

}
