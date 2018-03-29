package es.dhernandez.financial.controller;

import es.dhernandez.financial.bean.BookEntry;
import es.dhernandez.financial.bean.converter.BookEntryConverter;
import es.dhernandez.financial.repository.BookEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bookEntries")
public class BookEntryController {

	private static final BookEntryConverter BOOK_ENTRY_CONVERTER = new BookEntryConverter();

	@Autowired
	private BookEntryRepository repository;

	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void addBookEntry(@RequestBody BookEntry bookEntry) {
		repository.addBookEntry(BOOK_ENTRY_CONVERTER.toModel(bookEntry));
	}

}
