package io.github.tyronedarby.bmi;

/**
 * World Health Organization weight-status categories derived from a
 * Body Mass Index (BMI) value.
 *
 * <p>The boundaries are half-open intervals, so every finite BMI maps to
 * exactly one category with no gaps:</p>
 *
 * <ul>
 *   <li>{@link #UNDERWEIGHT} &mdash; {@code bmi < 18.5}</li>
 *   <li>{@link #NORMAL} &mdash; {@code 18.5 <= bmi < 25.0}</li>
 *   <li>{@link #OVERWEIGHT} &mdash; {@code 25.0 <= bmi < 30.0}</li>
 *   <li>{@link #OBESE} &mdash; {@code bmi >= 30.0}</li>
 * </ul>
 */
public enum BmiCategory {

    UNDERWEIGHT("Underweight"),
    NORMAL("Normal"),
    OVERWEIGHT("Overweight"),
    OBESE("Obese");

    private final String label;

    BmiCategory(String label) {
        this.label = label;
    }

    /**
     * Returns a human-readable label for this category, e.g. {@code "Normal"}.
     *
     * @return the display label
     */
    public String label() {
        return label;
    }

    /**
     * Classifies a BMI value into its weight-status category.
     *
     * @param bmi a body mass index value
     * @return the matching {@link BmiCategory}
     * @throws IllegalArgumentException if {@code bmi} is not a finite, positive number
     */
    public static BmiCategory of(double bmi) {
        if (!Double.isFinite(bmi) || bmi <= 0.0) {
            throw new IllegalArgumentException("bmi must be a finite positive number, got " + bmi);
        }
        if (bmi < 18.5) {
            return UNDERWEIGHT;
        }
        if (bmi < 25.0) {
            return NORMAL;
        }
        if (bmi < 30.0) {
            return OVERWEIGHT;
        }
        return OBESE;
    }
}
