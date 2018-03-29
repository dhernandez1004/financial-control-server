package es.dhernandez.financial.controller;

import es.dhernandez.financial.bean.BookEntry;
import es.dhernandez.financial.bean.converter.BookEntryConverter;
import es.dhernandez.financial.repository.BookEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("balance")
public class BalanceController {

	private static final BookEntryConverter BOOK_ENTRY_CONVERTER = new BookEntryConverter();

	@Autowired
	private BookEntryRepository repository;

	@RequestMapping(path = "/between/{dateFrom}/and/{dateTo}", method = RequestMethod.GET, produces = "application/json")
	public List<BookEntry> getBalanceBetweenDates(@PathVariable Date dateFrom, @PathVariable Date dateTo) {
		return repository.getBookEntriesBetween(dateFrom, dateTo).stream().map(bookEntry -> BOOK_ENTRY_CONVERTER.toWebObject(bookEntry))
				.collect(Collectors.toList());
	}

}
