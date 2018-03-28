package es.dhernandez.financial.repository;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import es.dhernandez.financial.model.BookEntry;
import es.dhernandez.financial.model.EntryType;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BookEntryRepositoryTest {

	private static final DateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy");

	private final JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
	private final BookEntryRepository repository = new BookEntryRepository(this.jdbcTemplate);

	@Test
	public void bookEntriesBetweenDates() throws ParseException {

		Date dateFrom = DATE_FORMATTER.parse("01/03/2018");
		Date dateTo = DATE_FORMATTER.parse("20/03/2018");

		ArgumentCaptor<Object[]> queryParmsCaptor = ArgumentCaptor.forClass(Object[].class);

		this.repository.getBookEntriesBetween(dateFrom, dateTo);

		verify(this.jdbcTemplate).query(anyString(), queryParmsCaptor.capture(), ArgumentMatchers.any(RowMapper.class));
		Object[] queryParams = queryParmsCaptor.getValue();

		assertThat(queryParams[0], is(dateFrom));
		assertThat(queryParams[1], is(dateTo));

	}

	@Test
	public void createNewBookEntry() throws ParseException {

		BookEntry bookEntry = BookEntry.createWith()
				.concept("Concept")
				.amount(10.35)
				.avoidable(true)
				.punctual(true)
				.type(EntryType.EXPENSE)
				.entryDate(DATE_FORMATTER.parse("20/02/2018"))
				.build();

		this.repository.addBookEntry(bookEntry);
		verify(this.jdbcTemplate).update(anyString(), ArgumentMatchers.any(Object.class));

	}


}
