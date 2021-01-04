/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author yasmineghazy
 */
public class Game implements Serializable {

    //MARK: - Properties    
    private Player[] players;
    private int winner;
    private int firstMovePlayer;
    private PlayMode mode;
    private Board board;
    private ArrayList<Move> moves;
    private Date date;

    //MARK: - Constructor
    public Game(Player[] players, PlayMode mode) {
        this.players = players;
        this.winner = -1;
        this.firstMovePlayer = 0;
        this.mode = mode;
        this.board = new Board();
        this.moves = new ArrayList<>();
        this.date = new Date();
    }

    public Game(Player[] players, int winner, int firstPlayer, PlayMode mode, String[][] tiles, ArrayList<Move> moves) {
        this.players = players;
        this.winner = winner;
        this.firstMovePlayer = firstPlayer;
        this.mode = mode;
        this.board = new Board(tiles);
        this.moves = moves;
        this.date = new Date();
    }

    public Game(Player[] players, int i, PlayMode playMode, String[][] tiles, ArrayList<Move> moves) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //MARK: - Methods
    public PlayMode getMode() {
        return mode;
    }

    public Board getBoard() {
        return board;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public int getFirstMovePlayer() {
        return firstMovePlayer;
    }

    public void setFirstMovePlayer(int firstMovePlayer) {
        this.firstMovePlayer = firstMovePlayer;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setMode(PlayMode mode) {
        this.mode = mode;
    }

    public void resetBoard() {
        this.board = new Board();
    }

    public Boolean isBoardFull() {
        return this.board.isBoardFull();
    }

    //IF X win return 0, IF O win return 1 else return -1
    public int checkWinner() {
        Symbol winSym = this.board.getWinner();
        if (winSym != Symbol.none) {
            this.winner = getPlayer(winSym.toString());
        } else {
            this.winner = -1;
        }
        return this.winner;
    }

    public int getWinner() {
        return winner;
    }

    public int getPlayer(String s) {
        for (int i = 0; i <= 1; i++) {
            if (getPlayerSymbol(i).equals(s)) {
                return i;
            }
        }

        return -1;
    }

    public void updatePlayerScore(int index) {
        this.players[index].updateScore();
    }

    //Methods
    public void setMove(String symbol, int x, int y) {
        this.board.setTile(symbol, x, y);
        moves.add(new Move(x, y));
    }

    public String getPlayerSymbol(int index) {
        return players[index].getSymbol().toString();
    }

    public String getPlayerName(int index) {
        return players[index].getUser().getUserName();
    }

    public String getPlayerScore(int index) {
        return players[index].getUser().getScore().toString();
    }

    public Date getDate() {
        return date;
    }

    public User getUser(int index) {
        return players[index].getUser();
    }

    public void resetScore() {
        players[0].getUser().setScore(0);
        players[1].getUser().setScore(0);
    }

}
