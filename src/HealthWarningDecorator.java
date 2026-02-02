/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class HealthWarningDecorator extends MessageDecorator {
    
    private final int todayTotal;
    private final int threshold;

    public HealthWarningDecorator(Message inner, int todayTotal, int threshold) {
        super(inner);
        this.todayTotal = todayTotal;
        this.threshold = threshold;
    }

   
    public String getText() {
        return inner.getText()
    + "\nWarning: The number of total cups today has reached to " + todayTotal + ".";

    }
    
}
