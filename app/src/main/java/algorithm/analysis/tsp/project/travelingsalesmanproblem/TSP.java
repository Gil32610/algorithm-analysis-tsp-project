package algorithm.analysis.tsp.project.travelingsalesmanproblem;

public class TSP {

    public void swap(Integer[] elements, int i, int j) {

    }

    public Integer[][] generateNeighborhood(Integer[] solution) {
        int solutionSize = solution.length;
        int sizeOfNeighborhood = (solutionSize * (solutionSize - 1) / 2) - solutionSize;
        Integer[][] newSolution = new Integer[sizeOfNeighborhood][solutionSize];
        // implement 2-edge exchange or swap operator 
        return newSolution;
    }

    public Boolean acceptor(Integer[] currentSolution, Integer[] neighbor) {
        Boolean isBetter = false;
        return isBetter;
    }

}