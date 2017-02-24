package tdd.junit.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class _VnrGenerator {

	public String neueVnr(String sachgebiet, LocalDateTime stichtag, String nachname) {
		final String sgDatum = //
			sachgebiet + "-" + //
			stichtag.format(DateTimeFormatter.ISO_LOCAL_DATE);
		final String ersterBuchstabe = nachname.substring(0,1);
		final int lnr = ermittleLaufnummerZu(sgDatum, ersterBuchstabe);
		
		return sgDatum + "-" + String.format("%s%03d", ersterBuchstabe, lnr);
				
	}
	
	private int ermittleLaufnummerZu(String sgDatum, String ersterBuchstabe) {
		return 1;
	}

}
