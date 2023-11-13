import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TaskC {

    public static class Product implements Comparable<Product> {
        public int price;
        public int weight;

        public Product(int price, int weight) {
            this.price = price;
            this.weight = weight;
        }

        @Override
        public int compareTo(Product o) {
            int res = Integer.compare(this.price, o.price);
            if (res != 0)
                return res;
            return -Integer.compare(this.weight, o.weight);
        }
    }

    public static class InputData {
        public int backWeight;
        public List<Product> products;

        public InputData(int backWeight, List<Product> products) {
            this.backWeight = backWeight;
            this.products = products;
        }
    }

    public static void main(String[] args) throws IOException {
        InputData in = read();
        in.products.sort(Collections.reverseOrder());

        int freeWeight = in.backWeight;

        long total = 0;
        for (int i = 0; i < in.products.size(); i++) {

            if(freeWeight == 0)
                break;

            int delta = freeWeight - in.products.get(i).weight;

            if(delta >= 0) {
                total += (long) in.products.get(i).price * in.products.get(i).weight;
                freeWeight -= in.products.get(i).weight;
            } else {
                total += (long) in.products.get(i).price * (in.products.get(i).weight + delta);
                freeWeight -= (in.products.get(i).weight + delta);
            }
        }

        write(total);
    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int backWeight = Integer.parseInt(reader.readLine());
        int productsCount = Integer.parseInt(reader.readLine());

        List<Product> products = new ArrayList<>(productsCount);

        for (int i = 0; i < productsCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int price = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            products.add(new Product(price, weight));
        }

        return new InputData(backWeight, products);
    }

    private static void write(long price) {
        System.out.println(price);
    }
}

 