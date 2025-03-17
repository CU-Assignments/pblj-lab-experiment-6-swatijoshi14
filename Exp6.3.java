import java.util.*; 
import java.util.stream.Collectors; 
class Product { 
String category; 
String name; 
double price; 
public Product(String category, String name, double price) { 
this.category = category; 
this.name = name; 
this.price = price; 
} 
@Override 
public String toString() { 
return name + " ($" + price + ")"; 
} 
} 
public class ProductProcessing { 
public static void main(String[] args) { 
List<Product> products = Arrays.asList( 
new Product("Electronics", "Laptop", 800), 
new Product("Electronics", "Smartphone", 500), 
new Product("Home", "Vacuum Cleaner", 200), 
new Product("Home", "Microwave", 150), 
new Product("Electronics", "Tablet", 300) 
); 
Map<String, List<Product>> groupedByCategory = products.stream() 
.collect(Collectors.groupingBy(p -> p.category)); 
Map<String, Product> mostExpensiveProduct = products.stream() 
.collect(Collectors.toMap(  
p -> p.category, 
p -> p, 
(p1, p2) -> p1.price > p2.price ? p1 : p2 
)); 
double avgPrice = products.stream() 
.mapToDouble(p -> p.price) 
.average() 
.orElse(0); 
System.out.println("GROUPED PRODUCTS BY CATEGORY:"); 
groupedByCategory.forEach((category, productList) -> { 
System.out.println(" " + category + ": " + productList); 
}); 
System.out.println("\nMOST EXPENSIVE PRODUCT IN EACH CATEGORY:"); 
mostExpensiveProduct.forEach((category, product) -> { 
System.out.println(" " + category + ": " + product); 
}); 
System.out.println("\nAVERAGE PRICE OF ALL PRODUCTS: $" + String.format("%.2f", 
avgPrice)); 
}
