import java.util.Scanner;

public class Main {
    static int coinChangeDynamic(int[] coinsValue, int totalValue, int coins) {
        int[] resultMatrix = new int[totalValue + 1];
        int[] solutionMatrix = new int[totalValue + 1];
        int value;
        resultMatrix[0] = 0;
        solutionMatrix[0] = 0;
        for (int j = 1; j <= totalValue; j++) {
            int minimum = 10000;
            int coin = 0;
            for (int i = 0; i < coins; i++) {
                if (j >= coinsValue[i]) {
                    if ((1 + resultMatrix[j - coinsValue[i]]) < minimum) {
                        minimum = 1 + resultMatrix[j - coinsValue[i]];
                        coin = i;
                    }
                }
            }
            resultMatrix[j] = minimum;
            solutionMatrix[j] = coin;
        }
        System.out.println("Selected coins:");
        value = totalValue;
        while (value > 0) {
            System.out.println(coinsValue[solutionMatrix[value]]);
            value -= coinsValue[solutionMatrix[value]];
        }
        return resultMatrix[totalValue];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of coins: ");
        int coins = scanner.nextInt();
        System.out.print("\nEnter the total value: ");
        int totalValue = scanner.nextInt();
        int[] coinsValue = new int[coins];
        System.out.println("\nEnter the value of coins:");
        for (int i = 0; i < coins; i++) {
            coinsValue[i] = scanner.nextInt();
        }
        int minCoins = coinChangeDynamic(coinsValue, totalValue, coins);
        System.out.println("Minimum number of coins required: " + minCoins);
    }
}
