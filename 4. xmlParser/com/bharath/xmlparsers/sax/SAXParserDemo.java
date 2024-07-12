package com.bharath.xmlparsers.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
/* Il saxParser è responsabile di leggere il documento e genera eventi per ogni elemento che incontra.
      L'handler cattura questi eventi e li gestisce*/
public class SAXParserDemo {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Otteniamo l'istanza di un parser di tipo SAX
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        /* Otteniamo il SAX richiamando il costruttore,
            sarà lui il responsabile di analizzare il documento come accade proseguendo nel codice
        */
        SAXParser parser = parserFactory.newSAXParser();

        /* Gestore SAX estende DefaultHandler per processare il documento xml e parsare specifici elementi  e utilizza
        l'interfaccia ContentHandler
        Questa classe viene usata per leggere il documento */
        SAXHandler handler = new SAXHandler();

        parser.parse(ClassLoader.getSystemResourceAsStream("xml/DriversLicense.xml"), handler);
        System.out.println(handler.getDriversLicense().getFirstName());
        System.out.println(handler.getDriversLicense().getLastName());
        System.out.println(handler.getDriversLicense().getNumber());
    }
}
