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
        } finally {
            System.out.println("[FINALLY] Dose calculation attempt logged.\n");
        }

        try {
            int tablets = calculator.splitTabletsSafely("500", "0");
            System.out.println("Tablets required: " + tablets);
        } catch (NumberFormatException e) {
            System.out.println("[CAUGHT NumberFormatException] Invalid numeric input: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("[CAUGHT ArithmeticException] " + e.getMessage());
        } finally {
            System.out.println("[FINALLY] Tablet split check finished.\n");
        }
    }
}
