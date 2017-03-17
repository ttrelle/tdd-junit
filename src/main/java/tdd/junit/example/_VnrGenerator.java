package tdd.junit.example;

import java.time.LocalDate;

public class _VnrGenerator {

	public String neueVnr(String sg, LocalDate stichtag, String nachname) {
		final int lnr = ermittleLaufnummerZu(sg, nachname);
		
		return String.format("%s-%2$tY-%2$tm-%2td-%.1s%03d", sg, stichtag, nachname, lnr);
	}
	
	private int ermittleLaufnummerZu(String sg, String nachname) {
		return 1;
	}

}
