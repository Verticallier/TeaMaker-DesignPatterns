
import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        TeaMakerMachine m = new TeaMakerMachine();

       
        m.filled(1);

      
        m.start();

        
        Thread.sleep(5000);

     
        System.out.println("MESSAGE:");
        System.out.println(m.getMessage());
    }
    
}
