/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.model;

/**
 *
 * @author yasmineghazy
 */
public class Game {
    
    //MARK: - Properties    
    private Player [] players;
    private int winner;
    private PlayMode mode;
    private Board board;
    //MARK: - Constructor
    
    public Game(Player[] players, PlayMode mode) {
        this.players = players;
        this.winner = -1;
        this.mode = mode;
        this.board = new Board();
    }

    public Game(Player[] players, int winner, PlayMode mode, String[][] tiles) {
        this.players = players;
        this.winner = winner;
        this.mode = mode;
        this.board = new Board(tiles);
    }

    //MARK: - Methods

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void resetBoard(){
        this.board = new Board();
    }
    
    public Boolean isBoardFull(){
        return this.board.isBoardFull();
    }
    
    //IF X win return 0, IF O win return 1 else return -1
     public int getWinner(){
        Symbol winSym = this.board.getWinner(); 
        if (winSym != Symbol.none){
            this.winner = getPlayer(winSym.toString());
        }else{
            this.winner = -1;
        }
        return this.winner;
     }
     
     public int getPlayer(String s){
         for(int i = 0; i <= 1; i++) 
             if (getPlayerSymbol(i).equals(s)) return i;
         
         return -1;   
     }
     
     public void updatePlayerScore(int index){
        this.players[index].updateScore();
     }

    //Methods
    public void setMove(String symbol, int x, int y){
        this.board.setTile(symbol, x, y);
    } 
    
    public String getPlayerSymbol(int index){
       return players[index].getSymbol().toString(); 
    }
    
    public String getPlayerName(int index){
       return players[index].getUser().getUserName(); 
    }
    
    public String getPlayerScore(int index){
       return players[index].getUser().getScore().toString(); 
    }
    
}


