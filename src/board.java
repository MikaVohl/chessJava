import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Board implements ActionListener{
    public JFrame boardFrame;
    public JPanel boardPanel;
    public Board(){
        boardFrame = new JFrame();
        boardPanel = new JPanel();

        createBoard();
        boardFrame.add(boardPanel, BorderLayout.CENTER); // adds the panel to the frame, centers it
        boardFrame.setPreferredSize(new Dimension(1000,1000));
        boardFrame.pack();
        boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ensures the frame exits on close as opposed to hiding or ignoring
        boardFrame.setVisible(true);
    }
    private void createBoard(){
        boardPanel = new JPanel(new GridLayout(8, 8));
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                JButton square = new JButton();
                if((row + col)%2 == 0){
                    square.setBackground(Color.black);
                }
                else{
                    square.setBackground(Color.white);
                }
                square.setSize(new Dimension(80, 80));
                square.setActionCommand(row+""+col); // Set a custom action command
                square.addActionListener(this);

                // Add an image over the button
                ImageIcon imageIcon = new ImageIcon("resources/bking.png");
                Image image = imageIcon.getImage().getScaledInstance(square.getWidth(), square.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(image);
                JLabel imageLabel = new JLabel(newIcon);
                imageLabel.setBounds(0, 0, square.getWidth(), square.getHeight());
                square.add(imageLabel);

                square.setBorderPainted(false); // Removes small border around buttons
                boardPanel.add(square);

            }
        }

    }

    public void actionPerformed(ActionEvent e) {
        // Do something when the button is pressed
        System.out.println(e.getActionCommand());
    }
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        new Board();
    }
}
