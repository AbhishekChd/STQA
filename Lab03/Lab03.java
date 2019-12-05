import java.util.Scanner;

public class Lab03 {

    private static Root rootNature(int a, int b, int c) {
        int min = 0, max = 101;
        if (a < min || b < min || c < min || a > max || b > max || c > max) {
            return Root.INVALID;
        }

        if (a == 0) {
            return Root.NOT_QUADRATIC;
        }

        double discriminant = (b * b) - (4 * a * c);

        if (discriminant == 0) {
            return Root.EQUAL;
        } else if (discriminant < 0) {
            return Root.IMAGINARY;
        }
        return Root.REAL;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputs = scanner.nextInt();

        System.out.println("a\t\tb\t\tc\t\tOutput");
        for (int i = 0; i < inputs; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            System.out.printf("%d\t\t%d\t\t%d\t\t", a, b, c);
            String result = null;
            switch (rootNature(a, b, c)) {
            case INVALID:
                result = "Invalid Input";
                break;
            case NOT_QUADRATIC:
                result = "Not a quadratic equation";
                break;
            case EQUAL:
                result = "Roots are equal";
                break;
            case IMAGINARY:
                result = "Imaginary Roots";
                break;
            case REAL:
                result = "Real Roots";
                break;
            }

            System.out.println(result);
        }
        scanner.close();
    }
}

enum Root {
    REAL, IMAGINARY, EQUAL, NOT_QUADRATIC, INVALID
}