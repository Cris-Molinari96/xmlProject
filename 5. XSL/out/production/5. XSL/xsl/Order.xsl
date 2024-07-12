<?xml version="1.0" encoding="UTF-8" ?>
<!-- xsl:stylesheet è l'elemento radice di un foglio di stile-->

<!--xmlns:xsl è fondamentale perché
in questo modo posso utilizzare un foglio di stile legato ad una struttura xsd per la trasformazione di un file xml-->
<xsl:stylesheet version="1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <!-- template principale
 definisce un template, ovvero un set di regole per trasformare una parte del documento XML o l'intero documento.-->
    <!--    match prende il nome dell'elemento che vogliamo sia considerato per la conversione-->
    <xsl:template match="/">
        <html>
            <body>
                <h2>Order details:</h2>
                <h3>Customer: <xsl:value-of select="Order/customerName"/></h3>
                <!-- Itera su ogni elemento "item" -->
                <xsl:for-each select="Order/item">
                    <div>
                        <p>Item ID: <xsl:value-of select="itemId"/></p>
                        <p>Item Name: <xsl:value-of select="itemName"/></p>
                        <p>Price: <xsl:value-of select="price"/></p>
                        <p>Quantity: <xsl:value-of select="quantity"/></p>
                    </div>
                    <hr/>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>