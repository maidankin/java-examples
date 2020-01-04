import java.io.*;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main {
    static long[] sieveOfEratosthenes(int n) {
        long[] result = new long[n + 1];
        for (int i = 2; i <= n; i++) {
            if (result[i] == 0) {
                if (((long) i) * i <= n) {
                    for (int j = i * i; j <= n; j += i) {
                        result[j] = i;
                    }
                }
            }
        }
        return result;
    }

    static Set<Long> getMultipliers(int n) {
        Set<Long> result = new HashSet<>();
        long[] sieve = sieveOfEratosthenes(n);
        System.out.println(Arrays.toString(sieve));
        int curNum = n;
        while (curNum != 1) {
            result.add(sieve[curNum]);
            curNum = (int) (curNum / sieve[curNum]);
        }
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println("getMultipliers(18) = " + findDividers(18));

        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        final InputReader in = oj ? new InputReader(System.in) : new InputReader(new FileInputStream(new File("input.txt")));
        final PrintWriter out = new PrintWriter(System.out);
        new TaskB().solve(in, out);
        out.close();
    }

    static List<Long> findDividers(long x) {
        List<Long> dividers = new ArrayList<>();

        for (long i = 1; i <= sqrt(x); i++) {
            if (x % i == 0) {
                dividers.add(i);

                //для корня из x не существует парного делителя
                if (i * i != x) {
                    dividers.add(x / i);
                }
            }
        }

        return dividers;
    }

    static class TaskB {


        void solve(InputReader in, PrintWriter out) {
            long d = in.nextLong();
            long k = in.nextLong();
            long pr = k / d;
            int counter = 0;

            if (d < k) {

                counter = findDividers(pr).size() / 2;
                if (counter > 0) {
                    counter += 1;
                }
            }

            if (d == k) {
                counter += 1;
            }

            out.println(counter);
        }
    }


    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            this.reader = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    this.tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
            return tokenizer.nextToken();
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }
    }
}