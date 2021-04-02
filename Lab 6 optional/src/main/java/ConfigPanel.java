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
    JLabel label3;
    JSpinner sidesField;
    JComboBox colorCombo;
    Color colorSelected;
    JComboBox shapeCombo;
    String shapeSelected;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * Method to initialize the configuration panel and everything it contains
     */
    private void init() {
        label1 = new JLabel("Number of sides (for polygons):");
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

        label3 = new JLabel("Shape:");

        String[] shapes = {"Polygon", "Circle", "Star"};
        shapeCombo = new JComboBox(shapes);

        shapeCombo.setSelectedIndex(0);
        shapeCombo.addActionListener(this::selectShape);

        add(label1);
        add(sidesField);
        add(label2);
        add(colorCombo);
        add(label3);
        add(shapeCombo);
    }

    /**
     * Action listener for choosing color
     *
     * @param e represents the event, in this case the choosing of a color
     */
    private void selectColor(ActionEvent e) {
        colorSelected = (Color) colorCombo.getSelectedItem();
    }

    private void selectShape(ActionEvent e) {
        shapeSelected = (String) shapeCombo.getSelectedItem();
    }
}
