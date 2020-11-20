package com.jee.helloworld.repository;

import com.jee.helloworld.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer> {
}
