package org.example;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph {

    public static void bfs(Vertex<String> startingVertex) {
        Queue<Vertex<String>> queue = new ArrayDeque<>();
        queue.offer(startingVertex);
        Map<String, Boolean> visitedVertices = new HashMap<>();
        visitedVertices.put(startingVertex.value, true);

        while (!queue.isEmpty()) {
            Vertex<String> currentVertex = queue.poll();

            IO.println("Vertex value --> " + currentVertex.value);

            currentVertex.adjacentVertices.forEach(vertex -> {
                if (!visitedVertices.containsKey(vertex.value)) {
                    visitedVertices.put(vertex.value, true);
                    queue.offer(vertex);
                }
            });
        }
    }

    public static String bfsSearch(Vertex<String> startingVertex, String value) {
        Queue<Vertex<String>> queue = new ArrayDeque<>();
        queue.offer(startingVertex);
        Map<String, Boolean> visitedVertices = new HashMap<>();
        visitedVertices.put(startingVertex.value, true);

        while (!queue.isEmpty()) {
            Vertex<String> currentVertex = queue.poll();

            if (currentVertex.value.equals(value)) {
                return value;
            }

            currentVertex.adjacentVertices.forEach(vertex -> {
                if (!visitedVertices.containsKey(vertex.value)) {
                    visitedVertices.put(vertex.value, true);
                    queue.offer(vertex);
                }
            });
        }

        return null;
    }

    public static String shortestPath(Vertex<String> startingVertex, Vertex<String> destiny) {
        Queue<Vertex<String>> queue = new ArrayDeque<>();
        queue.offer(startingVertex);
        Map<String, Boolean> visitedVertices = new HashMap<>();
        Map<String, String> parentPath = new HashMap<>();
        visitedVertices.put(startingVertex.value, true);

        while (!queue.isEmpty()) {
            Vertex<String> currentVertex = queue.poll();

            if (destiny.equals(currentVertex)) return buildParentPath(parentPath, currentVertex.value);

            currentVertex.adjacentVertices.forEach(vertex -> {
                if (!visitedVertices.containsKey(vertex.value)) {
                    visitedVertices.put(vertex.value, true);
                    parentPath.put(vertex.value, currentVertex.value);
                    queue.offer(vertex);
                }
            });
        }

        return null;
    }

    private static String buildParentPath(Map<String, String> parentPath, String value) {
        StringBuilder builder = new StringBuilder();
        builder.append(value);
        String origin = value;
        while (parentPath.containsKey(origin))  {
            origin = parentPath.get(origin);
            builder.insert(0, origin + " ---> ");
        }

        return builder.toString();
    }
}
