import java.util.*;

// Author: Nishita Naik
// Roll no: 27
// Title: Goa Legislative Assembly
// Start date: 30/09/2024
// Modified Date: 30/09/2024
// Description: The program gives the information about the members of Goa Legistative assemly.
// Class Member contains all the attribute of a member in a asssembly.
// It has a method to display all the information.
// we can also perform crud operation like adding updatiog and deleting a member.


// Abstract class (Abstraction) for common properties of a legislative member
abstract class LegislativeMember {
    private String name;
    private String consName;
    private int constNo;
    private String position;

    // Constructor for initializing common properties
    public LegislativeMember(String name, String consName, int constNo, String position) {
        this.name = name;
        this.consName = consName;
        this.constNo = constNo;
        this.position = position;
    }

    // Encapsulation: Getter methods to access private fields
    public String getName() {
        return name;
    }

    public String getConsName() {
        return consName;
    }

    public int getConstNo() {
        return constNo;
    }

    public String getPosition() {
        return position;
    }

    // Abstract method (Abstraction)
    public abstract String getDetails();

    // toString method for output
    @Override
    public String toString() {
        return name + " \nConstituency No/Name: " + constNo + "/" + consName + "\nPosition: " + position + "\n";
    }
}

// Derived class MLA (Inheritance) that represents MLA members
class MLA extends LegislativeMember {
    public MLA(String name, String consName, int constNo, String position) {
        super(name, consName, constNo, position);
    }

    // Implementing abstract method (Polymorphism)
    @Override
    public String getDetails() {
        return "MLA Member: " + getName() + " from " + getConsName();
    }
}

// Derived class CabinetMinister (Inheritance)
class CabinetMinister extends LegislativeMember {
    public CabinetMinister(String name, String consName, int constNo, String position) {
        super(name, consName, constNo, position);
    }

    // Implementing abstract method (Polymorphism)
    @Override
    public String getDetails() {
        return "Cabinet Minister: " + getName() + " from " + getConsName();
    }
}

// Derived class ChiefMinister (Inheritance)
class ChiefMinister extends LegislativeMember {
    public ChiefMinister(String name, String consName, int constNo, String position) {
        super(name, consName, constNo, position);
    }

    // Implementing abstract method (Polymorphism)
    @Override
    public String getDetails() {
        return "Chief Minister: " + getName() + " from " + getConsName();
    }
}

// Derived class Speaker (Inheritance)
class Speaker extends LegislativeMember {
    public Speaker(String name, String consName, int constNo, String position) {
        super(name, consName, constNo, position);
    }

    // Implementing abstract method (Polymorphism)
    @Override
    public String getDetails() {
        return "Speaker: " + getName() + " from " + getConsName();
    }
}

class OOPPrinciples {
    // List to hold members
    static List<LegislativeMember> m = new ArrayList<>();

    public static void main(String[] args) {
        // Adding members using different classes (Inheritance)
        m.add(new MLA("Shri. Jit Arolkar", "Mandrem", 1, "MLA Member"));
        m.add(new MLA("Shri. Pravin Arlekar", "Pernem", 2, "MLA Member"));
        m.add(new MLA("Shri. Chandrakant Shetye", "Bicholim", 3, "MLA Member"));
        m.add(new CabinetMinister("Shri. Nilkanth Halarnkar", "Tivim", 4, "Cabinet Minister"));
        m.add(new MLA("Shri. Joshua De Souza", "Mapusa", 5, "Deputy Speaker"));
        m.add(new CabinetMinister("Shri. Rohan Khaunte", "Porvorim", 9, "Cabinet Minister"));
        m.add(new CabinetMinister("Shri. Atanasio Monserrate", "Panaji", 11, "Cabinet Minister"));
        m.add(new ChiefMinister("Shri. Pramod Sawant", "Sanquelim", 17, "Chief Minister"));
        m.add(new MLA("Shri. Yuri Alemao", "Cuncolim", 34, "Opposition Leader"));
        m.add(new Speaker("Shri. Ramesh Tawadkar", "Cancona", 40, "Speaker"));

        Scanner s = new Scanner(System.in);
        int ch;
        do{
            System.out.println("\n \nGOA LEGISLATIVE ASSEMBLY");
            System.out.println("1. The Legislature");
            System.out.println("2. The Government");
            System.out.println("3. MLA's");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            ch = s.nextInt();
            System.out.println("\n");
            switch (ch) {
                case 1:
                    Legislature();
                    break;
                case 2:
                    Government();
                    break;
                case 3:
                    MLA();
                    break;
                case 4:
                    System.out.println("-----Exiting-------");
                    break;
                default:
                    System.out.println("Please enter a valid choice.");
                    break;
            }
        } while (ch != 4);
    }

    public static void MLA() {
        Scanner a = new Scanner(System.in);
        Scanner b = new Scanner(System.in);
        int a1;

        do {
            System.out.println("\n\n-----------MLA Members---------");
            for (LegislativeMember e : m) {
                System.out.println(e);
            }

            System.out.println("1. Insert a Member.");
            System.out.println("2. Delete a member");
            System.out.println("3. Update a member");
            System.out.println("4. Exit.");
            System.out.println("Enter your choice: ");
            a1 = a.nextInt();
            System.out.println("\n");

            switch (a1) {
                case 1:
                    System.out.println("Enter name: ");
                    String n = b.nextLine();
                    System.out.println("Enter constituency no: ");
                    int cn = a.nextInt();
                    System.out.println("Enter constituency name: ");
                    String cname = b.nextLine();
                    m.add(new MLA(n, cname, cn, "MLA Member"));
                    break;

                case 2:
                    System.out.println("Enter constituency number of member to delete: ");
                    int no = a.nextInt();
                    m.removeIf(e -> e.getConstNo() == no);
                    System.out.println("Member removed.");
                    break;

                case 3:
                    System.out.println("Enter constituency number to update: ");
                    int no2 = a.nextInt();
                    for (ListIterator<LegislativeMember> j2 = m.listIterator(); j2.hasNext(); ) {
                        LegislativeMember e = j2.next();
                        if (e.getConstNo() == no2) {
                            System.out.println("Enter correct name: ");
                            n = b.nextLine();
                            System.out.println("Enter correct constituency no: ");
                            cn = a.nextInt();
                            System.out.println("Enter correct constituency name: ");
                            cname = b.nextLine();
                            j2.set(new MLA(n, cname, cn, "MLA Member"));
                        }
                    }
                    System.out.println("Updated successfully.");
                    break;

                case 4:
                    System.out.println("-----Exiting-------");
                    break;

                default:
                    System.out.println("Please enter a valid choice.");
                    break;
            }
        } while (a1 != 4);
    }

    public static void Government() {
        Scanner scanner2 = new Scanner(System.in);
        int choice2;
        do {
            System.out.println("\nThe Government");
            System.out.println("1. Governor");
            System.out.println("2. Chief Ministerr");
            System.out.println("3. Council Of Ministers");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice2 = scanner2.nextInt();
            System.out.println("\n");

            switch (choice2) {
                case 1:
                    System.out.println("----- The Governor-----");
                    System.out.println("Shri. P. S. Sreedharan Pillai");
                    break;

                case 2:
                    System.out.println("\n----- The Chief Minister-----");
                    for (LegislativeMember e : m) {
                        if (e instanceof ChiefMinister) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 3:
                    System.out.println("----- The Cabinet Ministers-----");
                    for (LegislativeMember e : m) {
                        if (e instanceof CabinetMinister || e instanceof ChiefMinister) {
                            System.out.println(e);
                        }
                    }
                    break;
                    
                case 4:
                    System.out.println("-----Exiting-------");

                    break;

                default:
                    System.out.println("please enter valid choice");
                    break;
            }



        }while(choice2 != 4);


    }

    public static void Legislature() {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("GOA LEGISLATURE");
            System.out.println("1. The Speaker");
            System.out.println("2. Deputy Speaker");
            System.out.println("3. Opposition Leader");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.println("\n");
            
            switch (choice) {
                case 1:
                    System.out.println("----- The Speaker-----");
                    for (LegislativeMember e : m) {
                        if (e instanceof Speaker ) {
                            System.out.println(e);
                        }
                    }
                    break;
            
                    case 2:
                    System.out.println("----- The Deputy Speaker-----");
                    for (LegislativeMember e : m) {
                        if (e.getPosition().equals("Deputy Speaker")) {
                            System.out.println(e);
                        }
                    }
                    break;

                    case 3:
                    System.out.println("----- The Leader of Opposition-----");
                    for (LegislativeMember e : m) {
                        if (e.getPosition().equals("Opposition Leader")) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 4:
                    System.out.println("-----Exiting-------");
                    break;
                default:
                    System.out.println("please enter valid choice");
                    System.out.println("---------------------------\n");
                    break;
            }
    
        }while(choice != 4);




       
    }
}
