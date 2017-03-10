package tdd.junit.example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

public class _VnrGeneratorTest {
	private _VnrGenerator generator; /** Unit under test. */
	private LocalDate stichtag;
	
	/** Fixture */
	@Before public void setUp() { 
		generator = new _VnrGenerator();
		stichtag = LocalDate.of(2017, Month.FEBRUARY, 17);
	}
	
	@Test public void vnr_erzeugung() {
		// gegeben sei
		String sachgebiet = "LN";
		String name = "Fasel";
		
		// wenn
		String vnr = generator.neueVnr(sachgebiet, stichtag, name);
		
		// dann
		assertThat(vnr, is("LN-2017-02-17-F001"));
	}
	
	@Test public void vnr_erzeugung_ph() {
		// gegeben sei
		String sachgebiet = "PH";
		String name = "Rollt";
		
		// wenn
		String vnr = generator.neueVnr(sachgebiet, stichtag, name);
		
		// dann
		assertThat(vnr, is("PH-20170328-R-001"));
	}
	
}
