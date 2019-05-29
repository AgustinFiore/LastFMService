package ayds.jj1.lastfm.service;

import ayds.jj1.lastfm.Artist;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

class ArtistInfoFormatterImp implements ArtistInfoFormatter {

    private LastFMxmlToString lastFMxmlToString;

    public ArtistInfoFormatterImp(LastFMxmlToString lastFMxmlToString) {
        this.lastFMxmlToString = lastFMxmlToString;

    }

    public Artist formatArtistInfo(String body, String artistName) {
        String imageUrl;
        String bio;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            lastFMxmlToString.setDocument(db.parse(new InputSource(new StringReader(body))));
            bio = lastFMxmlToString.extractBio();
            imageUrl = lastFMxmlToString.extractImageUrl();
            if(bio!=null && imageUrl!=null){
                Artist artist = new Artist();
                artist.setName(artistName);
                artist.setBio(armarBio(bio));
                artist.setImageUrl(imageUrl);
                return artist;
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return null;
    }

    private String armarBio(String bio){
        bio = planeTextForDB(bio);
        return bio;
    }

    private String planeTextForDB(String text) {
        StringBuilder builder = new StringBuilder();
        String textWithoutQuotationMarks = text.replace("'", "`");
        builder.append(textWithoutQuotationMarks);
        return builder.toString();
    }
}

