package com.nye.edzoterem.nyeuni.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Table(name = "tag")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;           // volt: id

    @Column(nullable = false)
    private String tagNeve;       // volt: name
    private Integer kor;          // volt: age (átnevezheted vagy maradhat age)

    @ManyToOne
    @JoinColumn(name = "edzes_id")
    private Edzes edzes;          // marad
}