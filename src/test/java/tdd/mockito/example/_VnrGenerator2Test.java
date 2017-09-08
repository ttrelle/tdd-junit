package tdd.mockito.example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import tdd.junit.VnrDao;
import tdd.junit.example._VnrGenerator2;

public class _VnrGenerator2Test {
	
	private _VnrGenerator2 generator; /** Unit under test. */
	private LocalDate stichtag;
	
	@Rule public MockitoRule mockRule = MockitoJUnit.rule();	
	
	@Mock private VnrDao dao;
	
	/** Fixture */
	@Before public void setUp() { 
		generator = new _VnrGenerator2(dao);
		stichtag = LocalDate.of(2017, Month.FEBRUARY, 17);
	}
	
	@Test public void vnr_erzeugung() {
		// gegeben sei
		String sachgebiet = "LN";
		String name = "Fasel";
		given(dao.naechsteFreieLaufnummer(sachgebiet, name)).willReturn(1);
		
		// wenn
		String vnr = generator.neueVnr(sachgebiet, stichtag, name);
		
		// dann
		assertThat(vnr, is("LN-2017-02-17-F001"));
		then(dao).should().naechsteFreieLaufnummer(sachgebiet, name);
		then(dao).shouldHaveNoMoreInteractions();
	}
}
