package com.eitheror.eitherorresource.services;

import com.eitheror.eitherorresource.domain.Question;
import com.eitheror.eitherorresource.domain.QuestionDto;

import java.util.List;

public interface QuestionService {
    List<QuestionDto> getAllQuestions();

    QuestionDto getQuestionById(Long id);

    QuestionDto createNewQuestion(Question question);

    void deleteQuestionById(Long id);
}
