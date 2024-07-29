import java.util.*;

/**
 * This is assignments from Sainsbury's Java technical interview
 */
public class SainsburyTest {

    /**
     * search every matching character within the list at most 3 items and return the search string
     * ["camera", "calculator", "computer", "laptop", "tablet", "charger"]
     * c-> [camera, calculator, computer]
     * ca-> [camera, calculator]
     * cam-> [camera]
     * @param gadgets, search
     */
    public static List<String> searchGadgets(List<String> gadgets, String search){
       List<String> finalGadgets = new ArrayList<>();

       for(int i =0; i < search.length(); i++){
           String temp = search.substring(0,i+1);
           finalGadgets = gadgets.stream().filter(g -> g.startsWith(temp)).sorted().toList();
           finalGadgets = finalGadgets.size() >3 ? finalGadgets.subList(0,3) : finalGadgets;
       }
        return finalGadgets;
    }

    /**
     * example of Java 17 records instead of pojo
     * @param name
     * @param type
     * @param id
     */
    public record Product (String name, String type, int id){ }
    public record ProductPrice(int id, double price, String unit){ }
    public record FinalProduct(String name, int id, double price, String unit){ }

    /**
     *  Iterate over couple of streams using records.
     */
    public static void productDetails(){
        List<FinalProduct> finalProducts = new ArrayList<>();
        List<Product> products = Arrays.asList(new Product("Chicken","Non veg", 1),
                new Product("Milk","Veg", 2),
                new Product("Potatoes","veg", 3),
                new Product("Others","Groceries", 4));

        List<ProductPrice> prices = Arrays.asList(
                new ProductPrice(1,10,"2 kg"),
                new ProductPrice(2,25,"5 kg"),
                new ProductPrice(3,30,"10 kg"),
                new ProductPrice(10,10,"1 kg")
        );

       for(Product p : products){
           for(ProductPrice pr: prices){
               if(p.id == pr.id){
                   finalProducts.add(new FinalProduct(p.name,p.id,pr.price,pr.unit));
               }
           }
       }

       finalProducts.forEach(System.out::println);
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //List<List<String>> gadgets = searchGadgets(List.of("camera", "calculator", "computer", "laptop", "tablet", "charger"), "camera");
        //gadgets.stream().flatMap(List::stream).forEach(System.out::println);
        List<String> gadgets = searchGadgets(List.of("camera", "calculator", "computer", "light","laptop", "tablet", "charger"), "camera");
        System.out.println("no of items:" + gadgets.size());
        gadgets.forEach(g-> System.out.println("Hey Gadget found:" + g));

        productDetails();

        // Thread creation using lambdas
       /* Runnable myThread = () -> {
            Thread.currentThread().setName("my-thread");
            System.out.println("Current Thread is running: " + Thread.currentThread().getName());
        };

        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);

        thread1.start();
        thread2.start();*/

    }
}
