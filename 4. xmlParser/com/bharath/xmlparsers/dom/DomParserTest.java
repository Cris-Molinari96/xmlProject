package com.bharath.xmlparsers.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.bharath.xmlparsers.dto.ReadDocument;
import com.bharath.xmlparsers.dto.ReadParagraph;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

public class DomParserTest {

    /* L'obiettivo è leggere il file è settare le classi ReadDocument e ReadParagraph, ma come puoi notare
     * durante l'iterazione dei nodi puoi aggiungere, rimuovere o modificare il contenuto,
     * sarà argomento per un nuovoTest  */

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        // Otteniamo l'istanza, questa funge da fabbrica per creare i parser e poterli successivamente configurare (come la validazione del file)
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        /* L'oggetto che effettivamente viene utilizzato per parsare i file xml è --> DocumentBuilder
         Quindi rispetto a quanto scritto prima qui stiamo creando il nostro parser */
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();

        /* Con .parse viene convertito il contenuto dell'xml quindi una sequenza di caratteri o byte in qualcosa di manipolabile, in questo caso un albero DOM */
        /* Quello che facciamo è convertire dei dati in un formato, in una sequenza manipolabile
          In questo momento gli stiamo indicando il percorso del file ma può essere ottenuto in diversi modi,
          parse legge il flusso di dati che gli passiamo in ingresso, se supera le regole sintattiche costruisce un albero DOM
          Ogni elemento del documento XML diventa un nodo nell'albero ACCESSIBILE.
          Document rappresenta il nostro documento xml il quale può essere accessibile ovunque
          parse = analizzatore, diamo in pasto un percorso rispettivamente alla poszione del file da analizzare da cui verrà il documento */
        Document document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream("xml/ReadDocument.xml"));
        ReadDocument readDocument = new ReadDocument();

        /* Ho due possibilità se ho più attributi con lo stesso nome, posso salvarli nella lista e iterarla
        1. NodeList nameList = document.getElementsByTagName("name");
        /* Puoi iterare la lista che contiene tutti i nodi che hai ricercato per il TagName,
         * Salvarli in Node e come accedi ai singoli elementi ?? --> con item(number)
         * */

        /* ! per il prossimo progetto
        Puoi manipolare come ti pare il contenuto dei nodeList,
        cambiare gli attributi del file, inserire del testo, o rimuoverlo
      //  for (int i = 0; i < nodeList.getLength(); i++) {
            //Node stringName = nodeList.item(i);
        //}

        2. oppure accedervi direttamente a NodeList nameList = document.getElementsByTagName("name").item(index);
        NodeList rappresenta una collezione di nodi, solitamente ottenuti come risultato di una ricerca attraverso il documento.
         * NodeList è un elenco di elementi che corrispondono a specifici criteri di ricerca, usato per cercare attributi nel xml
         * Infatti con il metodo getElementByTagName stiamo filtrando tra gli attributi ossia i nodi che sono stati creati nell'albero */

        Node name = document.getElementsByTagName("name").item(0);
        System.out.println("testNode cosa stampa ? --> " + name);
        System.out.println("stringTest cosa stampa? -->  " + name.getTextContent());
        readDocument.setName(name.getTextContent());

        /*Ancora un miglioramento quando hai un singolo attributo con quella nomenclatura accedi direttametne al contenuto */
        String surname = document.getElementsByTagName("surname").item(0).getTextContent();
        System.out.println("testNode cosa stampa ? --> " + surname);
        System.out.println("stringTest cosa stampa? -->  " + surname);
        readDocument.setSurname(surname);

        /* Accesso ad attributi i quali hanno altri attributi/figli */
        ReadParagraph r = null;
        NodeList nodeList = document.getElementsByTagName("readParagraph");
        if (nodeList.getLength() > 0) {
            r = setReadParagraph(nodeList);
            readDocument.setReadParagraph(r);
        } else {
            System.out.println("Lista vuota");
        }


        System.out.println("__________");
        System.out.println(readDocument.getName());
        System.out.println(readDocument.getSurname());
        System.out.println("__________");
        System.out.println(readDocument.getReadParagraph().getInfo1());
        System.out.println(readDocument.getReadParagraph().getInfo2());
        System.out.println(readDocument.getReadParagraph().getInfo3());
        System.out.println(readDocument.getReadParagraph().getInfo4());
        System.out.println(readDocument.getReadParagraph().getInfo5());
    }

    /* ! Il metodo accetta una nodeList, ossia una lista contente tutti gli attributi secondo il tagName che avviene sopra "readParagraph"
    compresi i suoi figli.
   *  Gli passiamo la lista contente readParagraph attributo */
    public static ReadParagraph setReadParagraph(NodeList nodeList) {
        ReadParagraph readParagraph = new ReadParagraph();
        //  accediamo al primo elemento della lista readParagraph
        Node node = nodeList.item(0);
        // Ottengo i figli/ attributi dentro in readParagraph
        NodeList childNodes = node.getChildNodes();
        // Itero sui figli settando l'oggetto
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);

            switch (item.getNodeName()) {
                case "info1":
                    readParagraph.setInfo1(item.getTextContent());
                    break;
                case "info2":
                    readParagraph.setInfo2(item.getTextContent());
                    break;
                case "info3":
                    readParagraph.setInfo3(item.getTextContent());
                    break;
                case "info4":
                    readParagraph.setInfo4(item.getTextContent());
                    break;
                case "info5":
                    readParagraph.setInfo5(item.getTextContent());
                    break;
            }
        }
        System.out.println(readParagraph.toString());
        return readParagraph;
    }
}

/*Recap finale :
* Siamo partiti dal ottenere un istanza di DocumentBuilderFactory
la quale ci serve per poter creare il nostro parser
* Chi fa la parse del documento è DocumentBuilder al quale gli passiamo un flusso in input e restituisce l'alberatura dell'intero file,
per questo motivo accessibile e manipolabile in qualsiasi punto
* Ottenuta l'alberatura, procediamo a accedere agli attributi del documento, arrivati a questo punto possiamo fare qualsiasi cosa
come aggiungere attributi, rimuoverli, modificarli.
Quando detto lo facciamo con NodeList filtrando per il  documento per il nomeTag/nomeAttributo, ritorna una nodeList la quale può
essere iterata e possiamo accedere al contenuto dell'attributo, che come sappiamo è un oggetto contente tag e informazioni.
Non è finita qui perchè un Oggetto può avere altri Oggetti al suo interno, questi sono i suoi figli per cui possiamo accedere anche a questi.
* */
