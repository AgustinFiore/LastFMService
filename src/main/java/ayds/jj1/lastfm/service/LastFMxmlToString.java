package ayds.jj1.lastfm.service;

import org.w3c.dom.Document;

public interface LastFMxmlToString {

    void setDocument(Document document);
    String extractBio();
    String extractImageUrl();
}
