package com.sai.samithi.youth.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YouthTeamRepository extends JpaRepository<YouthTeam, Long> {
}
