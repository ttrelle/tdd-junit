package tdd.junit.example;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _VnrGeneratorTest {
	private _VnrGenerator generator; /** Unit under test. */
	private LocalDate stichtag;
	
	/** Fixture */
	@BeforeEach void setUp() { 
		generator = new _VnrGenerator();
		stichtag = LocalDate.of(2017, Month.FEBRUARY, 17);
	}
	
	@Test void vnr_erzeugung() {
		// gegeben sei
		String sachgebiet = "LN";
		String name = "Fasel";
		
		// wenn
		String vnr = generator.neueVnr(sachgebiet, stichtag, name);
		
		// dann
		assertThat(vnr, is("LN-2017-02-17-F001"));
	}
	
	@Test void vnr_erzeugung_ph() {
		// gegeben sei
		String sachgebiet = "PH";
		String name = "Rollt";
		
		// wenn
		String vnr = generator.neueVnr(sachgebiet, stichtag, name);
		
		// dann
		assertThat(vnr, is("PH-2017-02-17-R001"));
	}
	
}
