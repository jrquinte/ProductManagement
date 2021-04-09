/*
 * Copyright (C) 2021 jrqui
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package labs.pm.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Locale;
import labs.pm.data.Drink;
import labs.pm.data.Food;
import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

/**
 * {@code Shop} class represents an application that manages Products
 *
 * @version 4.0
 *
 * @author jrqui
 */
public class Shop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ProductManager pm = new ProductManager("en-GB");

        //pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        pm.parseProduct("D,101,Tea,1.99,0,2019-09-19");
        //pm.parseProduct("D,101,Tea,1.99,0");        
        pm.printProductReport(101);

        pm.parseReview("101,4,Nice hot cup of tea");
        pm.parseReview("101,2,Rather weak tea");
        pm.parseReview("101,4,Fine tea");
        pm.parseReview("101,4,Good tea");
        pm.parseReview("101,5,Perfect tea");  
        pm.parseReview("101,3,Just add some lemon");        

//        pm.reviewProduct(101, Rating.FOUR_STAR, "Nice hot cup of tea");       
//        pm.reviewProduct(101, Rating.TWO_STAR, "Rather weak tea");
//        pm.reviewProduct(101, Rating.FOUR_STAR, "Fine tea");
//        pm.reviewProduct(101, Rating.FOUR_STAR, "Good tea");
//        pm.reviewProduct(101, Rating.FIVE_STAR, "Perfect tea");
//        pm.reviewProduct(101, Rating.THREE_STAR, "Just add some lemon");
        pm.printProductReport(101);

//        pm.changeLocale("ru-RU");
        pm.createProduct(102, "Coffee", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        pm.reviewProduct(102, Rating.THREE_STAR, "Coffee was ok");
        pm.reviewProduct(102, Rating.ONE_STAR, "Where is the milk?!");
        pm.reviewProduct(102, Rating.FIVE_STAR, "It's perfect with ten spoons of sugar!");
//        pm.printProductReport(102);

        pm.parseProduct("F,103,Cake,3.99,0,2019-09-19");
        pm.printProductReport(103);
//        pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.NOT_RATED, LocalDate.now().plusDays(2));
//        pm.reviewProduct(103, Rating.FIVE_STAR, "Very nice cake");
//        pm.reviewProduct(103, Rating.FOUR_STAR, "It good, but I ve expected more chocolate ");
//        pm.reviewProduct(103, Rating.FIVE_STAR, "This cake is pe feet!");
//        pm.printProductReport(103);

        pm.createProduct(104, "Cookie", BigDecimal.valueOf(2.99), Rating.NOT_RATED, LocalDate.now());
        pm.reviewProduct(104, Rating.THREE_STAR, "Just another coolie");
        pm.reviewProduct(104, Rating.THREE_STAR, "ok");
//        pm.printProductReport(104);

        pm.createProduct(105, "Hot Chocolate", BigDecimal.valueOf(2.50), Rating.NOT_RATED);
        pm.reviewProduct(105, Rating.FOUR_STAR, "Tasty");
        pm.reviewProduct(105, Rating.FOUR_STAR, "No bad at all");
//        pm.printProductReport(105);

        pm.createProduct(106, "chocolate", BigDecimal.valueOf(2.50), Rating.NOT_RATED, LocalDate.now().plusDays(3));
        pm.reviewProduct(106, Rating.TWO_STAR, "Too sweet");
        pm.reviewProduct(106, Rating.THREE_STAR, "Better then cookie");
        pm.reviewProduct(106, Rating.TWO_STAR, "Too bitter");
        pm.reviewProduct(106, Rating.ONE_STAR, "I don't get it");
        pm.printProductReport(106);

//        pm.printProducts(new Comparator<Product>() {
//            @Override
//            public int compare(Product p1, Product p2) {
//                return p2.getRating().ordinal() - p1.getRating().ordinal();
//            }
//        });

//        pm.printProducts((Product p1, Product p2) -> p2.getRating().ordinal() - p1.getRating().ordinal());
        pm.printProducts(p -> p.getPrice().floatValue() < 2, (Product p1, Product p2) -> p2.getRating().ordinal() - p1.getRating().ordinal());
        pm.getDiscounts().forEach((rating,discount)->System.out.println(rating+"\t"+discount) );
//        pm.printProducts((p1, p2) -> p2.getPrice().compareTo(p1.getPrice()));
        Comparator<Product> ratingSorter = (p1,p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
        Comparator<Product> priceSorter = (p1,p2) -> p2.getPrice().compareTo(p1.getPrice());
        //pm.printProducts(ratingSorter);
        //pm.printProducts(priceSorter);
//          pm.printProducts(ratingSorter.thenComparing(priceSorter));
//          pm.printProducts(ratingSorter.thenComparing(priceSorter).reversed());        
        /*
        ProductManager pm = new ProductManager(Locale.US);
        Product p1 = pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        pm.printProductReport(p1);
        p1 = pm.reviewProduct(p1, Rating.FOUR_STAR, "Nice hot cup of tea");
        p1 = pm.reviewProduct(p1, Rating.TWO_STAR, "Rather weak tea");
        p1 = pm.reviewProduct(p1, Rating.FOUR_STAR, "Fine tea");
        p1 = pm.reviewProduct(p1, Rating.FOUR_STAR, "Good tea");
        p1 = pm.reviewProduct(p1, Rating.FIVE_STAR, "Perfect tea");
        p1 = pm.reviewProduct(p1, Rating.THREE_STAR, "Just add some lemon");

        pm.printProductReport(p1);

        Product p2 = pm.createProduct(102, "Coffee", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        p2 = pm.reviewProduct(p2, Rating.THREE_STAR, "Coffee was ok");
        p2 = pm.reviewProduct(p2, Rating.ONE_STAR, "Where is the milk?!");
        p2 = pm.reviewProduct(p2, Rating.FIVE_STAR, "It's perfect with ten spoons of sugar!");
        pm.printProductReport(p2);

        Product p3 = pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.NOT_RATED, LocalDate.now().plusDays(2));
        p3 = pm.reviewProduct(p3, Rating.FIVE_STAR, "Very nice cake");
        p3 = pm.reviewProduct(p3, Rating.FOUR_STAR, "It good, but I ve expected more chocolate ");
        p3 = pm.reviewProduct(p3, Rating.FIVE_STAR, "This cake is pe feet!");
        pm.printProductReport(p3);

        Product p4 = pm.createProduct(104, "Cookie", BigDecimal.valueOf(2.99), Rating.NOT_RATED, LocalDate.now());
        p4 = pm.reviewProduct(p4, Rating.THREE_STAR, "Just another coolie");
        p4 = pm.reviewProduct(p4, Rating.THREE_STAR, "ok");
        pm.printProductReport(p4);

        Product p5 = pm.createProduct(105, "Hot Chocolate", BigDecimal.valueOf(2.50), Rating.NOT_RATED);
        p5 = pm.reviewProduct(p5, Rating.FOUR_STAR, "Tasty");
        p5 = pm.reviewProduct(p5, Rating.FOUR_STAR, "No bad at all");
        pm.printProductReport(p5);
        Product p6 = pm.createProduct(106, "chocolate", BigDecimal.valueOf(2.50), Rating.NOT_RATED, LocalDate.now().plusDays(3));
        p6 = pm.reviewProduct(p6, Rating.TWO_STAR, "Too sweet");
        p6 = pm.reviewProduct(p6, Rating.THREE_STAR, "Better then cookie");
        p6 = pm.reviewProduct(p6, Rating.TWO_STAR, "Too bitter");
        p6 = pm.reviewProduct(p6, Rating.ONE_STAR, "I don't get it");
        pm.printProductReport(p6);
         */

//        Product p2 = pm.createProduct(102, "Coffee", BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
//        Product p3 = pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//        Product p4 = pm.createProduct(105, "Cookie", BigDecimal.valueOf(3.99), Rating.TWO_STAR, LocalDate.now());
//        Product p5 = p3.applyRating(Rating.THREE_STAR);
//        Product p6 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR);
//        Product p7 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//        Product p8 = p4.applyRating(Rating.FIVE_STAR);        
//        Product p9 = p1.applyRating(Rating.TWO_STAR);
//        Product p1 = new Drink(101, "Tea", BigDecimal.valueOf(1.99), Rating.THREE_STAR);
//        Product p2 = new Drink(102, "Coffee", BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
//        Product p3 = new Food(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//        Product p4 = new Food(105, "Cookie", BigDecimal.valueOf(3.99), Rating.TWO_STAR, LocalDate.now());
//        Product p5 = p3.applyRating(Rating.THREE_STAR);
//        Product p6 = new Drink(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR);
//        Product p7 = new Food(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//        Product p8 = p4.applyRating(Rating.FIVE_STAR);        
//        Product p9 = p1.applyRating(Rating.TWO_STAR);           
//        System.out.println(p1.getBestBefore());
//        System.out.println(p3.getBestBefore());
//        p2.getBestBefore();
        //       p1.setId(101);
        //       p1.setName("Tea");
        //     p1.setPrice(BigDecimal.valueOf(1.99));
//        System.out.println(p1.getId() + " " + p1.getName() + " " + p1.getPrice() + " " + p1.getDiscount() + " " + p1.getRating().getStars());
//        System.out.println(p2.getId() + " " + p2.getName() + " " + p2.getPrice() + " " + p2.getDiscount() + " " + p2.getRating().getStars());
//        System.out.println(p3.getId() + " " + p3.getName() + " " + p3.getPrice() + " " + p3.getDiscount() + " " + p3.getRating().getStars());
//        System.out.println(p4.getId() + " " + p4.getName() + " " + p4.getPrice() + " " + p4.getDiscount() + " " + p4.getRating().getStars());
//        System.out.println(p5.getId() + " " + p5.getName() + " " + p5.getPrice() + " " + p5.getDiscount() + " " + p5.getRating().getStars());
//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p3);
//        System.out.println(p4);
//        System.out.println(p5);
//        //System.out.println(p6.equals(p7));
//        System.out.println(p6);
//        System.out.println(p7);        
//        System.out.println(p8);
//        System.out.println(p9);        
    }

}
