public class addressBookExtended {
    public static void main(String[] args) {
        // Task 6: Create more objects and test the methods
        Person p1 = new Person("Dani", 17,"d.vangelov26@acsbg.org","0876543219");
        p1.print();
        Person p2 = new Person("Hannah", 18, "hannah@gmail.com", "404-899-9955");
        p2.print();
        // Task 8: Test the updateEmail method
        p1.updateEmail("dani@gmail.com");
        p1.print();
    }
}

// Define the Person class here
class Person {
    // Instance variables
    private String name;
    private String email;
    private String phoneNumber;
    private int age;

    // Task 1: Add a new attribute (e.g., age)

    // Constructor: Initialize Person data
    public Person(String initName, int initage, String initEmail, String initPhone) { // Task 2: modify method signature to include your new attribute.
        name = initName;
        email = initEmail;
        phoneNumber = initPhone;
        age = initage;
        // Task 3: Assign a default value to the new attribute here.
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println(" ");

        // Task 4: Print the new attribute here
    }

    // Task 5: Add getter methods to access and return each attribute individually. Here's an example:
    public String getName() {
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Task 7: Add a method to update the email
    public void updateEmail(String newEmail) {
        email = newEmail;
    }
}
