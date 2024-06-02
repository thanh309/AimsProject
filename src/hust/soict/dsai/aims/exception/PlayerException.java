package hust.soict.dsai.aims.exception;

import javax.swing.JOptionPane;

public class PlayerException extends Exception {

    public PlayerException(String message) {
        super(message);
    }

    public PlayerException(String mediaType, boolean useGUI) throws PlayerException {
        String message = "ERROR: " + mediaType + " length is non-positive!";
        if (useGUI) {
            JOptionPane.showMessageDialog(null, message, "Player Error", JOptionPane.ERROR_MESSAGE);
        } else {
            throw new PlayerException(message);
        }
    }
}
