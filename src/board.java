import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Board implements ActionListener{
    public boolean picked = false;
    public String firstPiece = "";
    public String secondPiece = "";
    public JFrame boardFrame;
    public JPanel boardPanel;
    public JButton[][] buttons;
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
        ImageIcon imageIcon = null;
        boardPanel = new JPanel(new GridLayout(8, 8));
        buttons = new JButton[8][8];
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                JButton square = new JButton();
                if((row + col)%2 == 0){
                    square.setBackground(Color.white);
                }
                else{
                    square.setBackground(Color.gray);
                }
                square.setSize(new Dimension(80, 80));
                square.setActionCommand(row+""+col); // Set a custom action command
                square.addActionListener(this);
                if(row == 0 || row == 1 || row == 6 || row == 7){
                    if(row == 1){ // If second black row
                        imageIcon = new ImageIcon("resources/bpawn.png");
                    }
                    else if(row == 6) { // If second white row
                        imageIcon = new ImageIcon("resources/wpawn.png");
                    }
                    else if(row == 0){ // If first black row
                        if(col == 0 || col == 7){
                            imageIcon = new ImageIcon("resources/brook.png");
                        }
                        else if(col == 1 || col == 6){
                            imageIcon = new ImageIcon("resources/bknight.png");
                        }
                        else if(col == 2 || col == 5){
                            imageIcon = new ImageIcon("resources/bbishop.png");
                        }
                        else if(col == 3){
                            imageIcon = new ImageIcon("resources/bqueen.png");
                        }
                        else if(col == 4){
                            imageIcon = new ImageIcon("resources/bking.png");
                        }
                    }
                    else if(row == 7){ // If first white row
                        if(col == 0 || col == 7){
                            imageIcon = new ImageIcon("resources/wrook.png");
                        }
                        else if(col == 1 || col == 6) {
                            imageIcon = new ImageIcon("resources/wknight.png");
                        }
                        else if(col == 2 || col == 5){
                            imageIcon = new ImageIcon("resources/wbishop.png");
                        }
                        else if(col == 3){
                            imageIcon = new ImageIcon("resources/wqueen.png");
                        }
                        else if(col == 4){
                            imageIcon = new ImageIcon("resources/wking.svg");
                        }
                    }
                    Image image = imageIcon.getImage().getScaledInstance(square.getWidth(), square.getHeight(), Image.SCALE_SMOOTH); // creates image
                    ImageIcon newIcon = new ImageIcon(image); // uses image to create an icon
                    JLabel imageLabel = new JLabel(newIcon); // sets imageLabel to the icon
                    imageLabel.setBounds(0, 0, square.getWidth(), square.getHeight());
                    square.add(imageLabel); // adds the imageLabel to the square
                }


                square.setBorderPainted(false); // Removes small border around buttons
                boardPanel.add(square);
                buttons[row][col] = square;
            }
        }

    }

    public void actionPerformed(ActionEvent e) {
        // Do something when the button is pressed
//        System.out.println(e.getActionCommand());
        if(!picked){ // First click
            picked = true;
            firstPiece = e.getActionCommand();
        }
        else{ // Second click
            picked = false;
            secondPiece = e.getActionCommand();
            // Trying to access the button at a certain coordinate
//            System.out.println("First Piece: "+firstPiece);
//            System.out.println("Second Piece: "+secondPiece);
            int first1 = Character.getNumericValue(firstPiece.charAt(0));
            int first2 = Character.getNumericValue(firstPiece.charAt(1));
            int second1 = Character.getNumericValue(secondPiece.charAt(0));
            int second2 = Character.getNumericValue(secondPiece.charAt(1));
            JButton firstIcon = buttons[first1][first2];
            JButton secondIcon = buttons[second1][second2];

            Icon icon = firstIcon.getIcon();

            secondIcon.setIcon(icon);

            // Remove the icon from the first button
//            firstIcon.setIcon(null);
            firstIcon.removeAll();
            firstIcon.repaint();
        }
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
