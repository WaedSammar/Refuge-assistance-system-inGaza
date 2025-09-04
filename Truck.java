package refuge_assistance_system_ingaza;
import java.util.ArrayList;
public class Truck {
   private String Transmissionline; 
  private static int NumOfTruck;
   private ArrayList<AidItem> AidItem;

    public Truck() {
    }

    public Truck(String Transmissionline, ArrayList<AidItem> AidItem) {
        this.Transmissionline = Transmissionline;
        this.AidItem = new ArrayList<>();
        NumOfTruck++;
    }

    public String getTransmissionline() {
        return Transmissionline;
    }

    public void setTransmissionline(String Transmissionline) {
        this.Transmissionline = Transmissionline;
    }

    public static int getNumOfTruck() {
        return NumOfTruck;
    }

    public ArrayList<AidItem> getAidItem() {
        return AidItem;
    }

    public void setAidItem(ArrayList<AidItem> AidItem) {
        this.AidItem = AidItem;
    }
    public void loadAidItem(AidItem aidItem) {
        AidItem.add(aidItem);
        System.out.println("Aid item loaded onto the truck.");
    }
    public void listAllAidItems() {
        
        for (AidItem aidItem : AidItem) {
            System.out.println("- " + aidItem.getAssistanceType());
        }
    }

    @Override
    public String toString() {
        return "\nTruck{ " + "Transmissionline = " + Transmissionline + '}';
    }
     
}
