package com.nye.edzoterem.nyeuni.repository;


import com.nye.edzoterem.nyeuni.entity.Edzes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdzesRepository extends JpaRepository<Edzes, Long> {

}

// < entity-t adtunk meg, mert itt van definiálva minden, ami az adatbázissal kapcsolatos