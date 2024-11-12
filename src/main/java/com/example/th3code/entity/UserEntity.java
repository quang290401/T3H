package com.example.th3code.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends SuperEntity {

    @Column(name = "username", nullable = false, length = 100, unique = true)
    @NotBlank(message = "Username is required")
    @Size(max = 100, message = "Username must not exceed 100 characters")
    private String username;

    @Column(name = "role", nullable = false, length = 50)
    @NotBlank(message = "Role is required")
    @Size(max = 50, message = "Role must not exceed 50 characters")
    private String role;

    @Column(name = "full_name", length = 255)
    @Size(max = 255, message = "Full name must not exceed 255 characters")
    private String fullName;

    @Column(name = "email", nullable = false, length = 255, unique = true)
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @Column(name = "profile_picture_url", columnDefinition = "TEXT")
    private String profilePictureUrl;

    @Column(name = "status", length = 50)
    @Size(max = 50, message = "Status must not exceed 50 characters")
    private String status;

    @Column(name = "region", length = 100)
    @Size(max = 100, message = "Region must not exceed 100 characters")
    private String region;

    @Column(name = "is_email_verified", nullable = false)
    private Boolean isEmailVerified = false;

    @Column(name = "last_login_at")
    private Timestamp lastLoginAt;

    @Column(name = "language_setting", length = 50)
    @Size(max = 50, message = "Language setting must not exceed 50 characters")
    private String languageSetting;

    @Column(name = "notification", nullable = false)
    private Boolean notification = true;

    @Column(name = "dark_mode", nullable = false)
    private Boolean darkMode = false;

    @Column(name = "password", nullable = false, length = 255)
    @NotBlank(message = "Password is required")
    @Size(max = 255, message = "Password must not exceed 255 characters")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable( // tự động tạo ra bảng phụ user_roles
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"), /* Cấu hình để thuộc tính user_id trong bảng phụ user_roles
                                                           sẽ là khóa phụ tham chiếu tới cột id trong bảng users*/
            inverseJoinColumns = @JoinColumn(name = "role_id")/* Cấu hình để thuộc tính role_id trong bảng phụ user_roles
                                                           sẽ là khóa phụ tham chiếu tới cột id trong bảng roles*/
    )
    // 1 user có nhiều quyền
    private Set<RoleEntity> roleEntities = new HashSet<>();
}
