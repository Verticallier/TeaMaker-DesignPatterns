/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class IdleState implements State {
    
    private final TeaMakerMachine machine;
    
    public IdleState(TeaMakerMachine machine){
        this.machine= machine;
    }
    
    @Override
    public void start() {
        // timer-1
        machine.setMessage("Making tea...");
        machine.setState(machine.getTeaState());
        machine.startTeaTimer(); 
    }

    @Override
    public void boilWater() {
        //timer-2
        machine.setMessage("Boiling water...");
        machine.setState(machine.getBoilingWaterState());
        machine.startBoilTimer(); 
    }

    @Override
    public void filled(int cups) {
        machine.setMessage("Already filled.");
    }

    @Override
    public void reset() {
        machine.stopTimerIfRunning();
    machine.setCups(0);
    machine.setMessage("Machine is empty.");
    machine.setState(machine.getEmptyState());
    }

    @Override
    public void timerExpired() {
        // ignore
    }
}
