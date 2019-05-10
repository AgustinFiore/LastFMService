package external.lastfm;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class LastFMxmlToStringImp implements LastFMxmlToString {
    private Document document;

    LastFMxmlToStringImp(){}

    public void setDocument(Document document){
        this.document = document;
    }

    public String extractBio(){
        NodeList nodes = document.getDocumentElement().getElementsByTagName("content");
        String bio = nodes.item(0).getTextContent().replace("\\n", "\n");
        if(bio.equals(""))
            return null;
        return bio;
    }

    public String extractImageUrl(){
        NodeList images = document.getDocumentElement().getElementsByTagName("image");
        for (int i = 0; i < images.getLength(); i++) {
            Node image = images.item(i);
            NamedNodeMap atts = image.getAttributes();
            Node size = atts.getNamedItem("size");
            if (size.getTextContent().equals("large")) {
                return  image.getTextContent();
            }
        }
        return null;
    }
}
