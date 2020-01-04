import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        final InputReader in = oj ? new InputReader(System.in) : new InputReader(new FileInputStream(new File("input.txt")));
        final PrintWriter out = new PrintWriter(System.out);
        new TaskA().solve(in, out);
        out.close();
    }

    static class TaskA {
        void solve(InputReader in, PrintWriter out) {
            Locale.setDefault(Locale.US);
            //  **  Dish list
            int n = in.nextInt();
            Map<String, Integer> DishAmount = new HashMap<>();
            Map<String, List<Map<String, Map<Integer, String>>>> Dish = new HashMap<>();

            for (int i = 0; i < n; i++) {
                ArrayList<Map<String, Map<Integer, String>>> ingredients = new ArrayList<>();
                HashMap<String, Map<Integer, String>> ingredient = new HashMap<>();
                HashMap<Integer, String> ingredientsAmount = new HashMap<>();

                String currentDish = in.next();
                int c = in.nextInt();
                DishAmount.put(currentDish, c);

                int ingredientsCount = in.nextInt();
                for (int j = 0; j < ingredientsCount; j++) {
                    String ingrName = in.next();
                    Integer ingrCount = in.nextInt();
                    String ingrMeasure = in.next();
                    ingredientsAmount.put(ingrCount, ingrMeasure);
                    ingredient.put(ingrName, ingredientsAmount);

                    ingredients.add(ingredient);
                }
                Dish.put(currentDish, ingredients);
            }

            //  **  Ingredients list
            int k = in.nextInt();
            Map<String, Map<Integer, Map<Integer, String>>> IngredientsList = new HashMap<>();
            for (int i = 0; i < k; i++) {
                HashMap<Integer, Map<Integer, String>> ingredient = new HashMap<>();
                HashMap<Integer, String> ingredientsAmount = new HashMap<>();

                String currentIngredient = in.next();
                Integer ingrPrice = in.nextInt();
                Integer ingrCount = in.nextInt();
                String ingrMeasure = in.next();

                ingredientsAmount.put(ingrCount, ingrMeasure);
                ingredient.put(ingrPrice, ingredientsAmount);
                IngredientsList.put(currentIngredient, ingredient);
            }

            //  **  Calories list
            int m = in.nextInt();
            Map<String, Map<Integer, Map<String, double[]>>> CaloriesList = new HashMap<>();
            for (int i = 0; i < m; i++) {
                HashMap<Integer, Map<String, double[]>> ingredient = new HashMap<>();
                HashMap<String, double[]> ingredientsCalories = new HashMap<>();

                String currentIngredient = in.next();
                Integer ingrCount = in.nextInt();
                String ingrMeasure = in.next();
                Double ingrProteins = in.nextDouble();
                Double ingrFats = in.nextDouble();
                Double ingrCarbohydrates = in.nextDouble();
                Double ingrEnergy = in.nextDouble();

                double[] ingrData = new double[4];
                ingrData[0] = ingrProteins;
                ingrData[1] = ingrFats;
                ingrData[2] = ingrCarbohydrates;
                ingrData[3] = ingrEnergy;

                ingredientsCalories.put(ingrMeasure, ingrData);
                ingredient.put(ingrCount, ingredientsCalories);
                CaloriesList.put(currentIngredient, ingredient);
            }

            for (Map.Entry<String, Integer> stringIntegerEntry : DishAmount.entrySet()) {
                //DishAmount.get();
                System.out.println(stringIntegerEntry.getKey());
            }

            //out.println(min);
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

        Double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
