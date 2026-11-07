package com.formforge.core.repository;

import com.formforge.core.domain.FormSchema;
import com.formforge.core.domain.FormStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FormSchemaRepository extends JpaRepository<FormSchema, UUID> {
	Optional<FormSchema> findBySlug(String slug);

	boolean existsBySlug(String slug);

	List<FormSchema> findByStatus(FormStatus status);
}