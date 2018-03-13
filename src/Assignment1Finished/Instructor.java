package Assignment1Finished;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author Keon Muellerchen
 */
public class Instructor {
    //declare instance variable
    private String firstName, lastName, streetAddress, city, postalCode;
    private int employeeNum;
    private LocalDate hireDate; 
    private LocalDate dateOfBirth; 
    private ArrayList<String> courses = new ArrayList<>();
    
    /**
     * This is the constructor, it will set all the instance variables to have a value.
     */
    public Instructor (String firstName, String lastName, String streetAddress, String city, String postalCode, LocalDate hireDate, LocalDate dateOfBirth, int employeeNum) {
        setFirstName(firstName);
        setLastName(lastName);
        setStreetAddress(streetAddress);
        setCity(city);
        setPostalCode(postalCode);
        setHireDate(hireDate);
        setBirthday(dateOfBirth);
        setEmployeeNum(employeeNum);
    }//end of constructor

    
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
    public int getEmployeeNum() {
        return employeeNum;
    }//end

    /**
     * Employee number must be a positive number, throws IllegalArgumentException if not.
     * @param employeeNum 
     */
    public void setEmployeeNum(int employeeNum) {
        if (employeeNum > 0)
            this.employeeNum = employeeNum;
       else
           throw new IllegalArgumentException("Please Enter valid employee number!");
    }//end

  
    public LocalDate getHireDate() {
        return hireDate;
    }//end

    /**
     * This method validates that the hire date is no more than 1 month in the future.  
     * If it is, it throws an IllegalArgumentException.
     * @param hireDate 
     */
    public void setHireDate(LocalDate hireDate) {
        LocalDate today = LocalDate.now();
        LocalDate oneMonthAhead = today.plusMonths(1);
        
        if (hireDate.isAfter(oneMonthAhead))
            throw new IllegalArgumentException("You cant be hired in the future!");         
        else
            this.hireDate = hireDate;
    }//end

    
    public LocalDate getBirthday() {
        return dateOfBirth;
    }//end

    /**
     * Validate the teacher is less than 90 years old. If the birthday does not appear to be valid, it should throw 
     * an IllegalArgumentException.
     * @param dateOfBirth 
     */
    public void setBirthday(LocalDate dateOfBirth) {
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        
        if (age>90)
            throw new IllegalArgumentException("You must be less then a 90 years old to teach, sorry.");
        else
            this.dateOfBirth = dateOfBirth;         
    }//end
    
    
    /**
     * Returns the year the instructor was born.
     * @return 
     */
    public int getYearBorn() {
        return dateOfBirth.getYear();
    }//end
    
    public void setYearBorn(LocalDate dateOfBirth) {   
        this.dateOfBirth = dateOfBirth;
    }//end
    
    
    /**
     * Returns the current age of the instructor.
     * @return 
     */
    public int getAgeInYears() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }//end

    public void setAgeInYears(LocalDate dateOfBirth) {     
        this.dateOfBirth = dateOfBirth;
    }//end
    

    /**
     * Return the number of years the instructor worked at the college.
     * @return 
     */
    public int getYearsAtCollege() {
        return Period.between(hireDate, LocalDate.now()).getYears();
    }//end

    public void setYearsAtCollege(LocalDate dateHired) {     
        this.hireDate = dateHired;
    }//end

    
    /**
     * This method accepts a course code as a String and adds it to the list of teachable subjects in UPPERCASE.
     * If the course code is empty, it should throw an IllegalArgumentException.
     */
    public void addCourseToAbilities(String courseCode) {
        if(courseCode.isEmpty())
            throw new IllegalArgumentException("Course code should not be empty!");
        else    
            courses.add(courseCode.toUpperCase());
            
    }//end
    
    
    /**
     * This method should accept a String with a course code in it. If the course code is in the list of courses an 
     * Instructor can teach, it should return true, false otherwise.
     * @return 
     */
    public Boolean canTeach(String courseCode) {
        return courses.contains(courseCode);
    }//end
    

    /**
     * This returns a String with all the course codes an Instructor is certified to teach.  The course codes should be 
     * separated by a comma but should not include [ ] at either end of the String.
     * @return 
     */
    public String listOfSubjectsCertifiedToTeach() {
        return (courses.toString().replace("[","").replace("]",""));
    }//end
    
    
    /**
     * Returns firstName and lastName.
     * @return firstName, lastName
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }//end
}
