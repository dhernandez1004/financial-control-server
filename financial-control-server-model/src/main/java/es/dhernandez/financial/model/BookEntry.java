package es.dhernandez.financial.model;

import java.util.Date;

public class BookEntry extends AbstractBookEntry {

	private final boolean avoidable;
	private final boolean punctual;
	private final Date entryDate;

	private BookEntry(Builder builder) {
		super(builder.id, builder.concept, builder.amount, builder.type);

		this.avoidable = builder.avoidable;
		this.punctual = builder.punctual;
		this.entryDate = builder.entryDate;

	}

	public static Builder createWith() {
		return new Builder();
	}

	public boolean isAvoidable() {
		return avoidable;
	}

	public boolean isPunctual() {
		return punctual;
	}

	public static class Builder {

		public Date entryDate;
		Long id;
		String concept;
		Double amount;
		boolean avoidable;
		boolean punctual;
		EntryType type;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder concept(String concept) {
			this.concept = concept;
			return this;
		}

		public Builder amount(double amount) {
			this.amount = amount;
			return this;
		}

		public Builder avoidable(boolean avoidable) {
			this.avoidable = avoidable;
			return this;
		}

		public Builder punctual(boolean punctual) {
			this.punctual = punctual;
			return this;
		}

		public Builder type(EntryType entryType) {
			this.type = entryType;
			return this;
		}

		public Builder entryDate(Date entryDate) {
			this.entryDate = entryDate;
			return this;
		}

		public BookEntry build() {
			return new BookEntry(this);

		}

	}

}
