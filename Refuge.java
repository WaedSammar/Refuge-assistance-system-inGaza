package refuge_assistance_system_ingaza;
import java.util.ArrayList;
public class Refuge {
    private String RefName;
    private int age;
    private String location;
    private int RefNum;

    public Refuge() {
    }

    public Refuge(String RefName, int age, String location, int RefNum) {
        this.RefName = RefName;
        this.age = age;
        this.location = location;
        this.RefNum = RefNum;
    }

    public String getRefName() {
        return RefName;
    }

    public void setRefName(String RefName) {
        this.RefName = RefName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRefNum() {
        return RefNum;
    }

    public void setRefNum(int RefNum) {
        this.RefNum = RefNum;
    }

    public void TakeAid(int indx) {
        ArrayList<Integer> a = new ArrayList<>();
        if (a.contains(indx)) {
            System.out.println("The Refuge has already taken this aid!!");
        } else {
            a.add(indx);
            System.out.println("The Refuge has taken the aid successfuly!!");
        }
    }
    
    public void receiveAid(AidItem aidItem) {
        System.out.println(RefName + " received aid: " + aidItem.getAssistanceType());
    }

  @Override
    public String toString() {
        return "\nRefuge{ " + "RefName = " + RefName + ", age = " + age + ", location = " + location + ", RefNum = " + RefNum + '}';
    }
}
