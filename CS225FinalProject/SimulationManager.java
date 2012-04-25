package CS225FinalProject;


import CS225FinalProject.DataStructure.Medication;
import CS225FinalProject.DataStructure.SimulationDataStructure;
import CS225FinalProject.DataStructure.StudentRecord;
import CS225FinalProject.GUI.LoginGUI;
import CS225FinalProject.GUI.MaintenaceManagerGUI;
import CS225FinalProject.GUI.ScenarioSelectionGUI;
import CS225FinalProject.GUI.SimulationGUI;
import javax.swing.JOptionPane;



/**
 * The main class that manages everything 
 * @author Eric Santana
 */
public class SimulationManager {
    /**
     */
    public static SimulationDataStructure data;
    /**
     */
    public static StudentRecord currentStudentRecord;
    
       
    public static int state;
    public final static int LOGIN_STATE = 0;
    public final static int SCENARIO_STATE = 1;
    public final static int SIMULATION_STATE = 2;
    public final static int MAINTENANCE_STATE = 3;
    public final static int EXIT_STATE= -1;

    /**
     * @param args 
     */
    public static void main(String[] args) {
        
        //this just looks for the Nimbus GUI look
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
           
        } catch (InstantiationException ex) {
            
        } catch (IllegalAccessException ex) {
           
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            
        }
        
        //just testing the GUI Look
        int i = JOptionPane.showConfirmDialog(null, "testing");
        
        
        if(i!= JOptionPane.YES_OPTION)
            System.exit(0);
        
        state = LOGIN_STATE;
        SimulationManager.data = new SimulationDataStructure();
        
        LoginGUI loginDialog = new LoginGUI();
        SimulationGUI simulationGUI = new SimulationGUI();
        MaintenaceManagerGUI maintenaceManagerGUI = new MaintenaceManagerGUI();
        ScenarioSelectionGUI scenarioSelectionGUI = new ScenarioSelectionGUI();
        state = LOGIN_STATE;
        while(state!= EXIT_STATE){
            if(state== LOGIN_STATE && scenarioSelectionGUI.isVisible() || (state== LOGIN_STATE && simulationGUI.isVisible())){
                scenarioSelectionGUI.setVisible(false);
                simulationGUI.setVisible(false);
                if(!loginDialog.isVisible()){
                    JOptionPane.showMessageDialog(loginDialog,
                  "Welcome to Massbay General Hospital\n"
                + "Please Log in and follow the flow. ");
                    loginDialog.setVisible(true);
                }
            }
            else if(state==LOGIN_STATE){
                if(!loginDialog.isVisible()){
                    JOptionPane.showMessageDialog(loginDialog,
                  "Welcome to Massbay General Hospital\n"
                + "Please Log in and follow the flow. ");
                loginDialog.setVisible(true);
                }
                simulationGUI.setVisible(false);
                scenarioSelectionGUI.setVisible(false);
            }
            else if(state== SCENARIO_STATE){
               if(!scenarioSelectionGUI.isVisible())
                scenarioSelectionGUI.setVisible(true);
                simulationGUI.setVisible(false);
                loginDialog.setVisible(false);
            }
            else if(state == SIMULATION_STATE){
                if(!simulationGUI.isVisible())
                simulationGUI.setVisible(true);
                loginDialog.setVisible(false);
                scenarioSelectionGUI.setVisible(false);
            }
            else if(state == MAINTENANCE_STATE){
                maintenaceManagerGUI.setVisible(true);
                simulationGUI.setVisible(false);
                loginDialog.setVisible(false);
                scenarioSelectionGUI.setVisible(false);
                
            }
            
            
            else if((!loginDialog.isVisible()&& state==LOGIN_STATE))
                state=EXIT_STATE;
        }
        System.exit(0);
        
        
    }
}

