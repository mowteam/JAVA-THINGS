import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;
/*
Happy New Years!!!! :)
*/

public class NewYearClock {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public static void main(String[] args) {
        //year input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the new year: ");
        int newY = input.nextInt();

        //color input
        Map<String, String> map = createMap();
        String color = map.get(args[0]);

        Date newYear = new Date();
        Year(newYear, newY);
        Timer timer = new Timer();
        long interval = (1) ; // 0.001 sec
        timer.schedule( new TimerTask() {
            public void run() {
                Date currentTime = new Date();
                long current = currentTime.getTime();
                long year = newYear.getTime();
                long difference = year - current;
                Converter(difference, color);
            }
        }, 0, interval);
    }
    public static void Year(Date hey, int newY){
        hey.setYear(newY - 1900);
        hey.setMonth(0);
        hey.setDate(1);
        hey.setHours(0);
        hey.setMinutes(0);
        hey.setSeconds(0);
    }
    public static void Converter(long time, String color){
        long seconds = time/1000;
        long days = (seconds/(3600*24));
        long hours = (seconds-days*3600*24)/3600;
        long minutes = (seconds-(days*3600*24)-(hours*3600))/60;
        long second = seconds-(days*3600*24)-(hours*3600)-(minutes*60);
        String day;
        String hour;
        String minute;
        String second1;
        if(hours < 10) hour = "0" + hours;
        else hour = "" + hours;
        if(minutes < 10) minute = "0" + minutes;
        else minute = "" + minutes;
        if(second < 10) second1 = "0" + second;
        else second1 = "" + second;
        if(days < 10) day = "0" + days;
        else day = "" + days;
        if(second <= 0 && minutes <= 0 && hours <= 0) System.out.print(color + "\r" + "Happy New Year!! :)" + ANSI_RESET);
        else System.out.print(color + "\r" + day + ":" + hour + ":" + minute + ":" + second1 + ANSI_RESET);
    }

    public static HashMap<String, String> createMap(){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("black", "\u001B[30m");
        map.put("red", "\u001B[31m");
        map.put("green", "\u001B[32m");
        map.put("yellow", "\u001B[33m");
        map.put("blue", "\u001B[34m");
        map.put("purple", "\u001B[35m");
        map.put("cyan", "\u001B[36m");
        map.put("white", "\u001B[37m");

        return map;
    }

}
