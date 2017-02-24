package tdd.junit.example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

public class _VnrGeneratorTest {
	private _VnrGenerator generator; /** Unit under test. */
	private LocalDateTime stichtag;
	
	/** Fixture */
	@Before public void setUp() { 
		generator = new _VnrGenerator();
		stichtag = LocalDateTime.of(2017, Month.FEBRUARY, 17, 0, 0);
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
}
