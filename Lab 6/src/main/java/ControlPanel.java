import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * Class ControlPanel for the control panel, which contains buttons Save, Load, Reset, Exit
 */
public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveButton = new JButton("Save");
    JButton loadButton = new JButton("Load");
    JButton resetButton = new JButton("Reset");
    JButton exitButton = new JButton("Exit");
    JFileChooser fileChooser = new JFileChooser();

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * Method to initialize the control panel and all the buttons
     */
    private void init() {
        setLayout(new GridLayout(1, 4));

        add(saveButton);
        add(loadButton);
        add(resetButton);
        add(exitButton);

        saveButton.addActionListener(this::save);
        loadButton.addActionListener(this::load);
        resetButton.addActionListener(this::reset);
        exitButton.addActionListener(this::exit);
    }

    /**
     * Action listener for Save button
     * @param e represents the event, in this case the click on the Save button
     */
    private void save(ActionEvent e) {
        try {
            fileChooser.setDialogTitle("Save");
            int userSelection = fileChooser.showSaveDialog(frame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                ImageIO.write(frame.canvas.image, "PNG", fileChooser.getSelectedFile());
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Action listener for Load button
     * @param e represents the event, in this case the click on the Load button
     */
    private void load(ActionEvent e) {
        try {
            fileChooser.setDialogTitle("Open");
            int userSelection = fileChooser.showSaveDialog(frame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                frame.canvas.image = ImageIO.read(fileChooser.getSelectedFile());
                frame.canvas.repaint();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Action listener for Reset button
     * @param e represents the event, in this case the click on the Reset button
     */
    private void reset(ActionEvent e) {
        frame.canvas.createOffscreenImage();
    }

    /**
     * Action listener for Exit button
     * @param e represents the event, in this case the click on the Exit button
     */
    private void exit(ActionEvent e) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
