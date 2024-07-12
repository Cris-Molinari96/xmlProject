package com.bharath.xmlparsers.sax;

/*Per ottenere l'accesso agli attributi dell'elemento*/
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.bharath.xmlparsers.dto.DriversLicense;

public class SAXHandler extends DefaultHandler {

	/*Oggetto che viene settato con le informazioni del file xml*/
	private DriversLicense driversLicense;
	private String content;
	private StringBuilder stringBuilder ;

	/*! I metodi definiti vengono eseguiti tutti insieme per quanto riguarda l'incontro
	un elemento xml qualsiasi nel documento eseguono la logica implementata per ciascun elemento*/

	/* Il metodioviene chiamato quando il parser incontra nel documento da anlizzare, un elemento XML
ottenendo la gestione dell'evento (startElement nel nostro caso l'evento inizia da<DriverLicense>) infatti qName indica un nome di un elemento *(
	/*Il metodo startElement permette di inizializzare gli oggetti */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("Inizio elemento: " + qName);

		if (qName.equals("DriversLicense")) {
			setDriversLicense(new DriversLicense());
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("esecuzione di endElement() _____ ");

		System.out.println("qName -->  " + qName);

		switch (qName) {
		case "Number":
			this.getDriversLicense().setNumber(Long.parseLong(content));
			System.out.println("Number "+ content + "<-- contenuto");
			break;
		case "FirstName":
			System.out.println("FirstName "+ content+ "<-- contenuto");

			this.getDriversLicense().setFirstName(content+ "<-- contenuto");
			break;
		case "LastName":
			System.out.println("Lastname "+ content);
			this.getDriversLicense().setLastName(content+ "<-- contenuto");
			break;
		}

	}

	/*
	* ch array di caratteri contente il testo dell'attributo
	* indice di inizio della porzione di testo nell'array
	* lunghezza della porzione */
	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		System.out.println("Viene eseguito characters _______");
		// Stampa del documento xml
//		for (char c : ch) {
//			System.out.print(c);
//		}
		content = String.copyValueOf(ch, start, length).trim();
		System.out.println("Content print --> " + content);
	}

	public DriversLicense getDriversLicense() {
		return driversLicense;
	}

	public void setDriversLicense(DriversLicense driversLicense) {
		this.driversLicense = driversLicense;
	}

}
	/* Recap gestore di eventi
	- startElement legge i tag nel documento, può eseguire una logica custom come quella di istanziare un oggetto
	- character per leggere il contenuto
	- endElement per eseguire una logica richiamato per i tag di chiusura del documento
	*/
