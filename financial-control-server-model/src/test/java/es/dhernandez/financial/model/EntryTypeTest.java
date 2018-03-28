package es.dhernandez.financial.model;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class EntryTypeTest {

	@Test
	public void validEntryType() {

		assertThat(EntryType.valueFrom(EntryType.INCOME.getTypeId()), is(EntryType.INCOME));

	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidEntryType() {

		EntryType.valueFrom(2000);

	}

}
