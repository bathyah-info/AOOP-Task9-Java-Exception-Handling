package ug.example.exceptions;

public class ExceptionDemoApp {

    // This is the main entry point whereJava starts running the program here
    public static void main(String[] args) {
        // Create a DoseCalculator object so we can call its calculation methods
        DoseCalculator calculator = new DoseCalculator();

        // I added this as test 1 which intentionally pass an unsafe dose rate (150.0) so we see fallback recovery in action
        double invalidResult = runDoseCheck(calculator, 70.0, 150.0, 250.0);
        System.out.println("Effective dose (after invalid input): " + invalidResult + " mg\n");

        // This is test 2 meant to pass valid inputs (70 kg and 5 mg/kg -> 350.0 mg) so we see normal success
        double validResult = runDoseCheck(calculator, 70.0, 5.0, 250.0);
        System.out.println("Effective dose (after valid input): " + validResult + " mg\n");

        // "try" wraps risky code that might throw an exception
        try {
            // Try parsing "500" and "250" and dividing them (returns 2 tablets)
            int tablets = calculator.splitTabletsSafely("500", "250");
            System.out.println("Tablets required: " + tablets);
        } catch (NumberFormatException | ArithmeticException e) {
            // Multi-catch: handles either bad number text OR division-by-zero in one place
            System.out.println("[MULTI-CATCH] Math/parse failure: " + e.getMessage());
        } finally {
            // "finally" always runs at the end—whether the try succeeded or a catch ran
            System.out.println("[FINALLY] Tablet split check finished.");
        }
    }

    // Helper method that tries to calculate a dose, and falls back to a safe default if it fails
    private static double runDoseCheck(DoseCalculator calculator,
                                       double weightKg,
                                       double mgPerKg,
                                       double fallbackDoseMg) {
        try {
            // I added this to attempt the real calculation first
            return calculator.calculateMgPerKg(weightKg, mgPerKg);
        } catch (InvalidDoseException | IllegalArgumentException e) {
            // If validation fails, print why, and return the safe backup dose instead of crashing
            System.out.println("[FALLBACK] Using default dose (" + fallbackDoseMg
                    + " mg) due to error: " + e.getMessage());
            return fallbackDoseMg;
        }
    }
}
