package com.example.th3code.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class RoleEntity extends SuperEntity {


    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;
    @Column(name = "code", length =255,nullable = false, unique = true)
    private String code;

    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "roleEntities")
    private Set<UserEntity> userEntities = new HashSet<>();
}
