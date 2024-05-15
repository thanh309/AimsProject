package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private String director;
    private int length;

    public Disc() {
        super();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
