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

public class Board{
    
    //MARK: - Properties
    private String [][] tiles;
    int size = 3;
    
    //MARK: - Constructor
   public Board() {
        this.tiles = new String[3][3];
    }

    public Board(String[][] board) {
        this.tiles = board;
    }
    
    //MARK: - Setters and Getters

    public void setTiles(String[][] tiles) {
        this.tiles = tiles;
    }
    
    public void setTile(String symbol, int x, int y) {
        this.tiles[x][y] = symbol;
    }
    
    
    //MARK: - Methods
    public Boolean isBoardFull(){
        Boolean isBoardFull = true;
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                 if(tiles[row][col] == null){ isBoardFull = false; break; }
            }
        }
        return isBoardFull;
    }
    
    //IF X win return 0, IF O win retur 1
     public Symbol getWinner(){
        Symbol winner = Symbol.none;
        if(isWinner("X")){ winner = Symbol.X;}
        if(isWinner("O")){winner = Symbol.O;}
        return winner;
    }
     
    private Boolean isWinner(String symbol){
        
        Boolean isWinner = false;
        int mainDiag = 0, antiDiag = 0;
        
        for(int row = 0; row < size; row++){
            
            int nCol = 0, nRow = 0;
            
            for(int col = 0; col < size; col++){
                
                //Check Columns
                if(isEqual(row,col,symbol)){ nCol++; }   
                 
                //Check Rows
                if(isEqual(col,row,symbol)){ nRow++;  }  
            }
            
            //Check Main Diagonal
            if(isEqual(row,row,symbol)){ mainDiag++;  } 
                 
            //Check Anti Diagonal
            if(isEqual(row,size - row - 1,symbol)){ antiDiag++;  } 
            
            //Check Winning
            if(nCol == 3 || nRow == 3 || mainDiag == 3 || antiDiag == 3){ isWinner = true; break; }
        }
        
        return isWinner;
    }
    
    
    private Boolean isEqual(int row, int col,String symbol){
        return (tiles[row][col] != null) && (tiles[row][col].equals(symbol));
    }
   
}