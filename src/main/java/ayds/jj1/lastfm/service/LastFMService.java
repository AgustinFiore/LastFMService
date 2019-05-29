package ayds.jj1.lastfm.service;

import ayds.jj1.lastfm.Artist;
import ayds.jj1.lastfm.ExternalService;
import retrofit2.Response;
import java.io.IOException;

class LastFMService implements ExternalService {

    private LastFMAPI lastFMAPI;
    private ArtistInfoFormatter artistInfoFormatter;

    LastFMService(LastFMAPI lastFMAPI, ArtistInfoFormatter artistInfoFormatter){
        this.artistInfoFormatter=artistInfoFormatter;
        this.lastFMAPI = lastFMAPI;
    }

    public Artist getArtistInfo(String artistName){
        Artist artist = null;
        try {
            Response<String> callResponse = lastFMAPI.getArtistInfo(artistName).execute();
            artist = artistInfoFormatter.formatArtistInfo(callResponse.body(), artistName);
        }
        catch(IOException e){e.getMessage();}

        return artist;

    }


}
