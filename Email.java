import java.util.Scanner;

/**
 * Generates email address and password for a new employee.
 */
public class Email {

    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private int defaultPasswordLength = 13;
    private String email;
    private int mailCapacity = 400;
    private String alternateEmail;
    private String comppanySuffix = "genericcompany.com";

    /**
     * Instantiates a new Email.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println(firstName + " " + lastName);

        this.department = setDepartment();
        System.out.println("Department is " + this.department);

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is " + this.password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase()+"@" + department + "." + comppanySuffix;
        System.out.println("Your email is "+ email);
    }


    private String setDepartment(){
        System.out.println("Enter department code:\n1 for Sales \n2 for Development\n3 for Accounting\n0 for none");

        Scanner sc = new Scanner(System.in);
        int departmentChoice = sc.nextInt();

        if (departmentChoice == 1){
            return "sales";
        }else if(departmentChoice ==2){
            return "Development";
        }else if(departmentChoice == 3){
            return "Accounting";
        }else return "";

    }


    private String randomPassword(int length){
        String passwordSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#%.&";

        char [] password = new char[length];

        for (int i = 0; i < length; i++){
            int random =  (int) (Math.random() * passwordSet.length());
            password[i]  = passwordSet.charAt(random);
        }
        return new String(password);
    }

    /**
     * Set mailbox capacity.
     *
     * @param capacity the capacity
     */
    public void setMailboxCapacity(int capacity){
        this.mailCapacity = capacity;
    }

    /**
     * Set alternate email.
     *
     * @param alternateEmail the alternate email
     */
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;

    }

    /**
     * Change password.
     *
     * @param password the password
     */
    public void changePassword(String password){
        this.password = password;
    }

    /**
     * Get mail capacity int.
     *
     * @return the int
     */
    public int getMailCapacity(){
        return mailCapacity;
    }

    /**
     * Get alternate email string.
     *
     * @return the string
     */
    public String getAlternateEmail(){
        return alternateEmail;
    }

    /**
     * Get password string.
     *
     * @return the string
     */
    public String getPassword(){
        return password;
    }

    /**
     * Show info string.
     *
     * @return the string
     */
    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailCapacity + "mb";
    }

}
