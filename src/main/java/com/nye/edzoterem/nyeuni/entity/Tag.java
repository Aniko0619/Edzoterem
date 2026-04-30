package com.nye.edzoterem.nyeuni.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Table(name = "tagok")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private Integer age;


    @ManyToOne
    @JoinColumn(name = "edzes_id")
    private Edzes edzes;
}

