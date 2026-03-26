
package com.nye.edzoterem.nyeuni.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "edzesek")                //  Adatbázis tábla neve
@Data                                     // lombokból jön, getter, setter, ToString,
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Edzes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String edzoName;

    @OneToMany(mappedBy = "edzes")
    private List<Tag> tagok = new ArrayList<>();


}