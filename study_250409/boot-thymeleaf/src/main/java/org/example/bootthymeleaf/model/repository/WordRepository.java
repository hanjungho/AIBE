package org.example.bootthymeleaf.model.repository;

import org.example.bootthymeleaf.model.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, String> {

    List<Word> findAllByOrderByCreatedAtAsc();
}
