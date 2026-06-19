package com.example.Book;

/**
 * Hello world!
 *
 */
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        BookDao dao = new BookDao();
        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n===== PRODUCT MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Find Book");
            System.out.println("3. Find All Books");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch(choice) {
            case 1:
                Book b = new Book();
                System.out.println("Enter id:");
                b.setBookid(sc.nextInt());
                System.out.print("Enter title: ");
                b.setTitle(sc.next());
                System.out.print("Enter Author: ");
                b.setAuthor(sc.next());
                System.out.print("Enter category: ");
                b.setCategory(sc.next());
                System.out.print("Enter Price: ");
                b.setPrice(sc.nextDouble());
                System.out.print("Enter Available Copies: ");
                b.setAvailCopies(sc.nextInt());
                dao.saveProduct(b);
                break;
            case 2:
                System.out.print("Enter product id: ");
                int id = sc.nextInt();
                Book book = dao.find(id);
                if(book != null) {
                    System.out.println(
                      book.getBookid()+" "+
                      book.getTitle()+" "+
                      book.getAuthor()+" "+
                      book.getCategory()+" "+
                      book.getPrice()+" "+
                      book.getAvailCopies()+" "
                    );
                }
                else {
                    System.out.println("Product not found");
                }
                break;
            case 3:
                List<Book> list = dao.findAll();
                for(Book b1 : list) {
                    System.out.println(
                    		 		 b1.getBookid()+" "+
                                     b1.getTitle()+" "+
                                     b1.getAuthor()+" "+
                                     b1.getCategory()+" "+
                                     b1.getPrice()+" "+
                                     b1.getAvailCopies()+" "
                    );
                }
                break;
            case 4:
                Book update = new Book();
                System.out.println("Enter id:");
                update.setBookid(sc.nextInt());
                System.out.print("Enter title: ");
                update.setTitle(sc.next());
                System.out.print("Enter Author: ");
                update.setAuthor(sc.nextLine());
                System.out.print("Enter category: ");
                update.setCategory(sc.nextLine());
                System.out.print("Enter Price: ");
                update.setPrice(sc.nextDouble());
                System.out.print("Enter Available Copies: ");
                update.setAvailCopies(sc.nextInt());
                dao.Update(update);
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