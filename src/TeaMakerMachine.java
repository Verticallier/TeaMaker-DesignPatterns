/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;


public class TeaMakerMachine implements Subject {
    
    private final List<Observer> observers = new ArrayList<>();
    
    private Timer currentTimer;
    private TeaLogRepository repo = new TeaLogRepository();
    
    
    private static final int DAILY_THRESHOLD = 10;


    private static final int TEA_TIME_MS = 4000;   // demo için 4 sn
    private static final int BOIL_TIME_MS = 3000;  // demo için 3 sn
    
    private State emptyState;
    private State idleState;
    private State doneState;
    private State boilingWaterState;
    private State teaState;
    
    private int cups;
    private String message = "";
    
    
    private State state;
    
    public TeaMakerMachine(){
    emptyState= new EmptyState(this);
    idleState = new IdleState(this);
    doneState= new DoneState(this);
    boilingWaterState = new BoilingWaterState(this);
    teaState= new TeaState(this);
    state = emptyState;
    
    setMessage("Machine is empty.");


    }
        // GUI
    public String getMessage() {
        return message; 
    }

    public String getDayText() {
        return LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public String getDateText() {
        return LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE); 
    }

    public boolean isEmpty() { return state == emptyState; }
    public boolean isIdle() { return state == idleState; }

    public boolean isTea() { return state == teaState; }


    public boolean isBoilingWater() { return state == boilingWaterState; }
    public boolean isDone() { return state == doneState; }

    public void setCups(int cups) {
        if (cups < 0) cups = 0;
        this.cups = cups;
    }

    
    // observer methods here 
    
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.updateMachine();
        }
    }
    
    public void setState(State state) {
        this.state = state;
        notifyObservers();
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }
    
    // delegation methods 
    
    public void filled(int cups) {
    state.filled(cups); 
    }
    public void start() { 
        state.start(); 
    }
    public void boilWater(){
        state.boilWater(); 
    }
    public void reset() { 
        stopTimerIfRunning();
        state.reset();
    }
    public void timerExpired() { 
        state.timerExpired();
    }
    
    //getters and setters 
    public State getEmptyState() { return emptyState; }
    public State getIdleState() { return idleState; }
    public State getTeaState() { return teaState; }
    public State getBoilingWaterState() { return boilingWaterState; }
    public State getDoneState() { return doneState; }
    public State getState() { return state; }
    public int getCups() { return cups; }
  
    
    // timer 
     public void startTeaTimer() {
        startTimer(TEA_TIME_MS);
    }

    public void startBoilTimer() {
        startTimer(BOIL_TIME_MS);
    }

    private void startTimer(int durationMs) {
        stopTimerIfRunning();

        currentTimer = new Timer(durationMs, e -> {
            timerExpired();
        });
        currentTimer.setRepeats(false);
        currentTimer.start();
    }

    public void stopTimerIfRunning() {
        if (currentTimer != null && currentTimer.isRunning()) {
            currentTimer.stop();
        }
    }
    
    // database
    public void logToDatabase() {
    repo.insert(cups, LocalDateTime.now());
    }

    public int getTodayTotal() {
    return repo.getDailyTotal(LocalDate.now());
    }

    public int getMonthlyTotal(int year, int month) {
        return repo.getMonthlyTotal(year, month);
    }   
    // message 
    public String buildMessage(String stateName) {
        int todayTotal = getTodayTotal();

        Message msg = new BaseMessage(stateName, LocalDate.now());

        if (todayTotal >= DAILY_THRESHOLD) {
        msg = new HealthWarningDecorator(msg, todayTotal, DAILY_THRESHOLD);
    }

       return msg.getText();
    }

}


    

