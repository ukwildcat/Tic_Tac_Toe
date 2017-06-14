package tictactoe;

public class ComputerPlayer extends Player {

    public ComputerPlayer() {
        System.out.println("1");
    }
    
    public ComputerPlayer(String name, char symbol) {
        super(name, symbol);
        
    }
    
    public void move(TicTacToe board) {
        // generate a random number between 1 and 9
        // try to move there
        // repeat until successful
        
        boolean successfulMove = false;
        while (!successfulMove) {
            int move = (int) (Math.random() * 9 + 1);
            successfulMove = board.move(move, getSymbol());
        }
        
    }
    
    public String toString() {
        return "I am " + getName() + " and I am awesome";
    }
    
    public void compute() {
        System.out.println("Does not compute!");
    }
    
    public static void main(String[] args) {
       // Player temp = new ComputerPlayer("Bob", 'X');
        //System.out.println(temp.toString());
        //if (temp instanceof ComputerPlayer)
          // ((ComputerPlayer) temp).compute();
        
        TicTacToe board = new TicTacToe();
        ComputerPlayer player1 = new ComputerPlayer("HAL", 'X');
        board.display();
        player1.move(board);
        board.display();
        
    }
}