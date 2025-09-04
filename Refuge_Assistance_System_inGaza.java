package refuge_assistance_system_ingaza;

import java.util.*;

public class Refuge_Assistance_System_inGaza {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("student name : Hala Mohammad Suleiman Al-Omari.");
        System.out.println("student number : 202210189.");
        System.out.println("...........................................");
        System.out.println("Partner Name :Waed Rabee Sammar.");
        System.out.println("Partner number : 202210654.");
        System.out.println("...........................................");
        System.out.println("Hello User ☻");
        System.out.println("...............................................");
        
       ArrayList<AidItem> i = new ArrayList<>();
        AidItem item1 = new AidItem("MedicalAid", "20-11-2024", "500k");
        AidItem item2 = new AidItem("clothes", "03-06-2024", "470k");
        AidItem item3 = new AidItem("MedicalAid", "10-01-2022", "450k");
        AidItem item4 = new AidItem("food", "23-09-2024", "480k");
        AidItem item5 = new AidItem("fuel", "29-11-2014", "300L");
        i.add(item1);
        i.add(item2);
        i.add(item3);
        i.add(item4);
        i.add(item5);

        ArrayList<Refuge> re = new ArrayList<>();
        Refuge r = new Refuge("Ahmad", 35, "Al-Sheikh Radwan District", 10);
        Refuge r1 = new Refuge("Mohammad", 24, "Rafah", 30);
        Refuge r2 = new Refuge("Ali", 55, "Al-Nserat", 40);
        Refuge r3 = new Refuge("Omar", 18, "Khanunes", 60);
        Refuge r4 = new Refuge("Rami", 80, "Shujaiya District", 20);
        re.add(r);
        re.add(r1);
        re.add(r2);
        re.add(r3);
        re.add(r4);

        ArrayList<Truck> te = new ArrayList<>();
        ArrayList<AidItem> a = new ArrayList<>(Arrays.asList(item1));
        ArrayList<AidItem> a1 = new ArrayList<>(Arrays.asList(item2));
        ArrayList<AidItem> a2 = new ArrayList<>(Arrays.asList(item3));
        ArrayList<AidItem> a3 = new ArrayList<>(Arrays.asList(item4));
        ArrayList<AidItem> a4 = new ArrayList<>(Arrays.asList(item5));
        String s = "Al-Auja Crossing to the Israeli Nitzana Crossing to the Egyptian Rafah Crossing and then handed over to UNRWA and the Palestinian Red Crescent";
        Truck t = new Truck(s, a);
        Truck t1 = new Truck(s, a1);
        Truck t2 = new Truck("Jordan", a2);
        Truck t3 = new Truck(s, a3);
        Truck t4 = new Truck("Lebanon", a4);
        te.add(t);
        te.add(t1);
        te.add(t2);
        te.add(t3);
        te.add(t4);

        ArrayList<Associations> as = new ArrayList<>();
        ArrayList<Truck> h = new ArrayList<>(Arrays.asList(t));
        ArrayList<Truck> h1 = new ArrayList<>(Arrays.asList(t1));
        ArrayList<Truck> h2 = new ArrayList<>(Arrays.asList(t2));
        ArrayList<Truck> h3 = new ArrayList<>(Arrays.asList(t3));
        ArrayList<Truck> h4 = new ArrayList<>(Arrays.asList(t4));
        Associations s1 = new Associations("UNRWA", h);
        Associations s2 = new Associations("PRCS", h1);
        Associations s3 = new Associations("QRCS", h2);
        Associations s4 = new Associations("IFRC", h3);
        Associations s5 = new Associations("Egyptian Red Crescent", h4);
        as.add(s1);
        as.add(s2);
        as.add(s3);
        as.add(s4);
        as.add(s5);

        System.out.println("If you want method AddRefuge press 1");
        System.out.println("If you want method AddAidItem press 2");
        System.out.println("If you want method sortRefugeesByRefNum press 3");
        System.out.println("If you want method checkTheNumberOfTruck press 4");
        System.out.println("If you want method checkAidItemExpiration press 5");
        System.out.println("If you want method CheckTransmissionline press 6");
        System.out.println("If you want method CheckAssistanceType press 7");
        System.out.println("If you want method unloadAllAidItemsFromTruck press 8");
        System.out.println("If you want method displayTrucksForAssociation press 9");
        System.out.print("\nEnter Number: ");
        int z = in.nextInt();
        System.out.println();
        if (z == 1) {
            AddRefuge(re);
        } else if (z == 2) {
            AddAidItem(i);
        } else if (z == 3) {
            sortRefugeesByRefNum(re);
        } else if (z == 4) {
            checkTheNumberOfTruck(te);
        } else if (z == 5) {
            checkAidItemExpiration(i);
        } else if (z == 6) {
            CheckTransmissionline(te, s);
        } else if (z == 7) {
            CheckAssistanceType(i);
        } else if (z == 8) {
            unloadAllAidItemsFromTruck(te);
        } else if (z == 9) {
            displayTrucksForAssociation(as, i);
        } else {
            System.out.println("Wrong number");
        }
    }

  private static void displayTrucksForAssociation(ArrayList<Associations> ass, ArrayList<AidItem> it) {
        System.out.println("Display Trucks For Association:\n");
        System.out.print("Enter Association Name: ");
        String AssName = in.next();
        boolean found = false;

        for (int i = 0; i < ass.size(); i++) {
            if (ass.get(i).getName().equalsIgnoreCase(AssName)) {
                found = true;
                System.out.println("Trucks in '" + ass.get(i).getName() + "' association offers:");
                ass.get(i).listAllTrucks(it, i);
                break;
            }
        }
        if (!found) {
            System.out.println("Association '" + AssName + "' not found.");
        }
    }

    private static void unloadAllAidItemsFromTruck(ArrayList<Truck> trucks) {
        System.out.println("Unload all Aid Items From Truck:\n");
        trucks.clear();

        System.out.println("The array will be: " + trucks.toString());
        System.out.println("All aid items unloaded from the truck.");
    }

    private static void sortRefugeesByRefNum(ArrayList<Refuge> re) {
        Queue<Refuge> refQueue = new LinkedList<>();
        refQueue.addAll(re);

        Stack<Refuge> RefStack = new Stack<>();

        while (!refQueue.isEmpty()) {
            Refuge currentRef = refQueue.poll();

            while (!RefStack.isEmpty() && RefStack.peek().getRefNum() < currentRef.getRefNum()) {
                refQueue.offer(RefStack.pop());
            }
            RefStack.push(currentRef);
        }

        System.out.println("Refugees sorted by Refuge Number using Stack and Queue:");
        while (!RefStack.isEmpty()) {
            Refuge refugee = RefStack.pop();
            System.out.println(refugee);
        }
        System.out.println("..................................................................");
    }

    private static void CheckAssistanceType(ArrayList<AidItem> i) {
        System.out.println("Check Assistance Type:");
        int c = 1;

        for (int j = 0; j < i.size(); j++) {

            if (!i.get(j).getAssistanceType().equalsIgnoreCase("food") && !i.get(j).getAssistanceType().equalsIgnoreCase("fuel") && !i.get(j).getAssistanceType().equalsIgnoreCase("MedicalAid")) {
                System.out.println(i.get(j).toString());
                System.out.println("NumOfTruck: " + c + " " + "it is Wrong Truck because it's wrong Assistance tybe!! ");
                i.remove(i.get(j));
                j--;
            }
            c++;
        }
    }

    private static void CheckTransmissionline(ArrayList<Truck> te, String s) {
        System.out.println("Check Transmission line:");
        int c = 1;

        for (int i = 0; i < te.size(); i++) {

            if (!te.get(i).getTransmissionline().equalsIgnoreCase(s)) {
                System.out.println(te.get(i).toString());
                System.out.println("NumOfTruck:" + c + " " + "The truck is in the wrong place.");
                te.remove(i);
                i--;
            }
            c++;
        }
    }

    private static void AddRefuge(ArrayList<Refuge> re) {
        System.out.println("Add Refuge\n");
        System.out.println("Enter details for a new refugee:\n");
        System.out.print("Name: ");
        String name = in.next();

        System.out.print("Age: ");
        int age = in.nextInt();

        System.out.print("Location: ");
        String location = in.next();

        System.out.print("Number: ");
        int num = in.nextInt();
        if (checkNumber(num, re)) {
            Refuge newRefuge = new Refuge(name, age, location, num);
            re.add(newRefuge);
            System.out.println("New refugee is added successfully!!\nAnd the array will be:\n" + re);
            System.out.println(".....................................................................");
        }
    }

    private static boolean checkNumber(int num, ArrayList<Refuge> r) {
        for (int i = 0; i < r.size(); i++) {
            if (r.get(i).getRefNum() == num) {
                throw new ArrayIndexOutOfBoundsException("cannot be add wrong number");
            }
        }
        return true;
    }

    private static void AddAidItem(ArrayList<AidItem> i) {
        System.out.println("Add Aid Item:\n");
        System.out.println("Enter details for a new aid item:\n");
        System.out.print("Assistance Type: ");
        String assistanceType = in.next();

        System.out.print("Expiration Date: ");
        String expDate = in.next();

        System.out.print("Quantity: ");
        String quantity = in.next();

        AidItem newAidItem = new AidItem(assistanceType, expDate, quantity);
        i.add(newAidItem);

        if (checkxpAndTybe(i)) {
            System.out.println("\nNew aid item is added successfully!!\nAnd the array will be:\n" + i);
        } else {
            System.out.println("\nNew Aid item cannot be Add!\n" + i);
        }
        System.out.println("..............................................................................");
    }

    private static boolean checkxpAndTybe(ArrayList<AidItem> aidItems) {
        System.out.println("Check Expiration And Assistance Tybe:\n");
        int c1 = 0;
        int c2 = 0;
        int z1 = 1;
        int z2 = 1;

        for (int i = 0; i < aidItems.size(); i++) {
            if (aidItems.get(i).isExpired()) {
                System.out.println("Number of truck: " + z1 + " The product is Expired!");
                aidItems.remove(aidItems.get(i));
                i--;
                if (i == aidItems.size() - 1) {
                    c1++;
                }
            }
            z1++;
        }
        for (int j = 0; j < aidItems.size(); j++) {

            if (!aidItems.get(j).getAssistanceType().equalsIgnoreCase("food") && !aidItems.get(j).getAssistanceType().equalsIgnoreCase("fuel") && !aidItems.get(j).getAssistanceType().equalsIgnoreCase("MedicalAid")) {
                System.out.println("NumOfTruck: " + z2 + " " + "it is Wrong Truck because it's wrong Assistance tybe!! ");
                aidItems.remove(aidItems.get(j));
                j--;
                if (j == aidItems.size() - 1) {
                    c2++;
                }
            }
            z2++;
        }
        return c2 == 0 && c1 == 0;
    }

    private static boolean checkAidItemExpiration(ArrayList<AidItem> aidItems) {
        System.out.println("Checking Aid Item Expiration:\n");
        int c = 0;
        int z = 1;

        for (int i = 0; i < aidItems.size(); i++) {
            if (aidItems.get(i).isExpired()) {
                System.out.print("Number of truck: " + z + " The product is Expired!");
                System.out.println(aidItems.get(i).toString());
                System.out.println();
                aidItems.remove(aidItems.get(i));
                i--;
                c++;
            }
            z++;
        }

        return c == 0;
    }

    private static void checkTheNumberOfTruck(ArrayList<Truck> te) {
        System.out.println("Check The Number of Truck:\n");
        System.out.println("If today is a day of war press 1 if not press 2 ");
        System.out.print("Enter number: ");

        int s = in.nextInt();
        if (s == 1) {
            if (Truck.getNumOfTruck() > 50) {
                System.out.println("Entry of 50 trucks only");
            } else {
                System.out.println("Trucks must be entered until the number reaches 50");
            }
        } else if (s == 2) {
            if (Truck.getNumOfTruck() > 200) {
                System.out.println("Entry of 200 trucks only");
            } else {
                System.out.println("Trucks must be entered until the number reaches 200");
            }
        } else {
            System.out.println("The war is over Al-hamdu lelah");
        }
    }
}