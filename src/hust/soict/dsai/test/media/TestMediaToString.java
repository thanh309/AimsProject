package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.*;

import java.util.ArrayList;
import java.util.List;

public class TestMediaToString {
    public static void main(String[] args) {
        List<Media> mediaList = new ArrayList<>();

        CompactDisc cd =
                new CompactDisc("Queen Best Songs", "Music", "None", 60, "Queen");

        cd.addTrack(new Track("Bohemian Rhapsody", 540));
        cd.addTrack(new Track("Another One Bites the Dust", 330));
        cd.addTrack(new Track("Killer Queen", 300));
        cd.addTrack(new Track("We Will Rock You", 200));
        cd.addTrack(new Track("Don't Stop Me Now", 350));

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);

        Book book = new Book("Good Omens", "Novel", 15.99f);
        book.addAuthor("Terry Pratchett");
        book.addAuthor("Neil Gaiman");

        mediaList.add(cd);
        mediaList.add(dvd);
        mediaList.add(book);

        System.out.println();
        for (Media media : mediaList) {
            System.out.println(media);
            System.out.println();
        }
    }
}

