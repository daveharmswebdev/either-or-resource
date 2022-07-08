package com.eitheror.eitherorresource.mapper;

import com.eitheror.eitherorresource.domain.Question;
import com.eitheror.eitherorresource.domain.QuestionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Question questionDtoToQuestion(QuestionDto questionDto);
    
    QuestionDto questionToQuestionDto(Question question);

}
