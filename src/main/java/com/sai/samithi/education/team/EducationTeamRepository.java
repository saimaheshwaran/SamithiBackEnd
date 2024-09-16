package com.sai.samithi.education.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationTeamRepository extends JpaRepository<EducationTeam, Long> {
}
