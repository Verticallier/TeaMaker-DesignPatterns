/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public abstract class MessageDecorator implements Message {
    
    protected final Message inner;

    public MessageDecorator(Message inner) {
        this.inner = inner;
    }
    
}
