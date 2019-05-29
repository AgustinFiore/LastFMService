package ayds.jj1.lastfm.service;

import ayds.jj1.lastfm.Artist;

interface ArtistInfoFormatter {
    Artist formatArtistInfo(String body, String artistName);
}