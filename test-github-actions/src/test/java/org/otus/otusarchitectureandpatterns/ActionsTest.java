package org.otus.otusarchitectureandpatterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionsTest {
    private Actions actions;

    @BeforeEach
    void init() {
        actions = new Actions();
    }

    @Test
    void sumSuccess() {
        int sum = actions.sum(5, 10);
        assertEquals(15, sum);
    }
}