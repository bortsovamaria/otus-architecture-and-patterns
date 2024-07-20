package org.otus.otusarchitectureandpatterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTest {
    private QuadraticEquation quadraticEquation;

    @BeforeEach
    void init() {
        quadraticEquation = new QuadraticEquation();
    }

    @Test
    void solveWithoutRoots() {
        double[] roots = quadraticEquation.solve(1, 0, 1);

        assertEquals(Arrays.toString(new double[]{}), Arrays.toString(roots));
    }

    @Test
    void solveWithTwoRoots() {
        double[] roots = quadraticEquation.solve(1, 0, -1);

        assertEquals(Arrays.toString(new double[]{1.0, -1.0}), Arrays.toString(roots));
    }

    @Test
    void solveWithOneRoot() {
        double[] roots = quadraticEquation.solve(1, 2, 1);

        assertEquals(Arrays.toString(new double[]{-1.0, -1.0}), Arrays.toString(roots));
    }

    @Test
    void solveWithZeroKoeff() {
        Executable execute = () -> quadraticEquation.solve(0, 2, 1);

        assertThrows(IllegalArgumentException.class, execute);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfAIsInErrorRange() {
        Executable execute = () -> quadraticEquation.solve(1e-6, 2, 1);

        assertThrows(IllegalArgumentException.class, execute);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfNaN() {
        Executable execute = () -> quadraticEquation.solve(Double.NaN, 2, 1);

        assertThrows(IllegalArgumentException.class, execute);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfPositiveInfinity() {
        Executable execute = () -> quadraticEquation.solve(Double.POSITIVE_INFINITY, 2, 1);

        assertThrows(IllegalArgumentException.class, execute);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfNegativeInfinity() {
        Executable execute = () -> quadraticEquation.solve(Double.NEGATIVE_INFINITY, 2, 1);

        assertThrows(IllegalArgumentException.class, execute);
    }
}