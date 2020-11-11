/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warl0ck.student_resource.controller;

import com.warl0ck.student_resource.model.Answer;
import com.warl0ck.student_resource.model.Question;
import com.warl0ck.student_resource.model.Resource;
import com.warl0ck.student_resource.model.User;
import com.warl0ck.student_resource.repo.AnswerRepo;
import com.warl0ck.student_resource.repo.QuestionRepo;
import com.warl0ck.student_resource.repo.QuestionTagRepo;
import com.warl0ck.student_resource.repo.ResourceRepo;
import com.warl0ck.student_resource.repo.SubscriptionRepo;
import com.warl0ck.student_resource.repo.TagRepo;
import com.warl0ck.student_resource.repo.UserRepo;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author warl0ck
 */
@RestController
public class RESTController {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private AnswerRepo answerRepo;

    @Autowired
    private QuestionTagRepo questionTagRepo;

    @Autowired
    private ResourceRepo resourceRepo;

    @Autowired
    private SubscriptionRepo subscriptionRepo;

    @Autowired
    private TagRepo tagRepo;

    @Autowired
    private UserRepo userRepo;

    
    /**
     * get list of users in the database
     * @return 
     */
    
    
    
    @GetMapping("getUsers")
    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

    /**
     * registers new user in the database
     * @param user
     * @return 
     */
    @PostMapping("register-user")
    public User registerUser(@RequestBody User user) {
        return userRepo.save(user);
    }
   
    /**
     * login registered user
     * @param user
     * @return 
     */
    @PostMapping("login-user")
    public User validateLogin(@RequestBody User user){
        return userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
    }

    /**
     * save asked question to the db
     * @param question
     * @return 
     */
    @PostMapping("ask-question")
    public String askQuestoin(@RequestBody Question question) {
        if (questionRepo.save(question) != null) {
            //question.();
            question.getApprovedAnswer();
            question.getQuestionTimestamp();
            question.getQuestionDescription();
            question.getQuestionTitle();
            return "Success";
        } else {
            return "Not Successfull";
        }

    }
    
    
    /**
     * answer to a question
     * @param answer
     * @param question_id
     * @return 
     */
    @PostMapping("answer-question/{question_id}")
    public String answerQuestion(@RequestBody Answer answer, @PathParam("question_id") int question_id) {
        if (questionRepo.existsById(question_id)) {
            Question question = questionRepo.findById(question_id).get();
            answer.setQuestionId(question);
            if (answerRepo.save(answer) != null) {
                return "Success";
            } else {
                return "Not Successfull";
            }
        }
        return "Answer not saved Successfully";
    }

    /**
     * search for questions
     * @param query
     * @return 
     */
    @GetMapping("search-question")
    public List<Question> searchQuestion(@RequestBody String query) {
        return questionRepo.search("%" + query + "%");
    }

    /**
     * 
     * @return 
     */
   @GetMapping("getQuestions")
    public Iterable<Question> getQuestions() {
        return questionRepo.findAll();
    }
    /**
     * 
     * @return 
     */
   @GetMapping("getAnswers")
    public Iterable<Answer> getAnswers() {
        return answerRepo.findAll();
    }

    @PostMapping("delete-question")
    public String deleteQuestion(@PathParam("question_id") Question question) {

        questionRepo.delete(question);
        return "Success";
    }

    @GetMapping("view-answers")
    public Iterable<Answer> viewAnswers() {
        return answerRepo.findAll();
    }

    @PostMapping("add_resource")
    public String addResource(@RequestBody Resource resource, @RequestParam("file") MultipartFile multipartFile) {
        try {
            String parent = "C:/xampp/htdocs/";//System.getProperty("java.io.tmpdir") + System.getProperty("file.separator");//use for online
            String path = "image_uploads/" + System.currentTimeMillis() + "-" + multipartFile.getOriginalFilename();
            File file = new File(parent + path);
            multipartFile.transferTo(file);

            resource.setResourcePath(path);
            resourceRepo.save(resource);

            return "Success";
        } catch (IOException | IllegalStateException e) {
            System.out.println(e.getMessage());
            return "Failed";
        }
        
    }
    
    

//    @GetMapping("search-resource-by-name")
//    public List<Resource> searchResourceByName(@RequestBody String query) {
//        return resourceRepo.search("%" + query + "%");
//    }

//    @GetMapping("search-resource-by-institution")
//    public List<Resource> searchResourceByinstitution(@RequestBody String query) {
//        return resourceRepo.searchByInstitution("%" + query + "%");
//    }
//
//    @GetMapping("search-resource-by-doc-type")
//    public List<Resource> searchResourceByDocType(@RequestBody String query) {
//        return resourceRepo.searchDocType("%" + query + "%");
//    }
//
//    @GetMapping("search-resource-by-course-code")
//    public List<Resource> searchResourceByCourseCode(@RequestBody String query) {
//        return resourceRepo.searchDocType("%" + query + "%");
//    }

    @PostMapping("delete-resource")
    public String deleteresource(@PathParam("resource_id") Resource resource) {

        resourceRepo.delete(resource);
        return "Success";
    }
    
    @GetMapping("view-resource")
    public Iterable<Resource> viewResource() {
        return resourceRepo.findAll();
    }

    
}
