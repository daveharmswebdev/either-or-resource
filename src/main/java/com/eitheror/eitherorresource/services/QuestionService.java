package com.eitheror.eitherorresource.services;

import com.eitheror.eitherorresource.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();

    Question getQuestionById(Long id);

    Question createNewQuestion(Question question);

    void deleteQuestionById(Long id);
}
