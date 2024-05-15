package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book() {
        super();
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
}

