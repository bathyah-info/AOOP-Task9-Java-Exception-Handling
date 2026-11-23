package ug.example.exceptions;

public class DoseCalculator {
    public double calculateMgPerKg(double weightKg, double mgPerKg) throws InvalidDoseException {
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Patient weight must be greater than 0 kg.");
        }
        if (mgPerKg <= 0 || mgPerKg > 100) {
            throw new InvalidDoseException("Dose rate " + mgPerKg + " mg/kg is outside safe range (1-100).");
        }
        return weightKg * mgPerKg;
    }

    public int splitTabletsSafely(String totalMgText, String perTabletMgText) {
        int totalMg = Integer.parseInt(totalMgText.trim());
        int perTabletMg = Integer.parseInt(perTabletMgText.trim());
        if (perTabletMg == 0) {
            throw new ArithmeticException("Tablet strength cannot be zero.");
        }
        return totalMg / perTabletMg;
    }
}