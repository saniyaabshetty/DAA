public class SubsetSum {
    
    
    static void sumOfSubset(int[] wt, int n, int currentIndex, int currentSum, int targetSum, int[] solution, int solutionIndex) {
        if (currentSum == targetSum) {
           
            for (int i = 0; i < solutionIndex; i++) {
                System.out.print(solution[i] + "\t");
            }
            System.out.println();
            return;
        }
     
        if (currentSum > targetSum || currentIndex >= n) {
            return;
        }
        
        solution[solutionIndex] = wt[currentIndex];
        sumOfSubset(wt, n, currentIndex + 1, currentSum + wt[currentIndex], targetSum, solution, solutionIndex + 1);
        
        sumOfSubset(wt, n, currentIndex + 1, currentSum, targetSum, solution, solutionIndex);
    }

    public static void main(String[] args) {
        int n = 6;
        int[] weights = {5, 10, 12, 13, 15, 18};
        int targetSum = 30;
        int[] solution = new int[6];
        sumOfSubset(weights, n, 0, 0, targetSum, solution, 0);
    }
}

