package ug.example.exceptions;

public class ExceptionDemoApp {
    public static void main(String[] args) {
        DoseCalculator calculator = new DoseCalculator();

        double invalidResult = runDoseCheck(calculator, 70.0, 150.0, 250.0);
        System.out.println("Effective dose (after invalid input): " + invalidResult + " mg\n");

        double validResult = runDoseCheck(calculator, 70.0, 5.0, 250.0);
        System.out.println("Effective dose (after valid input): " + validResult + " mg\n");

        try {
            int tablets = calculator.splitTabletsSafely("500", "250");
            System.out.println("Tablets required: " + tablets);
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println("[MULTI-CATCH] Math/parse failure: " + e.getMessage());
        } finally {
            System.out.println("[FINALLY] Tablet split check finished.");
        }
    }

    private static double runDoseCheck(DoseCalculator calculator,
                                       double weightKg,
                                       double mgPerKg,
                                       double fallbackDoseMg) {
        try {
            return calculator.calculateMgPerKg(weightKg, mgPerKg);
        } catch (InvalidDoseException | IllegalArgumentException e) {
            System.out.println("[FALLBACK] Using default dose (" + fallbackDoseMg
                    + " mg) due to error: " + e.getMessage());
            return fallbackDoseMg;
        }
    }
}
