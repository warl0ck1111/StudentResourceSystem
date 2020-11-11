/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warl0ck.student_resource.repo;

import com.warl0ck.student_resource.model.Resource;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author warl0ck
 */
public interface ResourceRepo extends CrudRepository<Resource, Integer>{
    
//     @Query("SELECT q FROM Resource r WHERE r.courseTitle LIKE :query")
//    List<Resource> search(@Param("query") String query);
//    
//     @Query("SELECT q FROM Resource r WHERE r.institution LIKE :query")
//    List<Resource> searchByInstitution(@Param("query") String query);
//    
//     @Query("SELECT q FROM Resource r WHERE r.courseCode LIKE :query")
//    List<Resource> searchByCourseCode(@Param("query") String query);
//    
//     @Query("SELECT q FROM Resource r WHERE r.resourceType LIKE :query")
//    List<Resource> searchDocType(@Param("query") String query);
    
}
