XML parsing uses three main techniques: DOM, SAX and StAX

DOM reads all the document in memory so it allows for random access
SAX reads the document as a stream, using events to process elements
StAX is a compromise of DOM and SAX, no ramdom access
XPATH is used for locating a set of nodes in a given XML document

XML es case-sensitive

Un xml se puede validar usando un DTD (Document Type Definition) o un XSD (XML Schema Definition). En el ejemplo de DOM se dice cómo usar validación.
W3C recomienda XSD porque es más completo (XSD también se le llama W3C XML Schema)







