package ayds.jj1.lastfm;

import ayds.jj1.lastfm.service.LastFMModule;

public class ExternalModule {

    private static ExternalModule instance;

    private ExternalModule() {
    }

    public static ExternalModule getInstance() {
        if (instance == null) {
            instance = new ExternalModule();
        }
        return instance;
    }

    public ExternalService getExternalService() {
        return LastFMModule.getInstance().getExternalService();
    }

}

