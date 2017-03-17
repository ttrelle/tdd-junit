package tdd.junit.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class _VnrGenerator2 {

	private VnrDao dao;

	public _VnrGenerator2(VnrDao dao) {
		this.dao = dao;
	}

	public String neueVnr(String sachgebiet, LocalDate stichtag, String nachname) {
		final String sgDatum = //
			sachgebiet + "-" + //
			stichtag.format(DateTimeFormatter.ISO_LOCAL_DATE);
		final String ersterBuchstabe = nachname.substring(0,1);
		final int lnr = ermittleLaufnummerZu(stichtag, ersterBuchstabe);
		
		return sgDatum + "-" + String.format("%s%03d", ersterBuchstabe, lnr);
				
	}
	
	private int ermittleLaufnummerZu(LocalDate stichtag, String ersterBuchstabe) {
		return dao.naechsteFreiLaufnummer(stichtag, ersterBuchstabe);
	}

}
