package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private final String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(String artist) {
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String director, float cost, String artist, List<Track> tracks) {
        super(title, category, director, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String title, String category, String director, float cost, String artist) {
        super(title, category, director, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String artist) {
        super(title);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
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
    public void play() throws PlayerException {
        if (getLength() > 0) {
            System.out.println("=================================================");
            System.out.println("Playing CD: " + getTitle());
            System.out.println("Total length: " + getLength());
            System.out.println("=================================================");
            for (Track track : tracks) {
                track.play();
            }
        } else {
            throw new PlayerException("CD", false);
        }
    }

    @Override
    public void playGUI() throws PlayerException {
        if (getLength() > 0) {
            for (Track track : tracks) {
                if (track.getLength() > 0) {
                    playGUI(getTitle() + " - Track: " + track.getTitle(), track.getLength());
                } else throw new PlayerException("Track", true);
                try {
                    Thread.sleep(track.getLength() * 1000L);
                } catch (Exception ignored) {
                }
            }
        } else throw new PlayerException("CD", true);
    }


    // will lock up your app tho lol - I'm too lazy to implement this correctly
    @Override
    public String toString() {
        StringBuilder tracksInfo = new StringBuilder();
        for (Track track : tracks) {
            tracksInfo.append("  - ").append(track.toString()).append('\n');
        }
        return super.toString() +
                ", artist: " + getArtist() +
                ", tracks:\n" + tracksInfo.toString().replaceAll("\n$", "");
    }
}

