package refuge_assistance_system_ingaza;
import java.util.ArrayList;
public class Associations {
     private ArrayList<Truck> truck;
    private String name;

    public Associations() {
    }

    public Associations(String name, ArrayList<Truck> truck) {
        this.name = name;
        this.truck = new ArrayList<>();
    }

    public ArrayList<Truck> getTruck() {
        return truck;
    }

    public void setTruck(ArrayList<Truck> truck) {
        this.truck = truck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addTruck(Truck Truck) {
        truck.add(Truck);
    }

    public void removeTruck(Truck Truck) {
        truck.remove(Truck);
    }

   public void listAllTrucks(ArrayList<AidItem> ass, int indx) {
        for (int i = 0; i < ass.size(); i++) {
            if (i == indx) {
                System.out.println("- " + ass.get(i).getAssistanceType());
            }
        }
   }

    public void displayTotalNumOfTrucks() {
        System.out.println("Total Number of Trucks: " + Truck.getNumOfTruck());
    }
 

}
