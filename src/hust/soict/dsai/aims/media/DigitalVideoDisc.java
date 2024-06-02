package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public boolean isMatch(String title) {
        return title.equals(getTitle());
    }

    @Override
    public void play() throws PlayerException {
        if (getLength() > 0) {
            System.out.println("Playing DVD: " + getTitle());
            System.out.println("DVD length: " + getLength());
        } else throw new PlayerException("DVD", false);
    }

    @Override
    public void playGUI() throws PlayerException {
        if (getLength() > 0) {
            Playable.super.playGUI(getTitle(), getLength());
        } else throw new PlayerException("DVD", true);
    }
}
