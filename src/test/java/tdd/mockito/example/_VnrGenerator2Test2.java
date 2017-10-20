package tdd.mockito.example;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import java.time.LocalDate;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mock;

import name.falgout.jeffrey.testing.junit5.MockitoExtension;
import tdd.junit.VnrDao;
import tdd.junit.example._VnrGenerator2;

@ExtendWith(MockitoExtension.class)
public class _VnrGenerator2Test2 {
	
	_VnrGenerator2 generator; /** Unit under test. */

	@Mock VnrDao dao;
	
	@ParameterizedTest(name="vnr_{index}: {0}")
	@CsvFileSource(resources = "/vnrs2.csv")
	void vnrs(String soll, String sachgebiet, LocalDate stichtag, 
			String name, int laufnummer) {
	
		// gegeben sei
		generator = new _VnrGenerator2(dao);
		given(dao.naechsteFreieLaufnummer(sachgebiet, name)).willReturn(laufnummer);
		
		// wenn
		String vnr = generator.neueVnr(sachgebiet, stichtag, name);
		
		// dann
		assertThat(vnr, is(soll));
		then(dao).should().naechsteFreieLaufnummer(sachgebiet, name);
		then(dao).shouldHaveNoMoreInteractions();
	}
}
