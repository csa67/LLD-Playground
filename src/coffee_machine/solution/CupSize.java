package coffee_machine.solution;

public enum CupSize {
    SMALL(0.8),
    MEDIUM(1.0),
    LARGE(1.2);

    private final double multiplier;

    CupSize(double v) {
        multiplier = v;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
