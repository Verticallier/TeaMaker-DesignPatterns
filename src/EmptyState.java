/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class EmptyState implements State {
    private final TeaMakerMachine machine;
    
    public EmptyState(TeaMakerMachine machine){
        this.machine= machine;
    }
    
    @Override
    public void filled(int cups) {
        machine.setCups(cups);
        machine.setMessage("Machine filled. Ready.");
        machine.setState(machine.getIdleState());
    }

    @Override
    public void start() {
        machine.setMessage("Warning: Machine is empty. Fill first.");
    }

    @Override
    public void boilWater() {
        machine.setMessage("Warning: Machine is empty. Fill first.");
    }

    @Override
    public void reset() {
    machine.setCups(0);
    machine.setMessage("Machine is empty.");
    machine.setState(machine.getEmptyState());
    }

    @Override
    public void timerExpired() {
        // ignore
    }
    
    
    
}
