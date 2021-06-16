import java.io.Console;

class Main {
    public static void main(String[] args) {
        System.out.print("Enter number of random samples: ");
        Console console = System.console();
        int numRepeats = Integer.parseInt(console.readLine());

        double pi = Pi.estimatePi(numRepeats);
        System.out.println("Monte Carlo estimation for Pi: " + pi);
    }

    public static class Pi {

        public static boolean insideCir(double x, double y) {
            double distFromOrigin = Math.sqrt((x * x) + (y * y));
            return (distFromOrigin < 1.0);
        }

        public static double estimatePi(int numRepeats) {
            double pi;
            int timesInsideCir = 0;

            for (int i = 1; i <= numRepeats; i++) {
                double x = (Math.random() * 2) - 1.0;
                double y = (Math.random() * 2) - 1.0;
                if (insideCir(x, y)) {
                    timesInsideCir++;
                }
            }
            pi = (4.0 * ((double) timesInsideCir / numRepeats));

            return pi;
        }
    }
}
