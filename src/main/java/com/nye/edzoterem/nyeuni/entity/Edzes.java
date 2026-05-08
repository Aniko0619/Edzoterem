package com.nye.edzoterem.nyeuni.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;

@Entity                                   // Ez egy adatbázis tábla
@Table(name = "edzes")                    // A tábla neve
@Data                                     // Lombok: getter, setter, toString, equals,
                                          //         hashCode
@NoArgsConstructor                        // Lombok: üres konstruktor (JPA kell)
@AllArgsConstructor                       // Lombok: összes paraméteres konstruktor
@Builder                                  //   Lombok: builder minta
                                          //          (pl. Edzes.builder().name("Aerobik").build())
public class Edzes {
    @Id                                   //  Ez az elsődleges kulcs (primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-növekvő szám az adatbázisban
    private Long edzesId;                 // volt: id

    @Column(nullable = false)             // Ez az oszlop nem lehet NULL az adatbázisban
    private String edzesprogramNeve;      // volt: name

    private String edzoNeve;              // volt: edzoName

    @OneToMany(mappedBy = "edzes")
    private List<Tag> tagok = new ArrayList();  // volt: tagok (maradhat)
}