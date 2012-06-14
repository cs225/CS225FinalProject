package CS225FinalProject;

import CS225FinalProject.DataStructure.PatientRecord;
import CS225FinalProject.DataStructure.Scenario;
import CS225FinalProject.DataStructure.User;
import CS225FinalProject.GUI.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * The main class that manages everything for student version
 * 
 * @author Eric Santana
 */
public class SimulationPracticeManager {

	public static int state;
	final public static int SCENARIO_STATE = 1;
	final public static int SIMULATION_STATE = 2;
	final public static int EXIT_STATE = -1;
        
        public static Scenario  CURRENT_SCENARIO;  
        public static ArrayList<Scenario> SCENARIOS;
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(SimulationGUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(SimulationGUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(SimulationGUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(SimulationGUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}

                JOptionPane.showMessageDialog(null, "Welcome to the Practice version of Massbay eMAR. You may load scenarios from a file.");
                 
                 
                 SimulationPracticeManager.SCENARIOS = new ArrayList<Scenario>();
                 SimulationPracticeManager.SCENARIOS.add(
                         new Scenario(
                         "Sample to load",
                         "If you have a file to load scenarios from, click Load ",
                         new PatientRecord("Sample"), 
                         10));
                 SimulationPracticeManager.SCENARIOS.get(0).setTime(0);
                 SimulationPracticeManager.CURRENT_SCENARIO = SimulationPracticeManager.SCENARIOS.get(0);
                
                 //needs fixing
		SimulationPracticeGUI mainGUI = new SimulationPracticeGUI(null);
		ScenarioPracticeSelectionGUI scenarioSelectionGUIPrototype = new ScenarioPracticeSelectionGUI(
				null);

               
                
		SimulationPracticeManager.state = SCENARIO_STATE;
		while (SimulationPracticeManager.state != EXIT_STATE) {
                    if(SimulationPracticeManager.state == SIMULATION_STATE && !mainGUI.isVisible()){
                        scenarioSelectionGUIPrototype.setVisible(false);
                        mainGUI.setVisible(true);
                        
                    }
                    if(SimulationPracticeManager.state == SCENARIO_STATE && !scenarioSelectionGUIPrototype.isVisible()){
                        mainGUI.setVisible(false);
                        scenarioSelectionGUIPrototype.setVisible(true);
                        
                    }
                    
                    try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				Logger.getLogger(SimulationPracticeManager.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		System.exit(0);
	}
}
