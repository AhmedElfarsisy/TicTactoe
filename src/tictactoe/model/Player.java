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
public class Player {

    //MARK: - Properties    
    private User user;
    private Symbol symbol;
    
    //MARK: - Constructor 
    public Player(String name, Symbol symbol) {
        this.user = new User(name, "");
        this.symbol = symbol;
    }
    
    public Player(User user, Symbol symbol) {
        this.user = user;
        this.symbol = symbol;
    }

    //MARK: - Methods
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
    
    public void updateScore(){
        int score = this.user.getScore();
        this.user.setScore(++score);
    }

}

