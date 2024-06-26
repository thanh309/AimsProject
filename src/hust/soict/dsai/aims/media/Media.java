package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.utils.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.utils.MediaComparatorByTitleCost;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            new MediaComparatorByCostTitle();
    protected static int nbMedia = 0;
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbMedia++;
        this.id = nbMedia;
    }

    public Media() {
    }

    public int getId() {
        return id;
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

    public float getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        try {
            if (this == o) {
                return true;
            }
            if (o == null) {
                throw new NullPointerException();
            }
            Media media = (Media) o;
            return Objects.equals(media.getTitle(), this.getTitle());
        } catch (NullPointerException | ClassCastException ex) {
            return false;
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ", ID: " + getId() +
                ", title: " + getTitle() +
                ", category: " + getCategory() +
                ", cost: $" + getCost();
    }
}
