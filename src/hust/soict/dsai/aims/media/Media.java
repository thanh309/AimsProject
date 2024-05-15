package hust.soict.dsai.aims.media;

import java.util.Objects;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    protected static int nbMedia = 0;

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbMedia++;
        this.id = nbMedia;
    }

    public Media(String title, String category) {
        this(title, category, 0f);
    }

    public Media(String title) {
        this(title, "");
    }

    public Media(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;
        Media media = (Media) o;
        return Objects.equals(getTitle(), media.getTitle());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ", ID: " + getId() +
                ", title: " + getTitle() + '\'' +
                ", category: " + getCategory() + '\'' +
                ", cost: $" + getCost();
    }
}
