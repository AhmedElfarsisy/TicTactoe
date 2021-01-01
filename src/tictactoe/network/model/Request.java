/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.network.model;

import java.io.Serializable;

/**
 *
 * @author A.Elfarsisy
 */

public class Request<T> implements Serializable{
    private RequestType type;
    private T data;
    
    public Request(RequestType type,T data){
        this.type=type;
        this.data=data;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;    
    }

    
    
}
