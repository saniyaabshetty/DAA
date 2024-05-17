import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Activity {
    int start;
    int finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class activityselection {
    public static void activitySelection(Activity[] activities) {
        Arrays.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity a, Activity b) {
                if (a.finish != b.finish) {
                    return a.finish - b.finish;
                } else {
                    return a.start - b.start;
                }
            }
        });
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
