package fr.ubordeaux.ao.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatalogName {

	private String value;

	public CatalogName(String value) throws ReferenceManagementException {
		Pattern pattern = Pattern.compile("[a-zA-Z]{1,10}");
		Matcher matcher = pattern.matcher(value);
		if (!matcher.matches())
			throw new ReferenceManagementException(value, "A catalog name should have less than 10 alphabetical chars");
		this.value = value;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof CatalogName))
			return false;
		return this.value.compareTo(((CatalogName) other).value) == 0;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
