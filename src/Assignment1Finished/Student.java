package Assignment1Finished;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Keon Muellerchen
 */
public class Student {
    //declare instance variable
    private String firstName, lastName, streetAddress, city, postalCode;
    private int studentNum;
    private LocalDate dateOfBirth; 
    private LocalDate dateEnrolled; 
    private boolean inGoodStanding;
    
    /**
     * This is the constructor, it will set all the instance variables to have a value.
     */
    public Student (String firstName, String lastName, String streetAddress, String city, String postalCode, LocalDate dateOfBirth, LocalDate dateEnrolled, int studentNum)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setStreetAddress(streetAddress);
        setCity(city);
        setPostalCode(postalCode);
        setDateOfBirth(dateOfBirth);
        setDateEnrolled(dateEnrolled); 
        setStudentNum(studentNum);   
        inGoodStanding = true;
    }//end

    /**
     * Returns the value of the instance variable.
     * @return 
     */
    public String getFirstName() {
        return firstName;
    }//end

    /**
     * Validates that the argument firstName is not empty, throws an IllegalArgumentException if it is.
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        if(firstName.isEmpty())
            throw new IllegalArgumentException("Must enter a first name!");
        else    
            this.firstName = firstName;
    }//end

    
    /**
     * Returns the value of the instance variable.
     * @return 
     */
    public String getLastName() {
        return lastName;
    }//end

    /**
     * Validates that the argument lastName is not empty, throws an IllegalArgumentException if it is.
     * @param lastName 
     */
    public void setLastName(String lastName) {
        if(lastName.isEmpty())
            throw new IllegalArgumentException("Must enter a last name!");
        else    
            this.lastName = lastName;
    }//end

    
    /**
     * Returns the value of the instance variable.
     * @return 
     */
    public String getStreetAddress() {
        return streetAddress;
    }//end

    /**
     * Validates that the argument streetAddress is not empty, throws an IllegalArgumentException if it is.
     * @param streetAddress 
     */
    public void setStreetAddress(String streetAddress) {
        if(streetAddress.isEmpty())
            throw new IllegalArgumentException("Must enter a street address!");
        else    
            this.streetAddress = streetAddress;
    }//end

    
    /**
     * Returns the value of the instance variable.
     * @return 
     */
    public String getCity() {
        return city;
    }//end

    /**
     * Validates that the argument city is not empty, throws an IllegalArgumentException if it is.
     * @param city 
     */
    public void setCity(String city) {
        if(city.isEmpty())
            throw new IllegalArgumentException("Must enter a city!");
        else    
            this.city = city;
    }//end

    
    /**
     * Returns the value of the instance variable.
     * @return 
     */
    public String getPostalCode() {
        return postalCode;
    }//end

    /**
     * Validates that the argument postalCode is not empty, throws an IllegalArgumentException if it is.
     * @param postalCode 
     */
    public void setPostalCode(String postalCode) {
        if(postalCode.isEmpty() )
            throw new IllegalArgumentException("Must enter a postalCode!");
        else    
            this.postalCode = postalCode;
    }//end

    
    /**
     * Returns the value of the instance variable.
     * @return 
     */
    public int getStudentNum() {
        return studentNum;
    }//end

    /**
     * Student number must be a positive number, throws IllegalArgumentException if not.
     * @param studentNum 
     */
    public void setStudentNum(int studentNum) {
       if (studentNum > 0)
            this.studentNum = studentNum;
       else
           throw new IllegalArgumentException("Please Enter valid student number!");
    }//end

    
    /**
     * Returns the value of the instance variable.
     * @return 
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }//end

    /**
     * Validate the person is less than 100 years old. If the birthday does not appear to be valid, it should throw 
     * an IllegalArgumentException.
     * @param dateOfBirth 
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        
        if (age>100)
            throw new IllegalArgumentException("You must be less then a 100 years old to enroll, sorry.");
        else
            this.dateOfBirth = dateOfBirth;         
    }//end

    
    /**
     * Returns the value of the instance variable.
     * @return 
     */
    public LocalDate getDateEnrolled() {
        return dateEnrolled;
    }//end

    /**
     * This method should validate that the student was not enrolled in the future (i.e. the enrollment date should be prior 
     * to the current date). If it is not a valid enrollment date it will throw an IllegalArgumentException.
     * @param dateEnrolled 
     */
    public void setDateEnrolled(LocalDate dateEnrolled) {    
        LocalDate today = LocalDate.now();
        
        if (dateEnrolled.isAfter(today) || dateEnrolled.isEqual(today))
            throw new IllegalArgumentException("Enrollment date should be prior to the current date!");
        else
            this.dateEnrolled = dateEnrolled;
    }//end
    
    
    /**
     * Returns the year the student enrolled at the college.
     * @return 
     */
    public int getYearEnrolled() {
        return dateEnrolled.getYear();
    }//end
    
    /**
     * Assign a value to dateEnrolled.
     * @param dateEnrolled 
     */
    public void setYearEnrolled(LocalDate dateEnrolled) {
        this .dateEnrolled = dateEnrolled;
    }//end   
   
    
    /**
     * Returns the current age of the student.
     * @return 
     */
    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }//end

    /**
     * Assign a value to dateOfBirth.
     * @param dateOfBirth 
     */
    public void setAge(LocalDate dateOfBirth) {     
        this.dateOfBirth = dateOfBirth;
    }//end
    
    
    /**
     * Returns the year the Student was born.
     * @return 
     */
    public int getYearBorn() {
        return dateOfBirth.getYear();
    }//end
    
    /**
     *  Assign a value to dateOfBirth.
     * @param dateOfBirth 
     */
    public void setYearBorn(LocalDate dateOfBirth) {   
        this.dateOfBirth = dateOfBirth;
    }//end
    
    
    /**
     * Returns true if the student is in good standing or false if they are in bad standing.
     * @return 
     */
    public boolean isInGoodStanding() {
        return inGoodStanding;
    }//end

    /**
     * Assign a value to inGoodStanding.
     * @param inGoodStanding 
     */
    public void setInGoodStanding(boolean inGoodStanding) {        
        this.inGoodStanding = inGoodStanding;
    }//end
    
    
    /**
     * suspendStudnt method will set inGoodStanding to False.
     * @return 
     */
    public boolean suspendStudent() {       
        return inGoodStanding = false;
    }//end
    
    
    /**
     * reinstateStudent method will set inGoodStanding to True.
     * @return 
     */
    public boolean reinstateStudent() {
        return inGoodStanding = true;
    }//end
        
    
    /**
     * Returns firstName, lastName, and studentNum.
     * @return firstName, lastName, studentNum
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + ", student number: " + studentNum;
    }//end

}
