package hust.soict.dsai.aims.utils;

import hust.soict.dsai.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    @Override
    public int compare(Media m1, Media m2) {
        return Comparator
                .comparing((Media media) -> media.getTitle().toLowerCase())
                .thenComparing(media -> -media.getCost())
                .compare(m1, m2);
    }

}

