package ayds.lastFMService.external.lastfm;

import ayds.lastFMService.external.Artist;

interface ArtistInfoFormatter {
    Artist formatArtistInfo(String body, String artistName);
}