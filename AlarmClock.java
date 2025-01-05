import java.util.Calendar;
import java.util.Scanner;

public class AlarmClock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the alarm time (HH:mm): ");
            String alarmTime = scanner.nextLine();

            // Validate time format and split input
            if (!alarmTime.matches("\\d{2}:\\d{2}")) {
                System.out.println("Invalid time format. Please use HH:mm.");
                return;
            }

            String[] timeParts = alarmTime.split(":");
            int alarmHour = Integer.parseInt(timeParts[0]);
            int alarmMinute = Integer.parseInt(timeParts[1]);

            // Validate hour and minute ranges
            if (alarmHour < 0 || alarmHour >= 24 || alarmMinute < 0 || alarmMinute >= 60) {
                System.out.println("Invalid time input. Please ensure the hour is between 00 and 23, and minute is between 00 and 59.");
                return;
            }

            // Check every second for the alarm time
            while (true) {
                Calendar now = Calendar.getInstance();
                int currentHour = now.get(Calendar.HOUR_OF_DAY);
                int currentMinute = now.get(Calendar.MINUTE);

                if (currentHour == alarmHour && currentMinute == alarmMinute) {
                    System.out.println("Alarm!!!");
                    break;
                }

                try {
                    Thread.sleep(1000); // Check every second
                } catch (InterruptedException e) {
                    System.err.println("The thread was interrupted.");
                    return;
                }
            }
        } finally {
            scanner.close(); // Close scanner to avoid resource leak
        }
    }
}

