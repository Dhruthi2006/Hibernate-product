package com.example.foodDemo;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String args[]) {

        OrderDao dao = new OrderDao();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== ORDER MENU =====");
            System.out.println("1. Add Order");
            System.out.println("2. Find Order");
            System.out.println("3. Find All Orders");
            System.out.println("4. Update Order");
            System.out.println("5. Delete Order");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();


            switch (choice) {


            case 1:

                Order o = new Order();

                System.out.print("Enter Order id: ");
                o.setOrder_id(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter Customer name: ");
                o.setCustomer_name(sc.nextLine());

                System.out.print("Enter Food item: ");
                o.setFood_item(sc.nextLine());

                System.out.print("Enter Quantity: ");
                o.setQuantity(sc.nextInt());

                System.out.print("Enter Total Amount: ");
                o.setTotal_amount(sc.nextDouble());

                sc.nextLine();

                System.out.print("Enter Order Date: ");
                o.setOrder_date(sc.nextLine());

                System.out.print("Enter Status: ");
                o.setOrder_status(sc.nextLine());


                dao.saveOrder(o);

                break;



            case 2:

                System.out.print("Enter Order id: ");
                int id = sc.nextInt();

                Order result = dao.find(id);


                if (result != null) {

                    System.out.println(
                        result.getOrder_id() + " " +
                        result.getCustomer_name() + " " +
                        result.getFood_item() + " " +
                        result.getQuantity() + " " +
                        result.getTotal_amount() + " " +
                        result.getOrder_date() + " " +
                        result.getOrder_status()
                    );

                } else {

                    System.out.println("Order not found");

                }

                break;



            case 3:

                List<Order> list = dao.findAll();


                for (Order x : list) {

                    System.out.println(
                        x.getOrder_id() + " " +
                        x.getCustomer_name() + " " +
                        x.getFood_item() + " " +
                        x.getQuantity() + " " +
                        x.getTotal_amount() + " " +
                        x.getOrder_date() + " " +
                        x.getOrder_status()
                    );

                }

                break;



            case 4:

                Order up = new Order();


                System.out.print("Enter id: ");
                up.setOrder_id(sc.nextInt());

                sc.nextLine();


                System.out.print("Customer name: ");
                up.setCustomer_name(sc.nextLine());


                System.out.print("Food item: ");
                up.setFood_item(sc.nextLine());


                System.out.print("Quantity: ");
                up.setQuantity(sc.nextInt());


                System.out.print("Amount: ");
                up.setTotal_amount(sc.nextDouble());

                sc.nextLine();


                System.out.print("Date: ");
                up.setOrder_date(sc.nextLine());


                System.out.print("Status: ");
                up.setOrder_status(sc.nextLine());


                dao.update(up);

                break;




            case 5:

                System.out.print("Enter id to delete: ");
                dao.delete(sc.nextInt());

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