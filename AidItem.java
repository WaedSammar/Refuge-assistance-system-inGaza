package refuge_assistance_system_ingaza;
import java.text.*;
import java.util.Date;

public class AidItem {
  private String AssistanceType;
    private String ExpDate;
    private String quantity;

    public AidItem() {
    }

    public AidItem(String AssistanceType, String ExpDate, String quantity) {
        this.AssistanceType = AssistanceType;
        this.ExpDate = ExpDate;
        this.quantity = quantity;
    }

    public String getAssistanceType() {
        return AssistanceType;
    }

    public void setAssistanceType(String AssistanceType) {
        this.AssistanceType = AssistanceType;
    }

    public String getExpDate() {
        return ExpDate;
    }

    public void setExpDate(String ExpDate) {
        this.ExpDate = ExpDate;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "\nAidItem{ " + "AssistanceType = " + AssistanceType + ", ExpDate = " + ExpDate + ", quantity = " + quantity + '}';
    }

    public void displayAidItemInfo() {
        System.out.println("Assistance Type: " + AssistanceType);
        System.out.println("Expiration Date: " + ExpDate);
        System.out.println("Quantity: " + quantity);
    }

  public boolean isExpired() {
        if ("There is no expiration date".equalsIgnoreCase(ExpDate)) {
            return false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
        Date expirationDate = null;
        try {
            expirationDate = dateFormat.parse(ExpDate);
        } catch (ParseException e1) {
            try {
                expirationDate = dateFormat2.parse(ExpDate);
            } catch (ParseException e2) {
                return false;
            }
        }
        Date currentDate = new Date();
        return currentDate.after(expirationDate);
    }
}

