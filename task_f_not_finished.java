import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        final InputReader in = oj ? new InputReader(System.in) : new InputReader(new FileInputStream(new File("input.txt")));
        final PrintWriter out = new PrintWriter(System.out);
        new TaskF().solve(in, out);
        out.close();
    }

    static class TaskF {
        public class Node {
            private int element;
            private Node next;
            public int getElement(){
                return element;
            }
            public void setElement(int e){
                element = e;
            }
            public Node getNext() {
                return next;
            }
            public void setNext(Node n) {
                next = n;
            }
        }
        void solve(InputReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                int n = in.nextInt();
                int k = in.nextInt();
                Node a = new Node();
                a.setElement(in.nextInt());
                a.setNext(new Node());
                out.print(a.element + " ");
                for (int j = 0; j < n - 1; j++){
                    a.setElement(in.nextInt());
                    a.setNext(new Node());
                    out.print(a.element + " ");
                }

                int maxRating = 0;
                for (int j = 0; j < n; j++){
                    int rating = 0;

                    for (int y = 0; y < n; y++){

                    }
                }
                out.println();
            }
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
