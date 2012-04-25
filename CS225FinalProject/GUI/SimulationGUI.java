package CS225FinalProject.GUI;

//basically you can use data 
//object to access SimulationDataStructure
// for example data.validateLogIn() right away without initialize;
import CS225FinalProject.DataStructure.StudentRecord;
import CS225FinalProject.SimulationManager;
import static CS225FinalProject.SimulationManager.*;
import javax.swing.JFrame;
/**
 */
public class SimulationGUI extends JFrame{
    public StudentRecord currentStudentRecord;
    public SimulationGUI() {
    }
    
    @Override
    public void setVisible(boolean b){
        super.setVisible(b);
        if(b)
            currentStudentRecord = SimulationManager.currentStudentRecord;//sample of instant access
        
    }
    
    
}

