package com.sai.samithi.seva.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SevaActivityRepository extends JpaRepository<SevaActivity, Long> {
}
