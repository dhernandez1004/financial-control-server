package es.dhernandez.financial.model;

public abstract class AbstractBookEntry {
	protected final  Long id;
	protected final String concept;
	protected final Double amount;
	protected final EntryType type;

	AbstractBookEntry(Long id, String concept, Double amount, EntryType type) {
		this.concept = concept;
		this.type = type;
		this.amount = amount;
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getConcept() {
		return concept;
	}

	public Double getAmount() {
		return amount;
	}

	public EntryType getType() {
		return type;
	}
}
