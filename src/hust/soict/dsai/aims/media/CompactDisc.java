package hust.soict.dsai.aims.media;

import java.util.List;

public class CompactDisc extends Disc implements Playable {
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

    @Override
    public void play() {
        System.out.println("=================================================");
        System.out.println("Playing CD: " + getTitle());
        System.out.println("Total length: " + getLength());
        System.out.println("=================================================");
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        StringBuilder tracksInfo = new StringBuilder();
        for (Track track : tracks) {
            tracksInfo.append("  - ").append(track.toString()).append('\n');
        }
        return super.toString() +
                ", artist: " + getArtist() +
                ", tracks:\n" + tracksInfo;
    }
}

