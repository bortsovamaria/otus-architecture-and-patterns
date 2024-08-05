package org.otus.otusarchitectureandpatterns;

public class Rotate {
    private final Rotatable rotatable;

    public Rotate(Rotatable rotatable) {
        this.rotatable = rotatable;
    }

    public void execute() {
        rotatable.setDirection((rotatable.getDirection() + rotatable.getAngularVelocity()) % rotatable.getMaxDirections());
    }
}