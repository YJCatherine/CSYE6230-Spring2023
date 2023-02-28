import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArraySumParallel {

    public static void main(String[] args) {
        // create an array of numbers
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            num.add(i);
        }

        // calculate the sum of the array in serial
        long start = System.nanoTime();
        double serialSum = multiplyAndSumSerial(num);
        double serialTime = (System.nanoTime() - start) / 1e9;

        // calculate the sum of the array in parallel
        start = System.nanoTime();
        double parallelSum = multiplyAndSumParallel(num);
        double parallelTime = (System.nanoTime() - start) / 1e9;

        // print the results
        System.out.println("Serial sum: " + serialSum + ", time: " + serialTime + " seconds");
        System.out.println("Parallel sum: " + parallelSum + ", time: " + parallelTime + " seconds");
        System.out.println("Time difference: " + (serialTime - parallelTime) + " seconds");
    }

    private static double multiplyAndSumParallel(List<Integer> num) {
        double[] arr = new double[num.size()];
        Random rand = new Random();
        for (int i = 0; i < num.size(); i++) {
            arr[i] = rand.nextDouble() * 0.9 + 0.1;
        }
        return num.parallelStream().mapToDouble(n -> arr[n-1]*n).sum();
    }

    private static double multiplyAndSumSerial(List<Integer> num) {
        double[] arr = new double[num.size()];
        Random rand = new Random();
        for (int i = 0; i < num.size(); i++) {
            arr[i] = rand.nextDouble() * 0.9 + 0.1;
        }
        double sum = 0;
        for (int i = 0; i < num.size(); i++) {
            sum += arr[i] * num.get(i);
        }
        return sum;
    }
}
