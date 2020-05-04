package bitlab.askar.Database.Aykhan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Connection connection;

    private static void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/","root", ""
            );

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void disconnect(){
        try {
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        connect();
        Scanner in=new Scanner(System.in);
        while (true){
            System.out.println("PRESS 1 TO ADD BOOK");
            System.out.println("PRESS 2 TO LIST BOOK");
            System.out.println("PRESS 0 TO EXIT");
            String choice=in.next();
            if (choice.equals("1")){
                System.out.println("Insert name:");
                String name = in.next();
                System.out.println("Insert price:");
                int price = in.nextInt();
                addproduct(new Products(null,name,price));
            }
            else if(choice.equals("2")){
                ArrayList<Products> products = getAllProducts();

                for(int i=0;i<products.size();i++){
                    System.out.println(
                            products.get(i).getId()
                                    + " " + products.get(i).getName()
                                    + " " + products.get(i).getPrice() + " KZT");
            }

        }else if(choice.equals("0")){
                disconnect();
                break;
            }
    }
    }

    public static void addproduct(Products products){
        try{
            PreparedStatement preparedStatement=
                    connection.prepareStatement("INSERT INTO products (id, name, price) VALUES (NULL, ?, ?) ");
            preparedStatement.setString(1,products.getName());
            preparedStatement.setDouble(2,products.getPrice());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static ArrayList<Products> getAllProducts(){
        ArrayList<Products> allproducts=new ArrayList<>();
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM `products`");
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                Long id=resultSet.getLong("id");
                String name=resultSet.getString("name");
                int price=resultSet.getInt("price");
                allproducts.add(new Products(id,name,price));
            }
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return allproducts;


    }
}
