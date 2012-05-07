/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CS225FinalProject.GUI;

import CS225FinalProject.DataStructure.Scenario;
import CS225FinalProject.SimulationManager;
import CS225FinalProject.DataStructure.SimulationController;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * 
 * @author Eric
 */
public class ScenarioSelectionGUI extends javax.swing.JFrame {

	private SimulationController controller = SimulationController
			.getInstance();

	private int scenarioIterator = 0;

	/**
	 * Creates new form ScenarioSelectionGUI
	 */
	public ScenarioSelectionGUI(SimulationManager manager) {
		initComponents();
		setTitle("Scenario Selection");
		summarySetter.setText("");

		setLocation((getToolkit().getScreenSize().width - getWidth()) / 2,
				(getToolkit().getScreenSize().height - getHeight()) / 2);

		setAlwaysOnTop(true);
		setSelectedScenarioInfo();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nextButton = new javax.swing.JButton();
        previosButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        scenarioDescriptionScrollPanel = new javax.swing.JScrollPane();
        scenarioDescriptionPanel = new javax.swing.JPanel();
        patientNameLabel = new javax.swing.JLabel();
        patientNameSetter = new javax.swing.JLabel();
        scenarioSummaryLabel = new javax.swing.JLabel();
        summarySetter = new javax.swing.JLabel();
        currentTimeLabel = new javax.swing.JLabel();
        timeSetter = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Scenario Selection");
        setAlwaysOnTop(true);
        setResizable(false);

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        previosButton.setText("Previous");
        previosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previosButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titleLabel.setText("Select Scenenario");

        scenarioDescriptionPanel.setBackground(new java.awt.Color(200, 200, 200));

        patientNameLabel.setText("Patient Name:");

        patientNameSetter.setText("name");

        scenarioSummaryLabel.setText("Scenario Summary:");

        summarySetter.setText("summary");

        currentTimeLabel.setText("Time:");

        timeSetter.setText("5:00PM");

        javax.swing.GroupLayout scenarioDescriptionPanelLayout = new javax.swing.GroupLayout(scenarioDescriptionPanel);
        scenarioDescriptionPanel.setLayout(scenarioDescriptionPanelLayout);
        scenarioDescriptionPanelLayout.setHorizontalGroup(
            scenarioDescriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scenarioDescriptionPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(scenarioDescriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(summarySetter)
                    .addGroup(scenarioDescriptionPanelLayout.createSequentialGroup()
                        .addComponent(currentTimeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeSetter))
                    .addGroup(scenarioDescriptionPanelLayout.createSequentialGroup()
                        .addComponent(patientNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(patientNameSetter))
                    .addComponent(scenarioSummaryLabel))
                .addContainerGap(396, Short.MAX_VALUE))
        );
        scenarioDescriptionPanelLayout.setVerticalGroup(
            scenarioDescriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scenarioDescriptionPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(scenarioDescriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientNameLabel)
                    .addComponent(patientNameSetter))
                .addGap(7, 7, 7)
                .addGroup(scenarioDescriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentTimeLabel)
                    .addComponent(timeSetter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scenarioSummaryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(summarySetter)
                .addContainerGap(253, Short.MAX_VALUE))
        );

        scenarioDescriptionScrollPanel.setViewportView(scenarioDescriptionPanel);

        startButton.setBackground(new java.awt.Color(0, 204, 0));
        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        logOutButton.setBackground(new java.awt.Color(255, 0, 0));
        logOutButton.setText("Logout");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(192, 192, 192))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(previosButton)
                        .addGap(18, 18, 18)
                        .addComponent(scenarioDescriptionScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(logOutButton)
                        .addGap(221, 221, 221)
                        .addComponent(startButton)))
                .addGap(18, 18, 18)
                .addComponent(nextButton)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scenarioDescriptionScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startButton)
                            .addComponent(logOutButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(previosButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(nextButton)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void setSelectedScenarioInfo() {
		ArrayList<Scenario> scenarios = controller.getScenarios();
		patientNameSetter.setText(scenarios.get(scenarioIterator)
				.getPatientName());

		summarySetter.setText(scenarios.get(scenarioIterator).getSummary());
		// timeSetter.setText(scenarios.get(scenarioIterator).get);
		SimulationManager.CURRENT_SCENARIO = scenarios.get(scenarioIterator);

	}

	private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (JOptionPane.showConfirmDialog(this,
				"Are You Sure You want to Log out?", null,
				JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
			// System.exit(0);
			controller.writeClassNames();
			controller.writeScenarios();
			controller.writeUsers();

			SimulationManager.state = SimulationManager.LOGIN_STATE;
		}
	}

	private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {

		SimulationManager.state = SimulationManager.SIMULATION_STATE;
	}

	private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if (controller.getScenarios().size() == scenarioIterator + 1)
			scenarioIterator = 0;
		else
			scenarioIterator++;
		setSelectedScenarioInfo();
	}

	private void previosButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:

		if (-1 == scenarioIterator - 1)
			scenarioIterator = controller.getScenarios().size() - 1;
		else
			scenarioIterator--;
		setSelectedScenarioInfo();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/*
		 * Set the Nimbus look and feel
		 */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(
					ScenarioSelectionGUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(
					ScenarioSelectionGUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(
					ScenarioSelectionGUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(
					ScenarioSelectionGUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new ScenarioSelectionGUI(new SimulationManager())
						.setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currentTimeLabel;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel patientNameLabel;
    private javax.swing.JLabel patientNameSetter;
    private javax.swing.JButton previosButton;
    private javax.swing.JPanel scenarioDescriptionPanel;
    private javax.swing.JScrollPane scenarioDescriptionScrollPanel;
    private javax.swing.JLabel scenarioSummaryLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel summarySetter;
    private javax.swing.JLabel timeSetter;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
