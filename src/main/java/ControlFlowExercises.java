import java.util.Scanner;

public class ControlFlowExercises {
    public static void main(String[] args) {
        int i = 5;
        while (i <= 15) {
            System.out.printf("%d ", i);
            i++;
        }
        System.out.println("");
//        System.out.println("Increment by 2\n");
//        int incrementByTwo = 0;
//        do {
//            System.out.printf("%d%n", incrementByTwo);
//            incrementByTwo += 2;
//        } while (incrementByTwo <= 100);

        System.out.println("\nDecrement by 5");
//        int decrementByFive = 100;
//        do {
//            System.out.printf("%d%n", decrementByFive);
//            decrementByFive -= 5;
//        } while (decrementByFive >= -10);
        for (int j = 100; j >= -10; j -= 5) {
            System.out.printf("%d%n", j);
        }

        System.out.println("\nExponential numbers");
//        int powersOfTwo = 2;
//        do {
//            System.out.printf("%d%n", powersOfTwo);
//            powersOfTwo = (int) Math.pow(powersOfTwo, 2);
//        } while (powersOfTwo < 1000000);
        for (int j = 2; j < 1000000; j = (int) Math.pow(j, 2)) {
            System.out.printf("%d%n", j);
        }

        System.out.println("\nFizzBuzz question");
        for (int j = 1; j <= 100; j++) {
            if (j % 3 == 0) {
                System.out.print("Fizz");
            }
            if (j % 5 == 0) {
                System.out.print("Buzz");
            }
            if (j % 3 != 0 && j % 5 != 0) {
                System.out.printf("%d", j);
            }
            System.out.println();
        }

        Scanner input = new Scanner(System.in);
        boolean powerTableIsDone;
        int powerTableNumber;
        do {
            System.out.print("\nWhat number would you like to go up to? ");
            powerTableNumber = input.nextInt();
            System.out.print("""
                
                Here is your table!
                
                number | squared | cubed
                ------ | ------- | -----
                """);
            for (int j = 1; j <= powerTableNumber; j++) {
                System.out.printf("%-6d | %-7.0f | %-5.0f%n", j, Math.pow(j, 2), Math.pow(j, 3));
            }
            System.out.println("\nWould you like to continue? Y/N");
            input.nextLine();
            powerTableIsDone = input.nextLine().equalsIgnoreCase("n");
        } while (!powerTableIsDone);

        boolean gradeInputIsDone;
        do {
            System.out.print("Insert a grade from 0 to 100: ");
            int grade = input.nextInt();
            System.out.print("Grade is: ");
            if (grade > 87) System.out.println("A");
            else if (grade > 79) System.out.println("B");
            else if (grade > 66) System.out.println("C");
            else if (grade > 59) System.out.println("D");
            else System.out.println("F");
            input.nextLine();
            System.out.println("\nContinue? Y/N");
            gradeInputIsDone = input.nextLine().equalsIgnoreCase("n");
        } while (!gradeInputIsDone);


        input.close();
    }
}
