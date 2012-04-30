package CS225FinalProject.DataStructure;

import java.io.Serializable;
import java.util.HashMap;

/**
 */
public class Session implements Serializable {
    /**
     */
    private String sessionName;

    /**
     */
    private HashMap<String,StudentRecord> studentRecords;

    /**
     * @return 
     */
    public String getSessionName() {
        return sessionName;
    }

    /**
     */
    public StudentRecord[] getStudentRecordList() {
        return (StudentRecord[])studentRecords.values().toArray();
    }

    /**
     * @param studentName 
     * @return 
     */
    public StudentRecord getStudentRecord(String studentUserName) {
        return studentRecords.get(studentUserName);
    }

    /**
     * @param studentRecord 
     */
    public void addStudentRecord(StudentRecord studentRecord) {
        if(studentRecord!=null)
             studentRecords.put(studentRecord.getUserName(), studentRecord);
    }

    /**
     * @param studentName 
     * @return 
     */
    public boolean removeStudent(String studentName) {
        return (studentRecords.remove(studentName)!=null?true:false);
    }
    
    public boolean validateStudentLogin(String userName, String password){
        StudentRecord record = studentRecords.get(userName);
        if(studentRecords.get(userName)==null)
            return false;
        else
            return record.validateStudentLogin(userName, password);
    }
}

