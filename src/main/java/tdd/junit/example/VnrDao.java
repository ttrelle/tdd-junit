package tdd.junit.example;

import java.time.LocalDate;

public interface VnrDao {
	int naechsteFreiLaufnummer(LocalDate stichtag, String buchstabe);
}
