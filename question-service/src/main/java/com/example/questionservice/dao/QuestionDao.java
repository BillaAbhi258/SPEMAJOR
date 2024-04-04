package com.example.questionservice.dao;


import com.example.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
  List<Question>  findByCategory(String category);

  @Query(value = "SELECT q.id FROM questions q WHERE q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
  List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}
