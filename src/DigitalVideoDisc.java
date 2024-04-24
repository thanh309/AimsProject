public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0;
    private final int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

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
        this.id = nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format(
                "DVD - %s - %s - %s - %d: $%f",
                title,
                category,
                director,
                length,
                cost
        );
    }

    public boolean isMatch(String title) {
        return title.equals(this.title);
    }
}
