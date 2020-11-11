/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warl0ck.student_resource.repo;

import com.warl0ck.student_resource.model.Answer;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author warl0ck
 */
public interface AnswerRepo extends CrudRepository<Answer, Integer>{
    
  
}
