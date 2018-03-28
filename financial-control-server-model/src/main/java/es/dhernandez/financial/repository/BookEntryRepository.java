package es.dhernandez.financial.repository;

import es.dhernandez.financial.model.BookEntry;
import es.dhernandez.financial.model.EntryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class BookEntryRepository {

	public static final String FIND_BETWEEN_DATES = "select id, concept, amount, avoidable_entry, punctual_entry, type_id, entry_date" +
			" from book_entries where entry_date between ? and ?";
	public static final RowMapper<BookEntry> BOOK_ENTRY_ROW_MAPPER = (ResultSet rs, int index) ->
		BookEntry.createWith()
			.id(rs.getLong("id"))
			.entryDate(rs.getDate("entry_date"))
			.concept(rs.getString("concept"))
			.amount(rs.getDouble("amount"))
			.type(EntryType.valueFrom(rs.getInt("type_id")))
			.avoidable(rs.getBoolean("avoidable_entry"))
			.punctual(rs.getBoolean("punctual_entry"))
			.build();
	public static final String INSERT_BOOK_ENTRY = "insert into book_entries" +
			"(concept, amount, type_id, avoidable_entry, punctual_entry, entry_date) values (?, ?, ?, ?, ?, ?)";

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public BookEntryRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<BookEntry> getBookEntriesBetween(Date dateFrom, Date dateTo) {

		return this.jdbcTemplate.query(FIND_BETWEEN_DATES, new Object[]{dateFrom, dateTo}, BOOK_ENTRY_ROW_MAPPER);

	}

	public void addBookEntry(BookEntry bookEntry) {

		this.jdbcTemplate.update(INSERT_BOOK_ENTRY,
			bookEntry.getConcept(), bookEntry.getAmount(), bookEntry.getType().getTypeId(),
			bookEntry.isAvoidable(), bookEntry.isPunctual(), bookEntry.getEntryDate());

	}
}
