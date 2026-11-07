package com.formforge.core.repository;

import com.formforge.core.domain.FormSubmission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FormSubmissionRepository extends JpaRepository<FormSubmission, UUID> {
	Page<FormSubmission> findByFormSchemaId(UUID formSchemaId, Pageable pageable);

	long countByFormSchemaId(UUID formSchemaId);
}