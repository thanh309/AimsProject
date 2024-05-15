package hust.soict.dsai.aims.media;

import java.util.List;

public class CompactDisc extends Disc {
    private String artist;
    private List<Track> tracks;

    public String getArtist() {
        return artist;
    }

    public CompactDisc(String artist) {
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track is already in list");
            return;
        }
        tracks.add(track);
        System.out.println("Track added");
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("Track removed");
            return;
        }
        System.out.println("Track is not in list");
    }

    @Override
    public int getLength() {
        int result = 0;
        for (Track track : tracks) {
            result += track.getLength();
        }
        return result;
    }
}

