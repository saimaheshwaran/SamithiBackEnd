package com.sai.samithi.devotional.prayers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrayersPostsRepository extends JpaRepository<PrayersPosts, Long> {
}
