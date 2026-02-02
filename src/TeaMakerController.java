/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class TeaMakerController {

    private final TeaMakerMachine model;
    private final TeaMaker view;

    public TeaMakerController(TeaMakerMachine model, TeaMaker view) {
        this.model = model;
        this.view = view;
    }

    public void onFilled() {
        String s = view.getCupsText().trim();
        if (s.isEmpty()) {
            view.showError("Please enter number of cups.");
            return;
        }

        try {
            int cups = Integer.parseInt(s);
            if (cups <= 0) {
                view.showError("Cups must be > 0.");
                return;
            }
            model.filled(cups);
            view.clearCupsText(); 
        } catch (NumberFormatException ex) {
            view.showError("Invalid number.");
        }
    }

    public void onStart() {
        model.start();
    }

    public void onBoilWater() {
        model.boilWater();
    }

    public void onReset() {
        model.reset();
        view.clearCupsText();
    }
    
    public void onTotalCups() {
    java.time.LocalDate now = java.time.LocalDate.now();
    int total = model.getMonthlyTotal(now.getYear(), now.getMonthValue());
    view.setTotalCupsText(String.valueOf(total));
}

}

