package com.nye.edzoterem.nyeuni.repository;

import com.nye.edzoterem.nyeuni.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {

}
