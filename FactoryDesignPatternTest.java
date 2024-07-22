import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private String id;
    private String city;
    private int age;
    private String modeOfContact;
    private String email;
    private String phoneNumber;

    public Employee(String name, String id, String city, int age, String modeOfContact, String email, String phoneNumber) {
        this.name = name;
        this.id = id;
        this.city = city;
        this.age = age;
        this.modeOfContact = modeOfContact;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getModeOfContact() {
        return modeOfContact;
    }
}

interface Communication {
    void process(Employee emp);
}

class EmailCommunication implements Communication {
    public void process(Employee emp) {
        System.out.println(emp.getName() + " Communicated via email: " + emp.getEmail());
    }
}

class MobileCommunication implements Communication {
    public void process(Employee emp) {
        System.out.println(emp.getName() + " Communicated via mobile number: " + emp.getPhoneNumber());
    }
}

class Factory {
    public Communication getProcess(String modeOfComm) {
        if ("email".equalsIgnoreCase(modeOfComm)) {
            return new EmailCommunication();
        } else if ("mobile".equalsIgnoreCase(modeOfComm)) {
            return new MobileCommunication();
        }
        return null;
    }
}

public class FactoryDesignPatternTest {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();

        Employee e1 = new Employee("Siddarth", "1", "Pune", 23, "email", "sidducit012@gmail.com", "8825639190");
        Employee e2 = new Employee("Anush", "2", "Pune", 25, "mobile", "thakur@sholay.com", "7854120302");

        empList.add(e1);
        empList.add(e2);

        Factory factory = new Factory();
        
        for (Employee emp : empList) {
            Communication communication = factory.getProcess(emp.getModeOfContact());
            if (communication != null) {
                communication.process(emp);
            } else {
                System.out.println("No communication mode found for: " + emp.getName());
            }
        }
        
    }
}
