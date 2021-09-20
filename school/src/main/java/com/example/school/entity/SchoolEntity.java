package com.example.school.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "school")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class SchoolEntity {

    @Id
    @Column(name = "id_school", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @CreationTimestamp
    @Column(name = "dat_creation", nullable = false, updatable = false)
    private LocalDateTime datCreation;

    @UpdateTimestamp
    @Column(name = "dat_update", nullable = false)
    private LocalDateTime datUpdate;
}
