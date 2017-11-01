/*
Khadija Almaskeen 
ITCS3112 Final
9May2016
*/

package src.blackjackcardgui;
/*
 *
 Game Rules:
 this blackjack game consist of betting. 
 it is carried out between one use and the 
 computer. this game relay on the following 
 card.2,3,4...10, Q,K,J,A when the game 
 start user have $20 in his account. he can
 able to bet only between $1 and $2. user
 can offer his bet in his bet box.  user box
 share out only with two cards which are 
 visible to the user.  only one card is  
 visible for the computer  and the other
 one is hide. the computer does not 
 disclose  until  it makes the its hand a 
 blackjack.
 
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
//import java.util.Scanner;
import java.io.IOException;


import java.util.*;

public class BlackJackCardGUI extends JFrame {
       
        JPanel FrameLayOut81 = new JPanel();
        JPanel FrameLayOut2 = new JPanel();
        JPanel FrameLayOut94 = new JPanel();
        JPanel FrameLayOut82 = new JPanel();
        JPanel FrameLayOut98 = new JPanel();
        JPanel FrameLayOut83 = new JPanel();
        JPanel FrameLayOut99 = new JPanel();
        JPanel FrameLayOut92 = new JPanel();
        JPanel FrameLayOut97 = new JPanel();
        JPanel FrameLayOut91 = new JPanel();
        JPanel FrameLayOut84 = new JPanel();
        JPanel FrameLayOut93 = new JPanel();
        JPanel FrameLayOut85 = new JPanel();
        JPanel FrameLayOut86 = new JPanel();
        JPanel FrameLayOut87 = new JPanel();
        JLabel LblD = new JLabel();
        JLabel FrameLayOut95 = new JLabel();
        JLabel FrameLayOut96 = new JLabel();
        JLabel[] ViewA = new JLabel[10];
        JLabel[] ViewB = new JLabel[10];
        int Temp = 0;
         int Turns = 0;
        int Check = 20;
         int Nil = 0;
        JLabel l41 = new JLabel();
        JButton ButtonA = new JButton("$1");
        JButton ButtonB = new JButton("$2");
        JLabel ButtonC = new JLabel();
        JLabel LblA = new JLabel();
        JButton ButtonD = new JButton("Stay");
        JButton ButtonE = new JButton("Hit");
        JLabel LblB = new JLabel();
        JButton ButtonF = new JButton("Next");
        //card initialization
        int[][] LastCardA = new int[50][2];
       
        int[][] Cary = new int[10][2]; // user turn
        int MumberA = 0;
        int[][] CaryB = new int[10][2]; // computer turn
        int NumberB = 0;
        int AdditionA = 0;
        int AdditionB = 0;
        // Constructor method
        BlackJackCardGUI(){
                this.setSize(500, 400);
                this.setLayout(new GridLayout(2,1));
                this.add(FrameLayOut83); this.add(FrameLayOut84);
                FrameLayOut84.setLayout(new GridLayout(5,1));
                FrameLayOut84.add(FrameLayOut81); FrameLayOut84.add(FrameLayOut82); FrameLayOut84.add(FrameLayOut85); FrameLayOut84.add(FrameLayOut86); FrameLayOut84.add(FrameLayOut87); 
                Turns = 1;
                FrameLayOut81.setLayout(new GridLayout(1,2));
                FrameLayOut81.add(FrameLayOut2); FrameLayOut81.add(FrameLayOut94);
                FrameLayOut2.add(FrameLayOut95); FrameLayOut94.add(FrameLayOut96);
                FrameLayOut2.setBorder(new LineBorder(new Color(0,0,0),2));
                FrameLayOut94.setBorder(new LineBorder(new Color(0,0,0),2));
                FrameLayOut82.add(LblD);
                FrameLayOut83.setLayout(new GridLayout(1,2));
                FrameLayOut83.add(FrameLayOut92); FrameLayOut83.add(FrameLayOut91);
                FrameLayOut92.setBorder(new LineBorder(new Color(0,0,0),2));
                FrameLayOut91.setBorder(new LineBorder(new Color(0,0,0),2));
                FrameLayOut92.setLayout(new GridLayout(1,5));
                FrameLayOut91.setLayout(new GridLayout(1,5));
                FrameLayOut85.add(l41);
                FrameLayOut85.add(ButtonA);
                FrameLayOut85.add(ButtonB);
                FrameLayOut85.add(ButtonC);
                l41.setText("Temp: ");
                FrameLayOut86.add(LblA);
                LblA.setText("Action: ");
                FrameLayOut86.add(ButtonD);
                FrameLayOut86.add(ButtonE);
                FrameLayOut87.add(LblB);
                FrameLayOut87.add(ButtonF);
                ButtonA.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { MakeScreen("ButtonA"); } } );
                ButtonB.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { MakeScreen("ButtonB"); } } );
                ButtonD.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { MakeScreen("ButtonD"); } } );
                ButtonE.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { MakeScreen("ButtonE"); } } );
                ButtonF.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { MakeScreen("ButtonF"); } } );
                // ACTIONS performed
                LblD.setText("Round "+Turns+"          "+"Action: select Temp");
                // making card visible
                Cary[MumberA] = CardFormed(LastCardA,Nil);
                LastCardA[Nil][0] = Cary[MumberA][0];
                LastCardA[Nil][1] = Cary[MumberA][1];
                Nil++;
                MumberA++;
                // card develoment one by one
                Cary[MumberA] = CardFormed(LastCardA,Nil);
                LastCardA[Nil][0] = Cary[MumberA][0];
                LastCardA[Nil][1] = Cary[MumberA][1];
                Nil++;
                MumberA++;
                CaryB[NumberB] = CardFormed(LastCardA,Nil);
                LastCardA[Nil][0] = CaryB[NumberB][0];
                LastCardA[Nil][1] = CaryB[NumberB][1];
                Nil++;
                NumberB++;
                for(int i=0; i<MumberA; i++){
                        ViewA[i] = new JLabel();
                        ViewA[i].setIcon(DisplayCardFun(Cary[i]));
                        ViewA[i].setSize(30,30);
                        FrameLayOut92.add(ViewA[i]);
                }
                for(int i=0; i<NumberB; i++){
                        ViewB[i] = new JLabel();
                        ViewB[i].setIcon(DisplayCardFun(CaryB[i]));
                        FrameLayOut91.add(ViewB[i]);
                }
                AdditionA = AdditionFun(Cary,MumberA);
                AdditionB = AdditionFun(CaryB,NumberB);
                FrameLayOut95.setText("User checking="+Check+"; sum="+AdditionA);
                FrameLayOut96.setText("Computer ="+AdditionB);
                Temp = 0;
                ButtonC.setText("Temp: $"+Temp);
                LblB.setText("Result: New Check: $   ");
                ButtonD.disable();
                ButtonE.disable();
                ButtonF.disable();
                setVisible(true);
                repaint();
        }
        
        public static void main(String[] args) throws IOException {
                BlackJackCardGUI bjc = new BlackJackCardGUI();
        }
        
        public void MakeScreen(String option){
                System.out.println("Option: "+option);
                if( option.equals("ButtonA") || option.equals("ButtonB") ){
                        LblD.setText("Round "+Turns+"          "+"Action: select stand, hit");
                        if( option.equals("ButtonA") ){
                                Temp = 1;
                        }else Temp = 2;
                        ButtonC.setText("Temp: $"+Temp);
                        ButtonA.disable();
                        ButtonB.disable();
                        ButtonD.enable();
                        ButtonE.enable();
                        ButtonF.disable();
                } else if(option.equals("ButtonE")){
                       
                        Cary[MumberA] = CardFormed(LastCardA,Nil);
                        LastCardA[Nil][0] = Cary[MumberA][0];
                        LastCardA[Nil][1] = Cary[MumberA][1];
                        Nil++;
                        MumberA++;
                        FrameLayOut92.removeAll();
                        for(int i=0; i<MumberA; i++){
                                ViewA[i] = new JLabel();
                                ViewA[i].setIcon(DisplayCardFun(Cary[i]));
                                ViewA[i].setSize(30,30);
                                FrameLayOut92.add(ViewA[i]);
                        }
                        FrameLayOut91.removeAll();
                        for(int i=0; i<NumberB; i++){
                                ViewB[i] = new JLabel();
                                ViewB[i].setIcon(DisplayCardFun(CaryB[i]));
                                FrameLayOut91.add(ViewB[i]);
                        }
                        AdditionA = AdditionFun(Cary,MumberA);
                        AdditionB = AdditionFun(CaryB,NumberB);
                        FrameLayOut95.setText("User Turn="+Check+"; sum="+AdditionA);
                        FrameLayOut96.setText("Computer Turn="+AdditionB);
                        ButtonC.setText("Temp: $"+Temp);
                        LblB.setText("Result:        => New Check: $   ");
                } else if(option.equals("ButtonD")){

                } else if(option.equals("ButtonF")){
                        
                } else System.out.println("Wrong Selection: "+option);
                repaint();
        }

        public static ImageIcon DisplayCardFun(int[] c){
                String fileString = "images/Playing_card_";
                if(c[1]==1) fileString += "heart";
                else if(c[1]==2) fileString += "diamond";
                else if(c[1]==2) fileString += "club";
                else fileString += "spade";
                fileString += "_";
                if(2<=c[0] && c[0]<=10) fileString += c[0];
                else if(c[0]==11) fileString += "J";
                else if(c[0]==12) fileString += "Q";
                else if(c[0]==13) fileString += "K";
                else fileString += "A";
                fileString += ".jpg";
                return new ImageIcon(fileString);
        }

        
        public static int AdditionFun(int[][] Cary,int MumberA){
                int sum = 0;
                for(int i=0; i<MumberA;i++){
                        if(Cary[i][0]<=10)
                                sum += Cary[i][0];
                        else sum += 10;
                }
                return sum;
        }
        
        public static int[] CardFormed(int[][] LastCardA,int Nil){
                boolean duplicate = false;
                int[] card = new int[2];
                do{
                        duplicate = false;
                        card[0] = (int) (Math.random()*13 + 2);
                        card[1] = (int) (Math.random()*4 + 1);
                    
                        for(int i=0; i<Nil;i++){
                                if(card[0]==LastCardA[i][0] && card[1]==LastCardA[i][1]) duplicate = true;
                        }
                }while(duplicate);
                return card;
        }
        public static int[] CardFormed(){
                int[] card = new int[2];
                card[0] = (int) (Math.random()*13 + 2);
                card[1] = (int) (Math.random()*4 + 1);
                return card;
        }
        public static String DisplayCardToString(int[] c){
                String card = "";
                if(2<=c[0] && c[0]<=10) 
                        card += c[0];
                else if(c[0]==11) card += "Jack";
                else if(c[0]==12) card += "Queen";
                else if(c[0]==13) card += "king";
                else if(c[0]==14) card += "Ace";
                else card += "DisplayCardToString error: card number="+c[0];
                card += " of ";
                if(c[1]==1) card += "hearts";
                else if(c[1]==2) card += "diamonds";
                else if(c[1]==2) card += "clubs";
                else card += "spades";
                return card;
        }
}