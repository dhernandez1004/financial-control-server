package es.dhernandez.financial.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import es.dhernandez.financial.model.EntryType;

import java.util.Date;

public class BookEntry {

	protected Long id;
	protected String concept;
	protected Double amount;
	protected EntryType type;
	private boolean avoidable;
	private boolean punctual;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date entryDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public EntryType getType() {
		return type;
	}

	public void setType(EntryType type) {
		this.type = type;
	}

	public boolean isAvoidable() {
		return avoidable;
	}

	public void setAvoidable(boolean avoidable) {
		this.avoidable = avoidable;
	}

	public boolean isPunctual() {
		return punctual;
	}

	public void setPunctual(boolean punctual) {
		this.punctual = punctual;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
}
