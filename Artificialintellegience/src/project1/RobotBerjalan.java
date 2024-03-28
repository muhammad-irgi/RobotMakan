package project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RobotBerjalan extends JPanel implements ActionListener {
    private Image robotImage;
    private JButton button;

    private int x = 30, y = 30; // Trash position
    private int mouthStatus = 300; // Robot's mouth open

    private int robotXPos = 20; // Initial robot position
    private int trashXPos = 20; // Initial trash position
    private int trashYPos = 130; // Initial trash position

    public RobotBerjalan() {
        button = new JButton("Run");
        button.addActionListener(this);
        add(button);

        setPreferredSize(new Dimension(400, 200)); // Set preferred panel size
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawString("Location A", 0, 20);
        g.drawString("Location B", 270, 20);

        // Draw the robot
        g.fillArc(robotXPos, 30, 100, 100, 0, mouthStatus);

        // Draw the trash as a blue rectangle
        g.setColor(Color.blue);
        g.fillRect(trashXPos, trashYPos, x, y);
        g.drawRect(trashXPos, trashYPos, x, y);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("Button 1 was pressed");
            if (robotXPos == 20) {
                moveRight();
            } else {
                moveLeft();
            }
            repaint(); // Redraw the panel after moving
        } else {
            System.out.println("Button 2 was pressed");
        }
    }

    public void moveRight() {
        mouthStatus = 300; // Robot's mouth open
        robotXPos = 220; // Move robot position to the right
    }

    public void moveLeft() {
        mouthStatus = 300; // Robot's mouth open
        robotXPos = 20; // Move robot position to the left
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Robot Vacuum Cleaner");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new RobotBerjalan());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
