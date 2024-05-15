package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private String director;
    private int length;

    public Disc() {
        super();
    }

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        setDirector(director);
        setLength(length);
    }

    public Disc(String title, String category, String director, float cost) {
        this(title, category, director, -1, cost);
    }

    public Disc(String title, String category, float cost) {
        this(title, category, "None", cost);
    }

    public Disc(String title) {
        this(title, "None", -1);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", director: " + getDirector() +
                ", length: " + getLength();
    }
}
