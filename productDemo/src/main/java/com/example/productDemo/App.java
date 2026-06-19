package com.example.productDemo;
//package com.example.productDemo;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ProductDao dao = new ProductDao();
        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n===== PRODUCT MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. Find Product");
            System.out.println("3. Find All Products");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch(choice) {
            case 1:
                Product p = new Product();
                System.out.println("Enter id:");
                p.setId(sc.nextInt());
                System.out.print("Enter name: ");
                p.setName(sc.next());
                System.out.print("Enter price: ");
                p.setPrice(sc.nextDouble());
                dao.saveProduct(p);
                break;
            case 2:
                System.out.print("Enter product id: ");
                int id = sc.nextInt();
                Product product = dao.find(id);
                if(product != null) {
                    System.out.println(
                      product.getId()+" "+
                      product.getName()+" "+
                      product.getPrice()
                    );
                }
                else {
                    System.out.println("Product not found");
                }
                break;
            case 3:
                List<Product> list = dao.findAll();
                for(Product pro : list) {
                    System.out.println(
                      pro.getId()+" "+
                      pro.getName()+" "+
                      pro.getPrice()
                    );
                }
                break;
            case 4:
                Product update = new Product();
                System.out.print("Enter id: ");
                update.setId(sc.nextInt());
                System.out.print("Enter new name: ");
                update.setName(sc.next());
                System.out.print("Enter new price: ");
                update.setPrice(sc.nextDouble());
                dao.Update(update);
                System.out.println("Updated");
                break;
            case 5:
                System.out.print("Enter id to delete: ");
                int deleteId = sc.nextInt();
                dao.delete(deleteId);
                break;
            case 6:
                System.out.println("Exiting...");
                sc.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice");

            }
        }
    }
}