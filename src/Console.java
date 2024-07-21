import java.util.Scanner;

public class Console {
    private static final Scanner sc = new Scanner(System.in);

    public static double readNumber(String prompt, double min, double max){
        double value = 0;
        while(true){
            System.out.print(prompt);
            value = sc.nextDouble();
            if(value>=min && value<=max) break;
            System.out.println("Enter a value between " +min +" and " +max);
        }
        return value;
    }

    public static double readNumber(String prompt){
        System.out.println(prompt);
        return sc.nextDouble();
    }
}
