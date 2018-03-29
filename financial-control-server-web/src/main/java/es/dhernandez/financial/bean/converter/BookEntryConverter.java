package es.dhernandez.financial.bean.converter;

import es.dhernandez.financial.bean.BookEntry;

public class BookEntryConverter {

	public BookEntry toWebObject(es.dhernandez.financial.model.BookEntry bookEntry) {

		BookEntry webBookEntry = new BookEntry();
		webBookEntry.setId(bookEntry.getId());
		webBookEntry.setConcept(bookEntry.getConcept());
		webBookEntry.setAmount(bookEntry.getAmount());
		webBookEntry.setType(bookEntry.getType());
		webBookEntry.setAvoidable(bookEntry.isAvoidable());
		webBookEntry.setPunctual(bookEntry.isPunctual());
		webBookEntry.setEntryDate(bookEntry.getEntryDate());

		return webBookEntry;
	}

	public es.dhernandez.financial.model.BookEntry toModel(BookEntry webBookEntry) {

		return es.dhernandez.financial.model.BookEntry.createWith()
				.id(webBookEntry.getId())
				.concept(webBookEntry.getConcept())
				.amount(webBookEntry.getAmount())
				.type(webBookEntry.getType())
				.entryDate(webBookEntry.getEntryDate())
				.avoidable(webBookEntry.isAvoidable())
				.punctual(webBookEntry.isPunctual())
				.build();

	}




}
