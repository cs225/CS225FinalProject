package CS225FinalProject.DataStructure;

import java.io.Serializable;
import java.util.*;
import java.lang.*;
import javax.swing.JTable;

/**
 * the narratives that student sees for the patient previous record.
 */
public class Narrative  implements Serializable{
    /**
     */
    private String date ;

    /**
     */
    private String time ;

    /**
     */
    private String narrative;

    /**
     */
    private String followUP ;

    /**
     */
    private String initials;

    public Narrative(String date, String time, String narrative, String followUP, String initials) {
        this.date = date;
        this.time = time;
        this.narrative = narrative;
        this.followUP = followUP;
        this.initials = initials;
    }
    
    

    /**
     * @return 
     */
    public String getDate() {
        return null;
    }

    /**
     * @param date 
     */
    public void setDate(String date) {
    }

    /**
     * @return 
     */
    public String getTime() {
        return null;
    }

    /**
     * @param time 
     */
    public void setTime(String time) {
    }

    /**
     * @return 
     */
    public String getNarrative() {
        return null;
    }

    /**
     * @param narrative 
     */
    public void setNarrative(String narrative) {
    }

    /**
     * @return 
     */
    public String getFollowUP() {
        return null;
    }

    /**
     * @param followUP 
     */
    public void setFollowUP(String followUP) {
    }

    /**
     * @return 
     */
    public String getInitials() {
        return null;
    }

    /**
     * @param initials 
     */
    public void setInitials(String initials) {
    }
}

