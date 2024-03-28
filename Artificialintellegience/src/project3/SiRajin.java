package project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SiRajin extends JPanel implements ActionListener {
    private JButton cleanButton;
    private JButton addTrashAButton;
    private JButton addTrashBButton;

    private int robotX = 20; // Initial robot position
    private int trashAX = 20; // Initial trash A position
    private int trashBX = 270; // Initial trash B position
    private int trashY = 120; // Initial trash Y position
    private int sizeA = 30; // Initial trash A size
    private int sizeB = 30; // Initial trash B size

    
    public SiRajin() {
        setLayout(new BorderLayout());

        // Create buttons and add action listeners
        cleanButton = createButton("Clean Up", this);
        addTrashAButton = createButton("Add Trash on A", this);
        addTrashBButton = createButton("Add Trash on B", this);

        // Add buttons to button panel
        JPanel buttonPanel = createButtonPanel(cleanButton, addTrashAButton, addTrashBButton);

        // Add button panel to main panel
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }

    private JPanel createButtonPanel(JButton... buttons) {
        JPanel buttonPanel = new JPanel(new FlowLayout());
        for (JButton button : buttons) {
            buttonPanel.add(button);
        }
        return buttonPanel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTrash(g, trashAX, trashY, sizeA);
        drawTrash(g, trashBX, trashY, sizeB);
        drawRobot(g, robotX);
    }

    private void drawTrash(Graphics g, int x, int y,int size) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, size, size); // Size of Trash
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    private void drawRobot(Graphics g, int x) {
    	g.drawString("Lokasi A", 20, 10);
    	g.drawString("Lokasi B", 270, 10);
    	g.drawLine(250, 0, 250, 400);
    	
        g.setColor(Color.RED);
        g.fillArc(x, 30, 100, 100, 270, 360); // Robot with mouth open
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == cleanButton) {
            System.out.println("Cleaning again");
            if (robotX == 20) {
            	clean();
            	robotX = 270;
                clean();
            } else {
            	clean();
            	robotX = 20;
                clean();
            }
    	}
    	
    	if (e.getSource() == addTrashAButton) {
            System.out.println("creating trash at A");
            addTrashToLocation('A');
    	}
    	
    	if (e.getSource() == addTrashBButton) {
            System.out.println("creating trash at B");
            addTrashToLocation('B');
    	}
    	
    	repaint();
    	
    } 

    private void clean() {
        if (robotX == 20) {
            sizeA = 0;
        } else {
            sizeB = 0;
        }
    }

    private void addTrashToLocation(char location) {
        if (location == 'A') {
            trashAX = 20;
            sizeA = 30;
        } else if (location == 'B') {
            trashBX = 270;
            sizeB = 30;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Robot Rajin");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new SiRajin());
            frame.setSize(500, 400);
            frame.setVisible(true);
        });
    }
}
