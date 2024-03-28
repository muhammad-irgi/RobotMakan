package project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RobotDoAll extends JPanel implements ActionListener {
    private JButton button1;

    private int x = 30, y = 30; // Trash position
    private int mouthStatus = 300; // Robot's mouth open

    private int robotXPos = 20; // Initial robot position
    private int trashXPos = 20; // Initial trash position
    private int trashYPos = 120; // Initial trash position

    public RobotDoAll() {
    	setLayout(new BorderLayout());

    	// Create a panel to hold the buttons and set its layout to FlowLayout
    	JPanel buttonPanel = new JPanel(new FlowLayout());

    	button1 = new JButton("Clean Up");
    	button1.addActionListener(this);
    	buttonPanel.add(button1); // Add button1 to the button panel
    	// Add the button panel to the south of the main panel
    	add(buttonPanel, BorderLayout.SOUTH);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawString("Location A", 0, 20);
        g.drawString("Location B", 270, 20);

        // Draw the robot
        g.fillArc(robotXPos, 30, 100, 100, 270, mouthStatus);

        // Draw the trash as a blue rectangle
        g.setColor(Color.blue);
        g.fillRect(trashXPos, trashYPos, x, y);
        g.drawRect(trashXPos, trashYPos, x, y);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            System.out.println("Move Robot button was pressed");
            if (trashXPos == 20) {
            	if(robotXPos != 20) {
            		moveLeft();
            	}
                vacuum();
            } else {
            	if(robotXPos == 20) {
            		moveRight();
            	}
                vacuum();
            }
            repaint();
        }
         // Redraw the panel after actions
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
    }

    public void moveRight() {
        mouthStatus = 300; // Robot's mouth open
        robotXPos = 270; // Move robot position to the right
    }

    public void moveLeft() {
        mouthStatus = 300; // Robot's mouth open
        robotXPos = 20; // Move robot position to the left
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Robot Do All");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 400); // Set the size as per your requirement

                frame.getContentPane().add(new RobotDoAll());

                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
