package algorithm.analysis.tsp.project.travelingsalesmanproblem;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.checkerframework.checker.units.qual.s;

public class TSP {
    private Integer[][] weightedGraph;

    public TSP(Integer[][] weightedGraph) {
        this.weightedGraph = weightedGraph;
    }

    private Integer[] swapEdges(Integer[] elements, int first, int second) {
        Integer[] swapped = new Integer[elements.length];
        outerElementFill(elements, swapped, first, second);
        int innerPos = first + 1;
        for (int i = second; i > first; i--) {
            swapped[innerPos++] = elements[i];
        }
        return swapped;
    }

    private void outerElementFill(Integer[] original, Integer[] outerElements, int first, int second) {
        for (int i = 0; i <= first; i++) {
            outerElements[i] = original[i];
        }
        for (int i = second; i < outerElements.length; i++) {
            outerElements[i] = original[i];
        }
    }

    public void firstImprovementLocalSearch () {
        Integer[] solution = generateSolution();
        System.out.println(Arrays.toString(solution));
        Integer newDistance = 0;
        Integer bestDistance = calculateDistanceCost(solution);
        Integer[] currentSolution = solution;

        for (int i = 0; i < currentSolution.length-2; i++) {
            for (int j = i+1; j < currentSolution.length-1; j++) {
                System.out.println("current iteration: " + i);
                Integer[] newRoute = swapEdges(currentSolution, i, j);
                newDistance = calculateDistanceCost(newRoute);
                if(newDistance< bestDistance){
                    System.out.println("new distance is: " + newDistance);
                    currentSolution = newRoute;
                    bestDistance = newDistance;
                }
            }
        }
        System.out.println("Best distance is: " + bestDistance);
        System.out.println("Best route is: " + Arrays.toString(currentSolution));

    }

    private int calculateDistanceCost(Integer[] solution) {
        int firstElement = solution[0];
        int lastElement = solution[solution.length-1];
        int cost = weightedGraph[firstElement][lastElement];
        for (int i = 0; i < solution.length - 1; i++) {
            cost += weightedGraph[solution[i]][solution[i + 1]];
        }
        return cost;
    }

    private Integer[] generateSolution(){
        Integer[] solution = new Integer[this.weightedGraph.length];
        for (int i = 0; i < solution.length; i++) {
            solution[i] = i;
        }
        List<Integer> shuffledSolution = Arrays.asList(solution);
        Collections.shuffle(shuffledSolution);
        return shuffledSolution.toArray(solution);
    }

}