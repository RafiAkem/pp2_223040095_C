// * This code was generated with love by Window Builder VS Code extension. * //

import javax.swing.*;
import java.awt.*;


public class GUI {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Window builder!");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();

    // Fill the layout with placeholders
    for (int row = 0; row < 20; row++) {
        for (int col = 0; col < 15; col++) {
            constraints.gridx = col;
            constraints.gridy = row;
            constraints.weightx = 1.0;
            constraints.weighty = 1.0;
            constraints.fill = GridBagConstraints.BOTH;

            Component filler = Box.createRigidArea(new Dimension(0, 0));
            panel.add(filler, constraints);
        }
    }

    constraints.weightx = 0;
    constraints.weighty = 0;
    constraints.fill = GridBagConstraints.NONE;
    constraints.anchor = GridBagConstraints.NORTHWEST;

    
    JButton button_0 = new JButton("Button");
    button_0.setPreferredSize(new Dimension(53, 27));
    
    constraints.gridx = -3;
    constraints.gridy = 14;
    constraints.gridwidth = 2;
    constraints.gridheight = 2;
    panel.add(button_0, constraints);
    
    JTextArea text_area_0 = new JTextArea(3, 12);
    text_area_0.setPreferredSize(new Dimension(105, 52));
    constraints.gridx = -3;
    constraints.gridy = 11;
    constraints.gridwidth = 4;
    constraints.gridheight = 4;
    panel.add(text_area_0, constraints);
    
    JLabel label_0 = new JLabel("Nama");
    constraints.gridx = -3;
    constraints.gridy = 10;
    constraints.gridwidth = 2;
    constraints.gridheight = 2;
    panel.add(label_0, constraints);
    
    JSlider slider_0 = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
    slider_0.setPreferredSize(new Dimension(145, 26));
    constraints.gridx = -3;
    constraints.gridy = 13;
    constraints.gridwidth = 5;
    constraints.gridheight = 5;
    panel.add(slider_0, constraints);
    
    frame.add(panel);
    frame.setVisible(true);
  }
}
    