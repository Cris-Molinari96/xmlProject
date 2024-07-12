package XSLTTransformer;

import Constants.PathFile;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XSLTTransformer {
    public static void main(String[] args) throws TransformerException {

      // percorsi dei file xml e xsl, e dove salvare il file.html
      final  String xmlFIlePath = PathFile.xmlFIlePath;
      final  String xslFIlePath =  PathFile.xslFIlePath;
      final  String xmlOutputPath = PathFile.xmlOutputPath;
        // Otteniamo attraverso TransformerFactory un istanza del trasformatore
        TransformerFactory transformerFactory =  TransformerFactory.newInstance();
      // Caricamento del file xsl
        StreamSource  xslt = new StreamSource(new File(xslFIlePath));
        Transformer transformer = transformerFactory.newTransformer(xslt);

        // Definire l'input XML e l'output HTML
        StreamSource xml = new StreamSource(new File(xmlFIlePath));
        StreamResult output = new StreamResult(new File(xmlOutputPath));

        // Eseguire la trasformazione
        transformer.transform(xml, output);

        System.out.println("Trasformazione completata. Output salvato in: " + xmlOutputPath);
    }
}
