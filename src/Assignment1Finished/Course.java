package Assignment1Finished;

import java.util.ArrayList;

/**
 *
 * @author Keon Muellerchen
 */
public class Course {
    //declare instance variable
    private Instructor instructor;
    private String courseName, room;
    public String courseCode;
    private int maxStudents;
    private ArrayList<Student> studentsZ = new ArrayList<>();
    
    /**
     * This is the constructor, it will set all the instance variables to have a value.
     */
    public Course (Instructor instructor, String courseCode, String courseName, String room, int maxStudents) {
        setCourseCode(courseCode);
        setCourseName(courseName);
        setRoom(room);
        setMaxStudents(maxStudents);
        setInstructor(instructor);
    }//end

    public Instructor getInstructor() {
        return instructor;
    }//end

    /**
     * This method accepts an Instructor as an argument. 
     * If the course code is within the Instructors teachable subjects, set the Instructor otherwise throw an IllegalArgumentException.
     * @param instructor 
     */
    public void setInstructor(Instructor instructor) {
        if(instructor.listOfSubjectsCertifiedToTeach().contains(courseCode))
            this.instructor = instructor;
        else
            throw new IllegalArgumentException("The Instructor is not qualified to teach this course!");
    }//end


    public String getCourseCode() {
        return courseCode;
    }//end

    /**
     * Method validates to ensure they are not empty.  If they are empty, throw an IllegalArgumentException otherwise set the
     * instance variable.
     * @param courseCode 
     */
    public void setCourseCode(String courseCode) {
        if(courseCode.isEmpty())
            throw new IllegalArgumentException("Must enter a course Code!");
        else    
            this.courseCode = courseCode;
    }//end

    
    public String getCourseName() {
        return courseName;
    }//end

    /**
     * Method validates to ensure they are not empty.  If they are empty, throw an IllegalArgumentException 
     * set the instance variable.
     * @param courseName 
     */
    public void setCourseName(String courseName) {
        if(courseName.isEmpty())
            throw new IllegalArgumentException("Must enter a course name!");
        else    
            this.courseName = courseName;
    }//end
    
    
    public String getRoom() {
        return room;
    }//end

    /**
     * Method validates to ensure they are not empty.  If they are empty, throw an IllegalArgumentException 
     * otherwise set the instance variable.
     * @param room 
     */
    public void setRoom(String room) {
        if(room.isEmpty())
            throw new IllegalArgumentException("Must enter a course room!");
        else    
            this.room = room;
    }//end

    
    public int getMaxStudents() {
        return maxStudents;
    }//end

    /**
     * The argument should be validated to be less than or equal to 45 and above 0.  If the number is outside that range, 
     * an IllegalArgumentException should be thrown otherwise the instance variable should be set.
     * @param maxStudents
     */
    public void setMaxStudents(int maxStudents) {
        if(maxStudents > 0 && maxStudents <= 45)
            this.maxStudents = maxStudents;
        else
            throw new IllegalArgumentException("Not enough students or too much students.");
    }//end
    
    
     /**
     * This method will print the names of each student registered in the class to the screen. There should be 1 student per line.
     * @return 
     */
    public String showClassList(Student validStudent) {
        return validStudent.getFirstName();
    }//end of showClassList
    
    
    /**
     * Accepts a Student as an argument. It should check if the student is currently in good standing AND if there is 
     * space in the class. If a student cannot be added, it should throw an exception.
     * @return 
     */
    public void addStudent(Student student){
        
        if (student.isInGoodStanding() == true) {
            //if(getMaxStudents() < 45)   
            if(studentsZ.size() < getMaxStudents())
                studentsZ.add(student);
            else
                throw new IllegalArgumentException("There is not enough space in the course!");
        }//end of if
        else
            throw new IllegalArgumentException("The student is not in good standing!");       
    }//end of addStudent
    
       
    /**
     * Returns an ArrayList of Student objects enrolled in the course.
     * @return 
     */
    public ArrayList getStudents() {
        return studentsZ;
    }
    

    /**
     * Returns the course name and course code as a String.
     * @return
     */
    @Override
    public String toString() {
        return courseName + " " + courseCode;
    }//end    
}
