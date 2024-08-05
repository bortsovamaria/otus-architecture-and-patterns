package org.otus.otusarchitectureandpatterns;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class MoveTest {
    @Mock
    private static Movable movable;

    @Spy
    private static Move move;

    @BeforeAll
    public static void beforeAll() {
        movable = Mockito.mock(Movable.class);
        move = new Move(movable);
    }

    @BeforeEach
    public void beforeEach() {
        Mockito.reset(movable);
    }


    @Test
    public void testMove() {
        when(movable.getPosition()).thenReturn(new Vector(12, 5));
        when(movable.getVelocity()).thenReturn(new Vector(-7, 3));

        move.execute();

        Mockito.verify(movable).setPosition(eq(new Vector(5, 8)));
    }

    @Test
    public void testFailGetPosition() {
        when(movable.getPosition()).thenThrow(new RuntimeException("Can't get position"));
        when(movable.getVelocity()).thenReturn(new Vector(-7, 3));

        assertThrows(RuntimeException.class, move::execute);
    }

    @Test
    public void testFailGetVelocity() {
        when(movable.getPosition()).thenReturn(new Vector(12, 5));
        when(movable.getVelocity()).thenThrow(new RuntimeException("Can't get velocity"));

        assertThrows(RuntimeException.class, move::execute);
    }

    @Test
    public void testFailSetPosition() {
        when(movable.getPosition()).thenReturn(new Vector(12, 5));
        when(movable.getVelocity()).thenReturn(new Vector(-7, 3));

        doThrow(new RuntimeException("Can't set new position")).when(movable).setPosition(Mockito.any());

        assertThrows(RuntimeException.class, move::execute);
    }
}