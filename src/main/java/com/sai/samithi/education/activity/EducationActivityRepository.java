package com.sai.samithi.education.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationActivityRepository extends JpaRepository<EducationActivity, Long> {
}
