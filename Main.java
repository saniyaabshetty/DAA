import java.util.Arrays;
import java.util.Scanner;

class Activity implements Comparable<Activity> {
    int start;
    int finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public int compareTo(Activity other) {
        if (this.finish != other.finish) {
            return this.finish - other.finish;
        } else {
            return this.start - other.start;
        }
    }
}

public class Main {
    public static void activitySelection(Activity[] activities) {
        Arrays.sort(activities);
        System.out.println("Selected activities:");
        System.out.printf("(%d, %d)\n", activities[0].start, activities[0].finish);
        int j = 0;
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= activities[j].finish) {
                System.out.printf("(%d, %d)\n", activities[i].start, activities[i].finish);
                j = i;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of activities: ");
        int n = scanner.nextInt();
        Activity[] activities = new Activity[n];
        System.out.println("Enter the start and finish times of the activities:");
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int finish = scanner.nextInt();
            activities[i] = new Activity(start, finish);
        }
        activitySelection(activities);
        scanner.close();
    }
}
