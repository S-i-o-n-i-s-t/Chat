package lecture.ex1;

import java.util.Scanner;

public class Main {
    private static int cnt = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread readThead = new Thread(() -> {
            Scanner in = new Scanner(System.in);
            while (in.hasNextLine()){
                String line = in.nextLine();
                cnt++;
            }
        });
        readThead.setDaemon(true);// обозначили, что поток сервисный
        readThead.start();
        while (true){
            System.out.println(cnt + " messages inputted by user");
            Thread.sleep(1000);
        }
    }
}
