package com.formforge.core.domain;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "form_submissions")
public class FormSubmission {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "form_schema_id", nullable = false)
	private FormSchema formSchema;

	@Lob
	@Column(nullable = false, columnDefinition = "CLOB")
	private String payload;

	private String submitterEmail;

	@Column(nullable = false, updatable = false)
	private Instant submittedAt = Instant.now();

	public FormSubmission() {
	}

	public FormSubmission(FormSchema formSchema, String payload, String submitterEmail) {
		this.formSchema = formSchema;
		this.payload = payload;
		this.submitterEmail = submitterEmail;
		this.submittedAt = Instant.now();
	}

	public UUID getId() {
		return id;
	}

	public FormSchema getFormSchema() {
		return formSchema;
	}

	public void setFormSchema(FormSchema formSchema) {
		this.formSchema = formSchema;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getSubmitterEmail() {
		return submitterEmail;
	}

	public void setSubmitterEmail(String submitterEmail) {
		this.submitterEmail = submitterEmail;
	}

	public Instant getSubmittedAt() {
		return submittedAt;
	}
}