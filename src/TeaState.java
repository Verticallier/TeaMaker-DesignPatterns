/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class TeaState implements State {

    private final TeaMakerMachine machine;

    public TeaState(TeaMakerMachine machine) {
        this.machine = machine;
    }

    @Override
    public void filled(int cups) {
        machine.setMessage("Machine is busy. Please wait.");
    }

    @Override
    public void start() {
        machine.setMessage("Already making tea...");
    }

    @Override
    public void boilWater() {
        machine.setMessage("Machine is busy. Please wait.");
    }

    @Override
    public void reset() {
    machine.setCups(0);
    machine.setState(machine.getEmptyState());
    machine.setMessage("Machine is empty.");
    }

    @Override
    public void timerExpired() {
    machine.logToDatabase();

    machine.setMessage(machine.buildMessage("DONE"));
    machine.setState(machine.getDoneState());
    }
}
