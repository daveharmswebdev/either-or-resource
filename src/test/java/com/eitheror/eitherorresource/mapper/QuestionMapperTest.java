package com.eitheror.eitherorresource.mapper;

import com.eitheror.eitherorresource.domain.Question;
import com.eitheror.eitherorresource.domain.QuestionDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionMapperTest {

    QuestionMapper questionMapper;

    @BeforeEach
    public void setUp() throws Exception {
        questionMapper = new QuestionMapperImpl();
    }

    @Test
    public void questionToQuestionDto() throws Exception {
        // given
        Question question = new Question();
        question.setId(1L);
        question.setTitle("test title");
        question.setDescription("test description");
        question.setOptionId(11L);

        QuestionDto questionDto = this.questionMapper.questionToQuestionDto(question);

        assertEquals(1L, questionDto.getId());
        assertEquals("test title", questionDto.getTitle());
        assertEquals("test description", questionDto.getDescription());
        assertEquals(11L, questionDto.getOptionId());
    }

    @Test
    public void questionDtoToQuestion() throws Exception {
        // given
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(1L);
        questionDto.setTitle("test title");
        questionDto.setDescription("test description");
        questionDto.setOptionId(11L);

        Question question = this.questionMapper.questionDtoToQuestion(questionDto);

        assertEquals(1L, question.getId());
        assertEquals("test title", question.getTitle());
        assertEquals("test description", question.getDescription());
        assertEquals(11L, question.getOptionId());
    }
}
