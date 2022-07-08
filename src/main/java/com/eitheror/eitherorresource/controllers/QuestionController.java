package com.eitheror.eitherorresource.controllers;

import com.eitheror.eitherorresource.domain.QuestionDto;
import com.eitheror.eitherorresource.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<QuestionDto> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public QuestionDto getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionDto createNewQuestion(@RequestBody QuestionDto questionDto) {
        return questionService.createNewQuestion(questionDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestionById(id);
    }
}
