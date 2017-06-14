package tictactoe;


public abstract class Player {
    
    private String name;
    private char symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    
    public Player() {
        System.out.println("2");
    }
    
    public Player(String name, char symbol) {
       
        this.name = name;
        this.symbol = symbol;
    }
    
    @Override
    public String toString() {
        return "I am " + name;
    }
    
    /**
     *
     * @param board
     * @return
     */
    public abstract void move(TicTacToe board);
}