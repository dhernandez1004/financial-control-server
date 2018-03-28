package es.dhernandez.financial.model;

import java.util.Date;

public class FixedBookEntry extends AbstractBookEntry {

	private final Date endDate;

	private FixedBookEntry(Builder builder) {
		super(builder.id, builder.concept, builder.amount, builder.type);

		this.endDate = builder.endDate;

	}

	public static Builder createWith() {
		return new Builder();
	}

	public Date getEndDate() {
		return endDate;
	}

	public static class Builder {

		Long id;
		String concept;
		Double amount;
		Date endDate;
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

		public Builder endDate(Date endDate) {
			this.endDate = endDate;
			return this;
		}

		public Builder type(EntryType entryType) {
			this.type = entryType;
			return this;
		}

		public FixedBookEntry build() {
			return new FixedBookEntry(this);

		}

	}


}
