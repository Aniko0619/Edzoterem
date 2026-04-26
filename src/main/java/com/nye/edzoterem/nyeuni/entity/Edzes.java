
package com.nye.edzoterem.nyeuni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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