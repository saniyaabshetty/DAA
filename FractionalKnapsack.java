import java.util.Arrays;
import java.util.Comparator;

class Item {
    int profit, weight;

    Item(int profit, int weight)
    {
        this.profit = profit;
        this.weight = weight;
    }
}

public class FractionalKnapsack {


    static class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item a, Item b) {
            double r1 = (double) a.profit / (double) a.weight;
            double r2 = (double) b.profit / (double) b.weight;
            return Double.compare(r2, r1);
        }
    }

    static double fractionalKnapsack(int W, Item[] arr, int N)
    {
        // Sorting Item on basis of ratio
        Arrays.sort(arr, new ItemComparator());

        double finalValue = 0.0;

        for (int i = 0; i < N; i++) {

            if (arr[i].weight <= W) {
                W -= arr[i].weight;
                finalValue += arr[i].profit;
            }

            else {
                finalValue += arr[i].profit * ((double) W / (double) arr[i].weight);
                break;
            }
        }
        return finalValue;
    }

    public static void main(String[] args)
    {
        int W = 50;
        Item[] arr = {new Item(60, 10), new Item(100, 20), new Item(120, 30)};
        int N = arr.length;
        System.out.println(fractionalKnapsack(W, arr, N));
    }
}

