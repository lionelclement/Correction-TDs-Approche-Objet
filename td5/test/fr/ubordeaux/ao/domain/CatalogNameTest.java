package fr.ubordeaux.ao.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class CatalogNameTest {

	@Test
	public void createCatalogName() {
		try {
			CatalogName cn = new CatalogName("tool s");
			CatalogName cn2 = new CatalogName("tools");
			assertTrue(cn.equals(cn2));
		} catch (ReferenceManagementException ex) {
			assertTrue(false);
		}
		try {
			new CatalogName("My Catalog");
			assertTrue(false);
		} catch (ReferenceManagementException ex) {
			assertTrue(true);
		}
		try {
			new CatalogName("4Catalog");
			assertTrue(false);
		} catch (ReferenceManagementException ex) {
			assertTrue(true);
		}
	}

}
