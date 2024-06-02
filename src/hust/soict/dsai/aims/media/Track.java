package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import java.util.Objects;

public class Track implements Playable {
    private final String title;
    private final int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if (getLength() > 0) {
            System.out.println("Playing track: " + getTitle());
            System.out.println("Track length: " + getLength());
        } else throw new PlayerException("Track", false);
    }

    @Override
    public void playGUI() throws PlayerException {
        if (getLength() > 0) {
            playGUI(title, length);
        } else throw new PlayerException("Track", true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        Track track = (Track) o;
        return length == track.length && Objects.equals(title, track.title);
    }

    @Override
    public String toString() {
        return getTitle() + ", length: " + getLength();
    }
}
