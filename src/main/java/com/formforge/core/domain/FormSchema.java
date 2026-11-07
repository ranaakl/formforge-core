package com.formforge.core.domain;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "form_schemas")
public class FormSchema {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false, unique = true)
	private String slug;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private FormStatus status = FormStatus.DRAFT;

	@Column(nullable = false)
	private Integer version = 1;

	@Lob
	@Column(nullable = false, columnDefinition = "CLOB")
	private String schemaDefinition;

	@Column(nullable = false, updatable = false)
	private Instant createdAt = Instant.now();

	@Column(nullable = false)
	private Instant updatedAt = Instant.now();

	public FormSchema() {
	}

	public FormSchema(String title, String slug, String schemaDefinition) {
		this.title = title;
		this.slug = slug;
		this.schemaDefinition = schemaDefinition;
		this.status = FormStatus.DRAFT;
		this.version = 1;
		this.createdAt = Instant.now();
		this.updatedAt = Instant.now();
	}

	@PreUpdate
	public void onUpdate() {
		this.updatedAt = Instant.now();
	}

	public UUID getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public FormStatus getStatus() {
		return status;
	}

	public void setStatus(FormStatus status) {
		this.status = status;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getSchemaDefinition() {
		return schemaDefinition;
	}

	public void setSchemaDefinition(String schemaDefinition) {
		this.schemaDefinition = schemaDefinition;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}
}