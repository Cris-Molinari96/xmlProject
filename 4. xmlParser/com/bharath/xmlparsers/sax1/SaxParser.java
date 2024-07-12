package com.bharath.xmlparsers.sax1;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxParser {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        SaxTestHandler saxTestHandler = new SaxTestHandler();

        saxParser.parse(ClassLoader.getSystemResourceAsStream("xml/ReadDocument.xml"), saxTestHandler);

        System.out.println(saxTestHandler.getReadDocument().getName());
        System.out.println(saxTestHandler.getReadDocument().getSurname());
        System.out.println(saxTestHandler.getReadDocument().getDateOfBirth());

        if(saxTestHandler.getReadDocument().getReadParagraph() != null) {
            System.out.println(saxTestHandler.getReadDocument().getReadParagraph().toString());
        }
    }


}
