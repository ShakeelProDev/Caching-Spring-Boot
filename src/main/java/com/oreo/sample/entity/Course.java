package com.oreo.sample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="courses")
public class Course {

    @Id
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Long user_id;
}
