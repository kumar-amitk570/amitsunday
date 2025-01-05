import java.util.Calendar;
import java.util.Scanner;

public class AlarmClock {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the alarm time (HH:mm): ");
        String alarmTime = scanner.nextLine();

        String[] timeParts = alarmTime.split(":");
        int alarmHour = Integer.parseInt(timeParts[0]);
        int alarmMinute = Integer.parseInt(timeParts[1]);

        while (true) {
            Calendar now = Calendar.getInstance();
            int currentHour = now.get(Calendar.HOUR_OF_DAY);
            int currentMinute = now.get(Calendar.MINUTE);

            if (currentHour == alarmHour && currentMinute == alarmMinute) {
                System.out.println("Alarm!!!");
                break;
            }

            Thread.sleep(1000); // Check every second
        }
    }
}

}
