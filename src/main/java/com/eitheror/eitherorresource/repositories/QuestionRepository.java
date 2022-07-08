package com.eitheror.eitherorresource.repositories;

import com.eitheror.eitherorresource.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
