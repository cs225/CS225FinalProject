package CS225FinalProject;

import CS225FinalProject.DataStructure.Scenario;
import CS225FinalProject.DataStructure.User;
import CS225FinalProject.GUI.LoginGUI;
import CS225FinalProject.GUI.MaintenanceManagerGUI;
import CS225FinalProject.GUI.ScenarioSelectionGUI;
import CS225FinalProject.GUI.SimulationGUI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * The main class that manages everything
 * 
 * @author Eric Santana
 */
public class SimulationManager {

	public static int state;
	final public static int LOGIN_STATE = 0;
	final public static int SCENARIO_STATE = 1;
	final public static int SIMULATION_STATE = 2;
	final public static int MAINTENANCE_STATE = 3;
	final public static int EXIT_STATE = -1;
        
        public static Scenario  CURRENT_SCENARIO;

        public static User CURRENT_USER;
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

                
                 CURRENT_SCENARIO = new Scenario();
                
		SimulationManager manager = new SimulationManager();
		SimulationGUI mainGUI = new SimulationGUI(manager);
		LoginGUI loginDialog = new LoginGUI(null, true, manager);
		MaintenanceManagerGUI proffesorGUIPrototype = new MaintenanceManagerGUI();
		proffesorGUIPrototype.setVisible(false);
		ScenarioSelectionGUI scenarioSelectionGUIPrototype = new ScenarioSelectionGUI(
				manager);

               
                
		SimulationManager.state = LOGIN_STATE;
		while (SimulationManager.state != EXIT_STATE) {
			if (SimulationManager.state == LOGIN_STATE
					&& scenarioSelectionGUIPrototype.isVisible()
					|| (SimulationManager.state == LOGIN_STATE && mainGUI
							.isVisible())) {
				scenarioSelectionGUIPrototype.setVisible(false);
				mainGUI.setVisible(false);

				if (!loginDialog.isVisible()) {
					JOptionPane.showMessageDialog(loginDialog,
							"Welcome to Massbay General Hospital\n"
									+ "                   Please log in\n");
					loginDialog.setVisible(true);
				}

			} else if (SimulationManager.state == LOGIN_STATE) {
				if (!loginDialog.isVisible()) {
					JOptionPane.showMessageDialog(loginDialog,
							"Welcome to Massbay General Hospital\n"
									+ "                   Please log in");
					loginDialog.setVisible(true);
				}
				mainGUI.setVisible(false);
				scenarioSelectionGUIPrototype.setVisible(false);
				proffesorGUIPrototype.setVisible(false);

			} else if (SimulationManager.state == SCENARIO_STATE) {
				if (!scenarioSelectionGUIPrototype.isVisible())
					scenarioSelectionGUIPrototype.setVisible(true);
				mainGUI.setVisible(false);
				loginDialog.setVisible(false);
				proffesorGUIPrototype.setVisible(false);

			} else if (SimulationManager.state == SIMULATION_STATE) {
				if (!mainGUI.isVisible())
					mainGUI.setVisible(true);
				loginDialog.setVisible(false);
				proffesorGUIPrototype.setVisible(false);
				scenarioSelectionGUIPrototype.setVisible(false);

			} else if (SimulationManager.state == MAINTENANCE_STATE) {
				if (!proffesorGUIPrototype.isVisible())
					proffesorGUIPrototype.setVisible(true);
				mainGUI.setVisible(false);
				loginDialog.setVisible(false);
				scenarioSelectionGUIPrototype.setVisible(false);
			}

			else if ((!loginDialog.isVisible() && SimulationManager.state == LOGIN_STATE))
				SimulationManager.state = EXIT_STATE;

			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				Logger.getLogger(SimulationManager.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		System.exit(0);
	}
}
