import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        final InputReader in = oj ? new InputReader(System.in) : new InputReader(new FileInputStream(new File("input.txt")));
        final PrintWriter out = new PrintWriter(System.out);
        new TaskC().solve(in, out);
        out.close();
    }

//    static class TaskC {
//        void solve(InputReader in, PrintWriter out) {
//            int t = in.nextInt();
//            for (int i = 0; i < t; i++) {
//                int n = in.nextInt();
//
//                int min1 = in.nextInt(), min2 = in.nextInt(), min = min1 ^ min2;
//                for (int j = 2; j < n; j++) {
//                    int v = in.nextInt();
//
//                    int c1 = v ^ min1;
//                    int c2 = v ^ min2;
//
//                    if (c1 > min && c2 > min) {
//                        continue;
//                    }
//
//                    if (c1 < c2) {
//                        min2 = v;
//                        min = c1;
//                    } else {
//                        min1 = v;
//                        min = c2;
//                    }
//                }
//                out.println(min);
//            }
//        }
//    }

    static class TaskC {
        void solve(InputReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                int n = in.nextInt();
                int[] a = new int[n];
                for (int j = 0; j < n; j++) {
                    a[j] = in.nextInt();
                }
                Arrays.sort(a);
                int min = -1;
                for (int j = 0; j < n - 1; j++) {
                    int v = a[j] ^ a[j + 1];
                    if (min == -1 || v < min) {
                        min = v;
                    }
                }
                out.println(min);
            }
        }
    }

//    static class TaskC {
//        void solve(InputReader in, PrintWriter out) {
//            int t = in.nextInt();
//            for (int i = 0; i < t; i++) {
//                int n = in.nextInt();
//                int[] a = new int[n];
//                for (int j = 0; j < n; j++) {
//                    a[j] = in.nextInt();
//                }
//                Arrays.sort(a);
//                int min = -1;
//                for (int j = 0; j < n - 1; j++) {
//                    for (int k = j + 1; k < n; k++) {
//                        int r = a[j] ^ a[k];
//                        if (min == -1 || r < min) {
//                            min = r;
//                        }
//                    }
//                }
//                out.println(min);
//            }
//        }
//    }

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
    }
}
