package com.eitheror.eitherorresource.services;

import com.eitheror.eitherorresource.domain.Question;
import com.eitheror.eitherorresource.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Question createNewQuestion(Question question) {

        Question savedQuestion = questionRepository.save(question);

        return savedQuestion;
    }

    @Override
    public void deleteQuestionById(Long id) {
        getQuestionById(id);
        questionRepository.deleteById(id);
    }
}
