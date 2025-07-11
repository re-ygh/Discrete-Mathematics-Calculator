import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        while (true) {
            try {
                System.out.println("1-Discrete Mathematics Calculator\n2-Exit\nChoose with number:");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("_______________________________");
                        discreteMathCalculator();
                        break;
                    case 2:
                        System.out.println("_______________________________");
                        System.exit(0);
                    default:
                        System.out.println("Invalid selection, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
                input.nextLine();
            }
        }
    }

    private void discreteMathCalculator() {
        outerLoop:
        while (true) {
            try {
                System.out.println("1-Factorial\n2-Circular Permutation\n3-Permutation\n4-Combination\n5-Return to Main Menu\nChoose with number:");
                int userChoice = input.nextInt();
                switch (userChoice) {
                    case 1:
                        factorialMenu();
                        break;
                    case 2:
                        calculateCircularPermutation();
                        break;
                    case 3:
                        calculatePermutation();
                        break;
                    case 4:
                        calculateCombination();
                        break;
                    case 5:
                        System.out.println("_______________________________");
                        break outerLoop;
                    default:
                        System.out.println("Invalid selection, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
                input.nextLine();
            }
        }
    }

    private void factorialMenu() {
        innerLoop:
        while (true) {
            try {
                System.out.println("1-n!\n2-n!!\n3-n!!!\nChoose with number (B to go back):");
                String userChoice = input.next();
                switch (userChoice) {
                    case "1":
                        handleFactorial(1);
                        break innerLoop;
                    case "2":
                        handleFactorial(2);
                        break innerLoop;
                    case "3":
                        handleFactorial(3);
                        break innerLoop;
                    case "B":
                    case "b":
                        System.out.println("_______________________________");
                        break innerLoop;
                    default:
                        System.out.println("Invalid selection, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
                input.nextLine();
            }
        }
    }

    private void handleFactorial(int step) {
        while (true) {
            try {
                System.out.println("Enter a positive integer for n:");
                int n = input.nextInt();
                if (n >= 0) {
                    System.out.println("Result: " + calculateFactorial(n, step));
                    System.out.println("_______________________________");
                    break;
                } else {
                    System.out.println("Invalid input, n must be non-negative.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
                input.nextLine();
            }
        }
    }

    private void calculateCircularPermutation() {
        while (true) {
            try {
                System.out.println("Enter a positive integer for n (B to go back):");
                String inputStr = input.next();
                if (inputStr.equalsIgnoreCase("B")) {
                    System.out.println("_______________________________");
                    break;
                }
                int n = Integer.parseInt(inputStr);
                if (n > 0) {
                    System.out.println("Result: " + calculateFactorial(n - 1, 1));
                    System.out.println("_______________________________");
                    break;
                } else {
                    System.out.println("Invalid input, n must be positive.");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid input, please try again.");
            }
        }
    }

    private void calculatePermutation() {
        while (true) {
            try {
                System.out.println("Enter a positive integer for n (B to go back):");
                String inputN = input.next();
                if (inputN.equalsIgnoreCase("B")) {
                    System.out.println("_______________________________");
                    break;
                }
                int n = Integer.parseInt(inputN);

                System.out.println("Enter a positive integer for r (B to go back):");
                String inputR = input.next();
                if (inputR.equalsIgnoreCase("B")) {
                    System.out.println("_______________________________");
                    break;
                }
                int r = Integer.parseInt(inputR);

                if (n >= 0 && r >= 0) {
                    int result = calculateFactorial(n, 1) / calculateFactorial(n - r, 1);
                    System.out.println("Result: " + result);
                    System.out.println("_______________________________");
                    break;
                } else {
                    System.out.println("Invalid input, n and r must be non-negative.");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid input, please try again.");
            }
        }
    }

    private void calculateCombination() {
        while (true) {
            try {
                System.out.println("Enter a positive integer for n (B to go back):");
                String inputN = input.next();
                if (inputN.equalsIgnoreCase("B")) {
                    System.out.println("_______________________________");
                    break;
                }
                int n = Integer.parseInt(inputN);

                System.out.println("Enter a positive integer for r (B to go back):");
                String inputR = input.next();
                if (inputR.equalsIgnoreCase("B")) {
                    System.out.println("_______________________________");
                    break;
                }
                int r = Integer.parseInt(inputR);

                if (n >= 0 && r >= 0) {
                    int result = calculateFactorial(n, 1) / (calculateFactorial(n - r, 1) * calculateFactorial(r, 1));
                    System.out.println("Result: " + result);
                    System.out.println("_______________________________");
                    break;
                } else {
                    System.out.println("Invalid input, n and r must be non-negative.");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid input, please try again.");
            }
        }
    }

    private int calculateFactorial(int x, int step) {
        int result = 1;
        for (int i = x; i > 0; i -= step) {
            result *= i;
        }
        return result;
    }
}