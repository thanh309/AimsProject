package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        this(title, "None", -1);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this(title, category, "None", cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, director, -1, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
        setTitle(title);
        setCategory(category);
        setCost(cost);
        setDirector(director);
        setLength(length);
    }

    @Override
    public String toString() {
        return String.format(
                "DVD - %s - %s - %s - %d: $%f",
                getTitle(),
                getCategory(),
                getDirector(),
                getLength(),
                getCost()
        );
    }

    public boolean isMatch(String title) {
        return title.equals(getTitle());
    }
}
