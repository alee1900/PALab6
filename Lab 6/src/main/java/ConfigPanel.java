import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

/**
 * Class ConfigPanel for the configuration panel
 * Can introduce parameters like number of sides, color
 */
@Getter
public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label1;
    JLabel label2;
    JSpinner sidesField;
    JComboBox colorCombo;
    Color colorSelected;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * Method to initialize the configuration panel and everything it contains
     */
    private void init() {
        label1 = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(3);

        label2 = new JLabel("Color:");

        Random rand = new Random();

        int r = rand.nextInt(128) + 128;
        int g = rand.nextInt(128) + 128;
        int b = rand.nextInt(128) + 128;

        Color color = new Color(r, g, b);
        Color[] colors = {color, Color.BLACK};

        colorCombo = new JComboBox(colors);

        colorCombo.setSelectedIndex(0);
        colorCombo.addActionListener(this::selectColor);

        add(label1);
        add(sidesField);
        add(label2);
        add(colorCombo);
    }

    /**
     * Action listener for choosing color
     * @param e represents the event, in this case the choosing of a color
     */
    private void selectColor(ActionEvent e) {
        colorSelected = (Color) colorCombo.getSelectedItem();
    }
}
