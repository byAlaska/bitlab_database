package bitlab.askar.Database;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DBManager dbManager = new DBManager();
        dbManager.connect();

        dbManager.addCar(new Car(null,"Subaru", 140000, 15));

        ArrayList<Car> cars = dbManager.getAllCars();
        for (int i=0;i<cars.size();i++){
            System.out.println(cars.get(i).toString());
        }
    }
}
