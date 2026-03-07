package org.example;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    public T value;
    public List<Vertex<T>> adjacentVertices;

    public Vertex(T value) {
        this.value = value;
        this.adjacentVertices = new ArrayList<>();
    }

    public void addAdjacentVertex(Vertex<T> vertex){
        if (adjacentVertices.contains(vertex)) return;
        adjacentVertices.add(vertex);
        vertex.addAdjacentVertex(this);
    }
}
