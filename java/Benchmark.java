import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

class Benchmark {
    private static List<Integer> primes = new ArrayList<Integer>();

    public static void main(String args[]) {
        String result = "";
        for (int i = 0; i < 20; i++) {
            result += measure() + "\n";
        }
        Benchmark.write(result);
    }

    private static long measure() {
        long start = System.currentTimeMillis();
        for (int i = 3; i < 3000; i++) {
            if (!checkPrimes(primes, i))
                continue;
            primes.add(factorial(i));
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static boolean checkPrimes(List<Integer> primes, int n) {
        if (n % 2 == 0)
            return true;
        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i);
            if (prime == 0)
                return false;
            if (n % prime == 0)
                return false;
        }
        return true;
    }

    private static int factorial(int nStart) {
        int r = 1;

        for (int i = nStart; i > 0; i--) {
            r *= i;
        }
        return r;
    }

    private static void write(String result) {
        String path = "/output/java.txt";
        try {
            File myObj = new File(path);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(result);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}