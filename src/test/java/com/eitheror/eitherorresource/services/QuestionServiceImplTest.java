package com.eitheror.eitherorresource.services;

import com.eitheror.eitherorresource.domain.Question;
import com.eitheror.eitherorresource.domain.QuestionDto;
import com.eitheror.eitherorresource.mapper.QuestionMapper;
import com.eitheror.eitherorresource.mapper.QuestionMapperImpl;
import com.eitheror.eitherorresource.repositories.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class QuestionServiceImplTest {

    QuestionService questionService;
    QuestionMapper questionMapper;

    @Mock
    QuestionRepository questionRepository;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        questionMapper = new QuestionMapperImpl();
        questionService = new QuestionServiceImpl(questionRepository, questionMapper);
    }

    @Test
    public void getAllQuestions() throws Exception {
        List<Question> questions = Arrays.asList(new Question(), new Question(), new Question());

        when(questionRepository.findAll()).thenReturn(questions);

        List<QuestionDto> questionDtos = questionService.getAllQuestions();

        assertEquals(3, questionDtos.size());
    }

    @Test
    void getQuestionById() throws Exception {
        // given
        Question question = new Question();
        question.setId(1L);
        question.setTitle("test title");
        question.setDescription("test description");
        question.setOptionId(2L);

        when(questionRepository.findById(anyLong())).thenReturn(Optional.of(question));

        QuestionDto questionDto = questionService.getQuestionById(1L);

        assertEquals(1L, questionDto.getId());
        assertEquals("test title", questionDto.getTitle());
        assertEquals("test description", questionDto.getDescription());
        assertEquals(2L, questionDto.getOptionId());
    }

    @Test
    void createNewQuestion() throws Exception {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(1L);
        questionDto.setTitle("test title");
        questionDto.setDescription("test description");
        questionDto.setOptionId(2L);

        Question question = new Question();
        question.setId(1L);
        question.setTitle("test title");
        question.setDescription("test description");
        question.setOptionId(2L);

        when(questionRepository.save(any(Question.class))).thenReturn(question);

        QuestionDto newQuestionDto = questionService.createNewQuestion(questionDto);

        assertEquals(1L, newQuestionDto.getId());
        assertEquals("test title", newQuestionDto.getTitle());
        assertEquals("test description", newQuestionDto.getDescription());
        assertEquals(2L, newQuestionDto.getOptionId());
    }
}
