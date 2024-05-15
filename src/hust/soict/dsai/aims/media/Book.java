package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book() {
        super();
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(String title, String category, float cost, List<String> authorList) {
        super(title, category, cost);
        authors.addAll(authorList);
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            return;
        }
        authors.add(authorName);
    }

    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }

    @Override
    public String toString() {
        StringBuilder authorsInfo = new StringBuilder();
        for (String author : authors) {
            authorsInfo.append(author).append(", ");
        }
        return super.toString() +
                ", authors: [" + authorsInfo.toString().trim().replaceAll(",$", "") + "]";
    }
}

