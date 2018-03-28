package es.dhernandez.financial.model;


import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Arrays;

public enum EntryType {

	INCOME(1),EXPENSE(2);

	int typeId;

	EntryType(int typeId) {
		this.typeId = typeId;
	}

	public int getTypeId() {
		return typeId;
	}

	public static EntryType valueFrom(int id) {

		return Arrays.stream(EntryType.values()).filter(entry -> entry.getTypeId() == id).findAny()
				.orElseThrow(() -> new IllegalArgumentException("No EntryType found for id" + id));

	}
}
