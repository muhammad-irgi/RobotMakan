package project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RobotVacuum extends JFrame implements ActionListener {
    private JButton button;
    private int x = 30, y = 30; // Position of trash
    private int mouthStatus = 300; // Robot's mouth open

    public RobotVacuum() {
        setTitle("Robot Vacuum Cleaner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        button = new JButton("Run");
        button.addActionListener(this);
        add(button, BorderLayout.SOUTH);
        
        setSize(400, 400); // Set window size
        setVisible(true); // Display the window
    }

    public void paint(Graphics g) {
        super.paint(g);

        // Draw the robot with open mouth
        g.fillArc(100, 50, 100, 100, 0, mouthStatus);

        // Draw trash as a blue square
        g.setColor(Color.blue);
        g.fillRect(200, 120, x, y);
        g.drawRect(200, 120, x, y);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("Button was pressed");
            vacuum();
        }
    }

    public void vacuum() {
        if (x == 0 && y == 0) {
            mouthStatus = 300; // Robot's mouth open
            x = 30;
            y = 30;
        } else {
            x = 0; // Trash position cleaned
            y = 0; // Trash position cleaned
            mouthStatus = 360; // Robot's mouth closed
        }
        repaint(); // Redraw the screen
    }

    public static void main(String[] args) {
        // Run the GUI application on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RobotVacuum(); // Create and display the GUI
            }
        });
    }
}
