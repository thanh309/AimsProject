package hust.soict.dsai.aims.screen.swing_component;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.screen.StoreScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private final StoreScreen storeScreen;
    public MediaStore(Media media, StoreScreen storeScreen) {

        this.storeScreen = storeScreen;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new AddToCartListener(media));
        container.add(addToCartButton);

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new PlayListener(media));
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }

    private class AddToCartListener implements ActionListener {
        private final Media media;

        public AddToCartListener(Media media) {
            this.media = media;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            storeScreen.getCart().addMedia(media);
        }
    }

    private static class PlayListener implements ActionListener {
        private final Playable playableMedia;

        public PlayListener(Media media) {
            this.playableMedia = (Playable) media;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            this.playableMedia.play();
        }
    }
}
