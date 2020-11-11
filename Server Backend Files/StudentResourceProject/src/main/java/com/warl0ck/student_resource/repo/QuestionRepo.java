/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warl0ck.student_resource.repo;


import com.warl0ck.student_resource.model.Question;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author warl0ck
 */
public interface QuestionRepo extends CrudRepository<Question, Integer>{

    @Query("SELECT q FROM Question q WHERE q.questionTitle LIKE :query")
    List<Question> search(@Param("query") String query);
    
    @Query("SELECT q FROM Question q WHERE q.questionId = :query")
    List<Question> findbyId(@Param("query") String query);
    
   
    
}


