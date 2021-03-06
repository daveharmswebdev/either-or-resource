package com.eitheror.eitherorresource.services;

import com.eitheror.eitherorresource.domain.Question;
import com.eitheror.eitherorresource.domain.QuestionDto;
import com.eitheror.eitherorresource.mapper.QuestionMapper;
import com.eitheror.eitherorresource.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    public QuestionServiceImpl(QuestionRepository questionRepository, QuestionMapper questionMapper) {
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
    }

    @Override
    public List<QuestionDto> getAllQuestions() {

        return questionRepository.findAll().stream().map(question -> {
            QuestionDto questionDto = questionMapper.questionToQuestionDto(question);
            return questionDto;
        }).collect(Collectors.toList());
    }

    @Override
    public QuestionDto getQuestionById(Long id) {
        return questionRepository.findById(id).map(questionMapper::questionToQuestionDto).orElseThrow(() -> new ResourceNotFoundException("there isn't one"));
    }

    @Override
    public QuestionDto createNewQuestion(QuestionDto questionDto) {
        Question question = questionMapper.questionDtoToQuestion(questionDto);
        Question savedQuestion = questionRepository.save(question);

        QuestionDto returnDto = questionMapper.questionToQuestionDto(savedQuestion);

        return returnDto;
    }

    @Override
    public void deleteQuestionById(Long id) {
        getQuestionById(id);
        questionRepository.deleteById(id);
    }
}
