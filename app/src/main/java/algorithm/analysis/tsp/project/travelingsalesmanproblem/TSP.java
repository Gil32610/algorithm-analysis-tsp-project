package algorithm.analysis.tsp.project.travelingsalesmanproblem;

public class TSP {
    private Integer[][] weightedGraph;

    public TSP(Integer[][] weightedGraph) {
        this.weightedGraph = weightedGraph;
    }

    public Integer[] swapEdges(Integer[] elements, int first, int second) {
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

    public Integer[][] generateNeighborhood(Integer[] solution) {
        int solutionSize = solution.length;
        
        Integer[] newSolution = new Integer[sizeOfNeighborhood][solutionSize];
        // implement 2-edge exchange or swap operator
        return newSolution;
    }

    public Boolean acceptor(Integer[] currentSolution, Integer[] neighbor) {
        Boolean isBetter = false;
        return isBetter;
    }

    private int calculateDistanceCost(Integer[] solution) {
        int cost = weightedGraph[solution[0]][solution[solution.length - 1]];
        for (int i = 0; i < solution.length - 1; i++) {
            cost += weightedGraph[solution[i]][solution[i + 1]];
        }
        return cost;
    }

}