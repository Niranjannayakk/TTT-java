import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Gui extends JFrame implements ActionListener{

Random turn = new Random();
JFrame frame;
JPanel p1;
JLabel ttt;
JPanel buttons;
JButton[] boxxs = new JButton[9];
int firstturn; 
Boolean player1_turn;
boolean play = true;



    public Gui(){

    //frame
    frame=new JFrame();
    this.setSize(500, 500);
    this.setLayout(null);
    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.getContentPane().setBackground(Color.WHITE); 
    this.setVisible(true);
   

    //label
    ttt=new JLabel();
    ttt.setText("tic tac toa");
    ttt.setForeground(Color.green);
    ttt.setFont(new Font("forte",Font.BOLD,100));
    ttt.setHorizontalTextPosition(JLabel.CENTER);
    ttt.setVerticalTextPosition(JLabel.CENTER);
    
    
    //panel
    p1 = new JPanel();
    p1.setBounds(0,0,500,100);
    p1.setBackground(Color.BLACK);
    p1.add(ttt );
    this.add(p1 , BorderLayout.NORTH);

    buttons = new JPanel();
    buttons.setBounds(0,100,500,360);
    buttons.setBackground(Color.white);
    buttons.setLayout(new GridLayout(3,3));
    this.add(buttons);

   

    //buttons
    for (int i = 0; i < 9; i++) {
    boxxs[i] = new JButton();
    boxxs[i].setFont(new Font("chiller", Font.BOLD, 60));
    boxxs[i].setFocusable(false);
    buttons.add(boxxs[i]);
    boxxs[i].addActionListener(this);
    }
     
    FirstTurn();//after gui is set ,this method call whose turn is fast
 }


    @Override
    public void actionPerformed(ActionEvent e) {

       
       for (int i = 0; i < 9; i++){// cheak all 9 buttons/boxs
       if ( e.getSource()== boxxs[i]){//get which one
        if(player1_turn == true){
            if(boxxs[i].getText().equals("")){
                boxxs[i].setText("X");
                player1_turn=false;//change turn to player 2
                ttt.setText("O turn");
                CheakCondition();//call the method ,see if any of our bocchizilion if condition fulfilled,if yes then it send 
                // xwins or ywins arguments value to xwin and ywin methods parameters                
            }
        }
        else{
        if(boxxs[i].getText().equals("")){
                boxxs[i].setText("O");
                player1_turn=true;
                ttt.setText("X turn");
                CheakCondition();
                }
             }     
            }
        }
    }      

    public void FirstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(  turn.nextInt(2) == 0){
           player1_turn =true;
            ttt.setText("X turn");
        } 
        else{
             player1_turn =false;
            ttt.setText("O turn ");
        }
    }

    public void CheakCondition(){
 
    // X wins - Rows
    if (boxxs[0].getText().equals("X") && 
        boxxs[1].getText().equals("X") && 
        boxxs[2].getText().equals("X")) {
        xWins(0, 1, 2);
        }
     if (boxxs[3].getText().equals("X") && 
        boxxs[4].getText().equals("X") && 
        boxxs[5].getText().equals("X")) {
        xWins(3, 4, 5);
        }
      if (boxxs[6].getText().equals("X") && 
        boxxs[7].getText().equals("X") && 
        boxxs[8].getText().equals("X")) {
        xWins(6, 7, 8);
        }

    // X wins - Columns
     if (boxxs[0].getText().equals("X") && 
        boxxs[3].getText().equals("X") && 
        boxxs[6].getText().equals("X")) {
        xWins(0, 3, 6);
        }
     if (boxxs[1].getText().equals("X") && 
        boxxs[4].getText().equals("X") && 
        boxxs[7].getText().equals("X")) {
        xWins(1, 4, 7);
        }
     if (boxxs[2].getText().equals("X") && 
        boxxs[5].getText().equals("X") && 
        boxxs[8].getText().equals("X")) {
        xWins(2, 5, 8);
        }

    // X wins - Diagonals
     if (boxxs[0].getText().equals("X") && 
        boxxs[4].getText().equals("X") && 
        boxxs[8].getText().equals("X")) {
        xWins(0, 4, 8);
        }
     if (boxxs[2].getText().equals("X") &&  
        boxxs[4].getText().equals("X") && 
        boxxs[6].getText().equals("X")) {
        xWins(2, 4, 6);
        }

    // O wins - Rows
     if (boxxs[0].getText().equals("O") &&  
        boxxs[1].getText().equals("O") && 
        boxxs[2].getText().equals("O")) {
        oWins(0, 1, 2);
        }
     if (boxxs[3].getText().equals("O") && 
        boxxs[4].getText().equals("O") && 
        boxxs[5].getText().equals("O")) {
        oWins(3, 4, 5);
        }
     if (boxxs[6].getText().equals("O") && 
        boxxs[7].getText().equals("O") && 
        boxxs[8].getText().equals("O")) {
        oWins(6, 7, 8);
        }

    // O wins - Columns
     if (boxxs[0].getText().equals("O") && 
        boxxs[3].getText().equals("O") && 
        boxxs[6].getText().equals("O")) {
        oWins(0, 3, 6);
        }
     if (boxxs[1].getText().equals("O") && 
        boxxs[4].getText().equals("O") && 
        boxxs[7].getText().equals("O")) {
        oWins(1, 4, 7);
        }
     if (boxxs[2].getText().equals("O") && 
        boxxs[5].getText().equals("O") && 
        boxxs[8].getText().equals("O")) {
        oWins(2, 5, 8);
        }

    // O wins - Diagonals
     if (boxxs[0].getText().equals("O") && 
        boxxs[4].getText().equals("O") && 
        boxxs[8].getText().equals("O")) {
        oWins(0, 4, 8);
        }
     if (boxxs[2].getText().equals("O") && 
        boxxs[4].getText().equals("O") && 
        boxxs[6].getText().equals("O")) {
        oWins(2, 4, 6);
        }
         
  } 
 
    public void xWins(int a, int b ,int c){//take boxxs num make it green ,then disable all boxxs and shoes who wins
        boxxs[a].setBackground(Color.GREEN);
        boxxs[b].setBackground(Color.GREEN);
        boxxs[c].setBackground(Color.GREEN);
        ttt.setText("X wins");
        for (int i = 0; i < 9; i++){
        boxxs[i].setEnabled(false);
        }    
    }

    public void oWins(int a,int b, int c){
        boxxs[a].setBackground(Color.GREEN);
        boxxs[b].setBackground(Color.GREEN);
        boxxs[c].setBackground(Color.GREEN);
        ttt.setText("O wins");
        for (int i = 0; i < 9; i++){
        boxxs[i].setEnabled(false);
        } 
    } 

 
}
