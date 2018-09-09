/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_andreamendoza;

/**
 *
 * @author andre
 */
public class Exceptions extends Exception{
private String Message; 

    public Exceptions() {
    }

    public Exceptions(String Message) {
        this.Message = Message;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    @Override
    public String toString() {
        return Message;
    }


    
}
