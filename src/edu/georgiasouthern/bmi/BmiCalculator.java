package edu.georgiasouthern.bmi;

/**
 * Stateless, dependency-free utility for computing Body Mass Index (BMI) and
 * its associated {@link BmiCategory}.
 *
 * <p>BMI is defined as {@code weight (kg) / height (m)^2}. All methods are
 * pure functions and the class carries no UI or framework dependencies, so it
 * is safe to reuse anywhere on the JVM.</p>
 *
 * <pre>{@code
 * double bmi = BmiCalculator.calculate(72.0, 1.80); // 22.22
 * BmiCategory category = BmiCategory.of(bmi);        // NORMAL
 * }</pre>
 */
public final class BmiCalculator {

    private BmiCalculator() {
        // Utility class; not instantiable.
    }

    /**
     * Computes the Body Mass Index for the given weight and height.
     *
     * @param weightKg body weight in kilograms; must be finite and positive
     * @param heightM  body height in metres; must be finite and positive
     * @return the BMI, expressed in {@code kg/m^2}
     * @throws IllegalArgumentException if either argument is not a finite, positive number
     */
    public static double calculate(double weightKg, double heightM) {
        requirePositive(weightKg, "weightKg");
        requirePositive(heightM, "heightM");
        return weightKg / (heightM * heightM);
    }

    /**
     * Computes the BMI and classifies it in a single step.
     *
     * @param weightKg body weight in kilograms; must be finite and positive
     * @param heightM  body height in metres; must be finite and positive
     * @return the {@link BmiCategory} for the computed BMI
     * @throws IllegalArgumentException if either argument is not a finite, positive number
     */
    public static BmiCategory categorize(double weightKg, double heightM) {
        return BmiCategory.of(calculate(weightKg, heightM));
    }

    private static void requirePositive(double value, String name) {
        if (!Double.isFinite(value) || value <= 0.0) {
            throw new IllegalArgumentException(name + " must be a finite positive number, got " + value);
        }
    }
}
