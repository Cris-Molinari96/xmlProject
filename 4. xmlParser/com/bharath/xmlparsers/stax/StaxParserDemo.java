package com.bharath.xmlparsers.stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.bharath.xmlparsers.dto.Address;
import com.bharath.xmlparsers.dto.DriversLicense;

public class StaxParserDemo {

    public static void main(String[] args) throws XMLStreamException {
        // Si ottiene l'istanza del parse
        XMLInputFactory factory = XMLInputFactory.newInstance();
        // Inzia il parsing del documento, accessibile nel metodo
        XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(ClassLoader
                .getSystemResourceAsStream("xml/DriversLicense.xml"));

        DriversLicense license = null;
        Address address = null;
        String content = null;
        String currentElement = null;

        // Leggiamo il documento fino alla fine di tutti gli elementi
        while (xmlStreamReader.hasNext()) {

            int event = xmlStreamReader.next();

            switch (event) {
                // In questa prima parte dobbiamo prevedere il primo elemento e gli elementi figli i quali contengono altri elementi al loro interno per poteri leggere e recuperare
                // Si incontra il primo elemento
                case XMLStreamConstants.START_ELEMENT:
                    // nomeElemento
                    currentElement = xmlStreamReader.getLocalName();
                    if (currentElement.equals("DriversLicense")) {
                        license = new DriversLicense();
                        // Gestione degli attributi di DriversLicense
                        for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
                            System.out.println("Attributi documento --> "+ xmlStreamReader.getAttributePrefix(i));
                        }

                    } else if (currentElement.equals("Address")) {
                        address = new Address();
                    }
                    break;
                    // Iniziamo a settare le informazioni negli oggetti
                case XMLStreamConstants.CHARACTERS:
                    content = xmlStreamReader.getText().trim();
                    if (!content.isEmpty()) {
                        switch (currentElement) {
                            case "Number":
                                license.setNumber(Long.parseLong(content));
                                break;
                            case "FirstName":
                                license.setFirstName(content);
                                break;
                            case "LastName":
                                license.setLastName(content);
                                break;
                                // Fino a quando non incontra l'elemento figlio durante l'iterazione, qui non entrerà mai
                            case "street":
                                address.setStreet(content);
                                break;
                            case "city":
                                address.setCity(content);
                                break;
                            case "state":
                                address.setState(content);
                                break;
                            case "country":
                                address.setCountry(content);
                                break;
                            case "zipcode":
                                address.setZipcode(content);
                                break;
                        }
                    }
                    break;
                    // Per completare, abbiamo license settato, e address settato per cui andremo a finire il settaggio con licence.setAddress()
                case XMLStreamConstants.END_ELEMENT:
                    if (xmlStreamReader.getLocalName().equals("Address")) {
                        System.out.println("Vengo eseguito settando address in license");
                        license.setAddress(address);
                    }
                    break;
            }
        }

        System.out.println(license.toString());
    }
}
