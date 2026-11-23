package ug.example.exceptions; // Same package as InvalidDoseException and ExceptionDemoApp

public class DoseCalculator {

    // I added this so it calculates total medicine dose from weight (kg) and dose rate (mg per kg).
    // "throws InvalidDoseException" warns callers that this method might throw that custom error.
    public double calculateMgPerKg(double weightKg, double mgPerKg) throws InvalidDoseException {
        // Unchecked runtime exception: weight can't be 0 or negative
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Patient weight must be greater than 0 kg.");
        }
        // Checked custom exception: dose rate outside the safe 1 to 100 mg/kg range
        if (mgPerKg <= 0 || mgPerKg > 100) {
            throw new InvalidDoseException("Dose rate " + mgPerKg + " mg/kg is outside safe range (1-100).");
        }
        // If both checks pass, multiply weight by dose rate and return the total mg
        return weightKg * mgPerKg;
    }

    // I added this block of code which converts text inputs into numbers and divides total mg by mg per tablet
    public int splitTabletsSafely(String totalMgText, String perTabletMgText) {
        // Integer.parseInt turns text like "500" into a number; bad text throws NumberFormatException
        int totalMg = Integer.parseInt(totalMgText.trim()); // .trim() removes accidental spaces
        int perTabletMg = Integer.parseInt(perTabletMgText.trim());

        // Dividing by zero in integer math crashes with ArithmeticException unless caught
        if (perTabletMg == 0) {
            throw new ArithmeticException("Tablet strength cannot be zero.");
        }
        // Integer division returns how many whole tablets are needed
        return totalMg / perTabletMg;
    }
}