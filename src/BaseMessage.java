
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class BaseMessage implements Message{
    
    private final String stateName;
    private final LocalDate date;

    public BaseMessage(String stateName, LocalDate date) {
        this.stateName = stateName;
        this.date = date;
    }

    @Override
    public String getText() {
        String dayName = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        return dayName + ", " + date + ", " + stateName;
    }
    
}
