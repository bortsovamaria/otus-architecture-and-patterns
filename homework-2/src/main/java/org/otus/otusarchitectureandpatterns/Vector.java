package org.otus.otusarchitectureandpatterns;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Vector {
    int[] coordinates;

    public Vector(int... coordinates) {
        this.coordinates = coordinates;
    }

    public static Vector sum(Vector v1, Vector v2) {
        int[] resultCoordinates = new int[v1.coordinates.length];
        for (int i = 0; i < resultCoordinates.length; i++)
            resultCoordinates[i] = v1.coordinates[i] + v2.coordinates[i];
        return new Vector(resultCoordinates);
    }
}