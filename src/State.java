/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public interface State {
    
    void filled(int cups);
    void start();
    void boilWater();
    void reset();
    void timerExpired();
    
}
