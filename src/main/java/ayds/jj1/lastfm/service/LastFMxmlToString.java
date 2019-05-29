package ayds.lastFMService.external.lastfm;

import org.w3c.dom.Document;

public interface LastFMxmlToString {

    void setDocument(Document document);
    String extractBio();
    String extractImageUrl();
}
