package com.example.school.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentEntity {

    @Id
    @Column(name = "id_student", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "id_school")
    private SchoolEntity school;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime datCreation;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime datUpdate;

}
