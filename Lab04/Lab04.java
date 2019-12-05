import java.util.Scanner;

class Lab04 {
    private static Triangle triangleType(int a, int b, int c) {
        int min = 0, max = 101;
        if (a < min || b < min || c < min || a > max || b > max || c > max) {
            return Triangle.INVALID;
        }

        if (a >= b + c || b >= a + c || c >= a + b) {
            return Triangle.NOT_TRAINGLE;
        }

        if (a == b && b == c) {
            return Triangle.EQUILATERAL;
        } else if (a == b || b == c || a == c) {
            return Triangle.ISOSCELES;
        }
        return Triangle.SCALENE;
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
            switch (triangleType(a, b, c)) {
            case INVALID:
                result = "Invalid Input";
                break;
            case NOT_TRAINGLE:
                result = "Not a triangle";
                break;
            case EQUILATERAL:
                result = "Equilateral";
                break;
            case ISOSCELES:
                result = "Isosceles";
                break;
            case SCALENE:
                result = "Scalene";
                break;
            }

            System.out.println(result);
        }
        scanner.close();
    }
}

enum Triangle {
    EQUILATERAL, ISOSCELES, SCALENE, NOT_TRAINGLE, INVALID
}