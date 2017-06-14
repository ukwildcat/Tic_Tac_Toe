/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player{
    
    
    public HumanPlayer(String name,char symbol) {
        super(name,symbol);
    }
    
    /**
     *
     * @param board
     * @return 
     */
    @Override
    public void move(TicTacToe board) {
        boolean isValid = false;
        int move = 0;
        
        while (!isValid) {
            
            System.out.print("Where do you want to move? ");
            Scanner in = new Scanner(System.in);
        
            try {
                move = in.nextInt();
            
                if (move <= 9 && move >= 1) {
                isValid = true;
               if(!board.move(move,getSymbol()))
                move(board);
                }else {
                    System.out.println("This is not a vaild input.");
                }
                
                } catch (InputMismatchException e) {
                    System.out.println("This is not a valid input.");
                }
        }
   
            
    }
}
