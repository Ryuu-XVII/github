import java.util.ArrayList;

class Car {
    String name;
    int age;
    int speed;

    Car(String name, int age, int speed) {
        this.name = name;
        this.age = age;
        this.speed = speed;
    }
}

class Fleet {
    ArrayList<Car> cars = new ArrayList<>();

    void addCar(Car car) {
        cars.add(car);
    }

    double getAverageAge() {
        if (cars.size() == 0) return 0;
        int total = 0;
        for (Car c : cars) {
            total += c.age;
        }
        return (double) total / cars.size();
    }

    Car getFastestCar() {
        if (cars.size() == 0) return null;
        Car fastest = cars.get(0);
        for (Car c : cars) {
            if (c.speed > fastest.speed) {
                fastest = c;
            }
        }
        return fastest;
    }
}

public class Main {
    public static void main(String[] args) {
        Fleet fleet = new Fleet();

        fleet.addCar(new Car("Toyota", 5, 180));
        fleet.addCar(new Car("Honda", 3, 200));
        fleet.addCar(new Car("Ford", 7, 160));

        System.out.println("Average age of cars: " + fleet.getAverageAge());

        Car fastest = fleet.getFastestCar();
        if (fastest != null) {
            System.out.println("Fastest car: " + fastest.name + " (" + fastest.speed + " km/h)");
        }
    }
}
