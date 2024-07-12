package com.bharath.xmlparsers.sax1;

import com.bharath.xmlparsers.dto.ReadDocument;
import com.bharath.xmlparsers.dto.ReadParagraph;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxTestHandler extends DefaultHandler {

    private ReadDocument readDocument;
    private ReadParagraph readParagraph;
    private StringBuilder stringBuilder;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Stampa di startElement --> ____ ");
        stringBuilder = new StringBuilder();
        // super.startElement(uri, localName, qName, attributes);
        System.out.println(qName);
        if(qName.equals("ReadThisDocument")){
            System.out.println("Creazione del oggetto ReadThisDocument");
            setReadDocument(new ReadDocument());
        }
        if(qName.equals("readParagraph")){
            System.out.println("Creazione del oggetto ReadThisDocument");
            setReadParagraph(new ReadParagraph());
        }
    }

// In questo metodo puoi modificare a tuo piacimento le informazioni del documento, aggiungendo o rimuovendo attributi
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);
        System.out.println("Stampa contenuto stringa --> " + s);
        if (s.length() > 0) {
            stringBuilder.append(s);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Stampa di endElement --> " + qName);
        String s = stringBuilder.toString().trim();
        System.out.println("stringBuilder.toString --> " + s);
        switch (qName) {
            case "name":
                readDocument.setName(s);
                break;
            case "surname":
                readDocument.setSurname(s);
                break;
            case "DateOfBirth":
                readDocument.setDateOfBirth(s);
                break;
            case "info1":
                readParagraph.setInfo1(s);
                break;
            case "info2":
                readParagraph.setInfo2(s);
                break;
            case "info3":
                readParagraph.setInfo3(s);
                break;
            case "info4":
                readParagraph.setInfo4(s);
                break;
            case "info5":
                readParagraph.setInfo5(s);
                break;
        }
if(readParagraph != null){
    System.out.println("ReadP diverso da null");
        if (readParagraph.getInfo1() != null
                && readParagraph.getInfo2() != null
                && readParagraph.getInfo3() != null
                && readParagraph.getInfo3() != null && readParagraph.getInfo4() != null && readParagraph.getInfo5() != null) {
            readDocument.setReadParagraph(readParagraph);
            System.out.println(readParagraph.toString());
        }
    }
    }
    public ReadDocument getReadDocument() {
        return readDocument;
    }

    public void setReadDocument(ReadDocument readDocument) {
        this.readDocument = readDocument;
    }

    public ReadParagraph getReadParagraph() {
        return readParagraph;
    }

    public void setReadParagraph(ReadParagraph readParagraph) {
        this.readParagraph = readParagraph;
    }
}
