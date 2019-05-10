package external.lastfm;

import external.Artist;

interface ArtistInfoFormatter {
    Artist formatArtistInfo(String body, String artistName);
}