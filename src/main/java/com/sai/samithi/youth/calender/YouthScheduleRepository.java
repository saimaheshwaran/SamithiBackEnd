package com.sai.samithi.youth.calender;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YouthScheduleRepository extends JpaRepository<YouthSchedule, Long> {
}
