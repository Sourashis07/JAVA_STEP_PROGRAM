import java.util.Scanner;



public class Week1Ques1 {

    static int getLength(String s) {

        int count = 0;

        try {

            while (true) s.charAt(count++);

        } catch (Exception e) {}

        return count;

    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Stirng: ");
        String s = sc.nextLine();

        System.out.println("Length (custom): " + getLength(s));

        System.out.println("Length (built-in): " + s.length());

    }

}