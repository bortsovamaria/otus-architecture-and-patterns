package org.otus.otusarchitectureandpatterns;

public interface Rotatable {
    void setDirection(int direction);

    int getDirection();

    int getMaxDirections();

    int getAngularVelocity();
}