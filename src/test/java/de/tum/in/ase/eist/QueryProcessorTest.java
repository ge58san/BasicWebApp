package de.tum.in.ase.eist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class QueryProcessorTest {

	private final QueryProcessor queryProcessor = new QueryProcessor();

	@Test
	void testEmptyStringIfCannotProcessQuery() {
		assertEquals("", queryProcessor.process("test"));
	}

	@Test
	void testKnowsAboutShakespeare() {
		String actual = queryProcessor.process("Shakespeare");
		if (!actual.contains("playwright")) {
			fail("The QueryProcessor does not know about Shakespeare.");
		}
	}

	@Test
	void isNotCaseSensitive() {
		String actual = queryProcessor.process("shakespeare");
		if (!actual.contains("playwright")) {
			fail("Your QueryProcessor should not be case sensitive.");
		}
	}

	@Test
	void testWrongName() {
		String actual = queryProcessor.process("name");
		if (!actual.contains("Mario")) {
			fail("The QueryProcessor does not know about Mario.");
		}
	}

	@Test
	void testOKName() {
		assertEquals("Mario", queryProcessor.process("name"));
	}

	@Test
	void testPlus() {
		assertEquals("6", queryProcessor.process("what is 3 plus 2"));
	}

}
