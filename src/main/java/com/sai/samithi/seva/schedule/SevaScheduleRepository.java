package com.sai.samithi.seva.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SevaScheduleRepository extends JpaRepository<SevaSchedule, Long> {
}
