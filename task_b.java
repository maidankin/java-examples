import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        final InputReader in = oj ? new InputReader(System.in) : new InputReader(new FileInputStream(new File("input.txt")));
        final PrintWriter out = new PrintWriter(System.out);
        //new TaskC().solve(in, out);
        new TaskB().solve(in, out);
        out.close();
    }

    static class TaskB {
        void solve(InputReader in, PrintWriter out) {
            long d = in.nextLong();
            long k = in.nextLong();
            long pr = k / d;
            int counter = 0;

            if (d < k) {
                Set<Long> ar = new HashSet<>();
                for (long i = 1; i <= pr / 2; i++) {
                    if (pr % i == 0) {
                        if (!ar.contains(i) && !ar.contains(pr / i)) {
                            ar.add(i);
                            ar.add(pr / i);
                            counter += 1;
                        }
                    }
                }
                if (counter > 0){
                    counter += 1;
                }
            }

            if (d == k){
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
