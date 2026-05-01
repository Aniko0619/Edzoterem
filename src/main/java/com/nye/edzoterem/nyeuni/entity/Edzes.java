package com.nye.edzoterem.nyeuni.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "edzes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Edzes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long edzesId;           // volt: id

    @Column(nullable = false)
    private String edzesprogramNeve;  // volt: name

    private String edzoNeve;          // volt: edzoName

    @OneToMany(mappedBy = "edzes")
    private List<Tag> tagok = new ArrayList();  // volt: tagok (maradhat)
}