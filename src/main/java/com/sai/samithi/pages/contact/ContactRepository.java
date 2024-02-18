package com.sai.samithi.pages.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
