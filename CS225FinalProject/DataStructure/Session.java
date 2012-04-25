package CS225FinalProject.DataStructure;

import java.io.Serializable;
import java.lang.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTable;

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
        return null;
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
    public StudentRecord getStudentRecord(String studentName) {
        return studentRecords.get(studentName);
    }

    /**
     * @param studentRecord 
     */
    public void addStudentRecord(StudentRecord studentRecord) {
        if(studentRecord!=null)
             studentRecords.put(studentRecord.getStudentName(), studentRecord);
    }

    /**
     * @param studentName 
     * @return 
     */
    public boolean removeStudent(String studentName) {
        return (studentRecords.remove(studentName)!=null?true:false);
    }
}

