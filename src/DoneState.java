/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class DoneState implements State {

    private final TeaMakerMachine machine;

    public DoneState(TeaMakerMachine machine) {
        this.machine = machine;
    }

    @Override
    public void filled(int cups) {
        machine.setMessage("Done. Press RESET to empty the machine.");
    }

    @Override
    public void start() {
        machine.setMessage("Done. Press RESET to empty the machine.");
    }

    @Override
    public void boilWater() {
        machine.setMessage("Done. Press RESET to empty the machine.");
    }

    @Override
    public void reset() {
    machine.stopTimerIfRunning();
    machine.setCups(0);
    machine.setState(machine.getEmptyState());
    machine.setMessage("Machine is empty.");
    }

    @Override
    public void timerExpired() {
        // DONE state'te timer expire olmaz, ignore
    }
}
