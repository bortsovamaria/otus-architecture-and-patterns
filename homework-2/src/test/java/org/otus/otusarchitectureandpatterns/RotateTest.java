package org.otus.otusarchitectureandpatterns;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;

public class RotateTest {
    private static Rotatable rotatable;

    private static Rotate rotate;

    @BeforeAll
    public static void beforeAll() {
        rotatable = Mockito.mock(Rotatable.class);
        rotate = new Rotate(rotatable);
    }

    @BeforeEach
    public void beforeEach() {
        Mockito.reset(rotatable);
    }

    @Test
    public void testRotate() {
        when(rotatable.getMaxDirections()).thenReturn(360);
        when(rotatable.getDirection()).thenReturn(300);
        when(rotatable.getAngularVelocity()).thenReturn(70);

        rotate.execute();

        Mockito.verify(rotatable).setDirection(eq(10));
    }

    @Test
    public void testZeroVelocity() {
        when(rotatable.getMaxDirections()).thenReturn(360);
        when(rotatable.getDirection()).thenReturn(100);
        when(rotatable.getAngularVelocity()).thenReturn(0);

        rotate.execute();

        Mockito.verify(rotatable).setDirection(eq(100));
    }

    @Test
    public void testFailMaxDirections() {
        when(rotatable.getMaxDirections()).thenReturn(0);
        when(rotatable.getDirection()).thenReturn(300);
        when(rotatable.getAngularVelocity()).thenReturn(70);

        assertThrows(RuntimeException.class, rotate::execute);
    }

    @Test
    public void testFailGetDirection() {
        when(rotatable.getMaxDirections()).thenReturn(0);
        when(rotatable.getDirection()).thenThrow(new RuntimeException("Can't get direction"));
        when(rotatable.getAngularVelocity()).thenReturn(70);

        assertThrows(RuntimeException.class, rotate::execute);
    }

}