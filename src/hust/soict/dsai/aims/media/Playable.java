package hust.soict.dsai.aims.media;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface Playable {
    void play();

    default void playGUI(String title, int length) {
        JDialog dialog = new JDialog();
        dialog.setTitle("Media Player");
        dialog.setSize(300, 150);
        dialog.setLayout(new BorderLayout());
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JLabel mediaLabel = new JLabel("Now playing: " + title, JLabel.CENTER);
        dialog.add(mediaLabel, BorderLayout.NORTH);
        dialog.add(new Container(), BorderLayout.CENTER);

        JProgressBar progressBar = new JProgressBar(0, length);
        progressBar.setValue(0);
        progressBar.setPreferredSize(new Dimension(250, 20));
        dialog.add(progressBar, BorderLayout.SOUTH);

        Timer timer = new Timer(1000, new ActionListener() {
            int timePassed = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                timePassed++;
                progressBar.setValue(timePassed);
                if (timePassed >= length) {
                    ((Timer) e.getSource()).stop();
                    dialog.dispose();
                }
            }
        });
        timer.start();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    void playGUI();
}
