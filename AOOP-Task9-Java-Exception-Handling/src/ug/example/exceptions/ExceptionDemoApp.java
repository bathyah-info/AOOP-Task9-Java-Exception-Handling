package ug.example.exceptions;

public class ExceptionDemoApp {
    public static void main(String[] args) {
        DoseCalculator calculator = new DoseCalculator();

        try {
            double dose = calculator.calculateMgPerKg(70.0, 150.0);
            System.out.println("Calculated total dose: " + dose + " mg");
        } catch (InvalidDoseException e) {
            System.out.println("[CAUGHT InvalidDoseException] " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("[CAUGHT IllegalArgumentException] " + e.getMessage());
        }
    }
}
