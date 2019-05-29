package ayds.jj1.lastfm.service;

import ayds.jj1.lastfm.ExternalService;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class LastFMModule {

    private static LastFMModule instance;

    private ExternalService externalService;

    private LastFMModule() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ws.audioscrobbler.com/2.0/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        externalService = new LastFMService(
                retrofit.create(LastFMAPI.class),
                new ArtistInfoFormatterImp(new LastFMxmlToStringImp())
        );
    }

    public static LastFMModule getInstance() {
        if (instance == null) {
            instance = new LastFMModule();
        }
        return instance;
    }

    public ExternalService getExternalService(){ return externalService; }
}
