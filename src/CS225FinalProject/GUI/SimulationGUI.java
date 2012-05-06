/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CS225FinalProject.GUI;

import CS225FinalProject.DataStructure.*;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import CS225FinalProject.SimulationManager;
import CS225FinalProject.Validators.Evaluator;
import java.util.Arrays;

/**
 * 
 * @author Eric
 */
public class SimulationGUI extends javax.swing.JFrame implements Printable {

	public static int START_TIME = 15 * 60;

	int time;

	private SimulationController controller = SimulationController
			.getInstance();

	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		if (b) {
			rootTabbedPane.setSelectedIndex(0);
                        loadScenarioContents();
		}
                
	}
        private void loadScenarioContents(){
            
            START_TIME = SimulationManager.CURRENT_SCENARIO.getTime();
            Narrative[] narratives = new Narrative[SimulationManager.CURRENT_SCENARIO.getNarrativeList().size()];
            
            if(!SimulationManager.CURRENT_SCENARIO.getNarrativeList().isEmpty())
               SimulationManager.CURRENT_SCENARIO.getNarrativeList().toArray(narratives);
            
            
          //cleans up all narratives
            while(documentationTable.getRowCount()>0)
               ((DefaultTableModel) documentationTable.getModel()).removeRow(0);
     
          //loads the scenario narratives
            if(narratives.length!=0)
            for(Narrative narrative: narratives){
                ((DefaultTableModel) documentationTable.getModel()).addRow(narrative.getNarrativeAsArrayStrings());
            }
            //------------------------------------------------------------------------------------
            
            Medication[] medications = new Medication[SimulationManager.CURRENT_SCENARIO.getMedicationList().size()];
            //cleans up all medications
            while(marTable.getRowCount()>0)
               ((DefaultTableModel) marTable.getModel()).removeRow(0);
            if(!SimulationManager.CURRENT_SCENARIO.getMedicationList().isEmpty())
               SimulationManager.CURRENT_SCENARIO.getMedicationList().toArray(medications);
     
          //loads the medications
            if(medications.length!=0)
            for(Medication medication: medications){
                ((DefaultTableModel) marTable.getModel()).addRow(new String[]{
                medication.getMedicationName(),
                medication.getDosage(),
                medication.getRouteOfMedication(),
                medication.getMedicationDueTimes()}
                        );
            }
            
            patientNameLabel.setText(SimulationManager.CURRENT_SCENARIO.getPatientName());
            allergiesSetter.setText(SimulationManager.CURRENT_SCENARIO.getAllergies());
            diagnosisSetter.setText(SimulationManager.CURRENT_SCENARIO.getDiagnosis());
            roomNumSetter.setText(""+SimulationManager.CURRENT_SCENARIO.getRoom());
            
            
            
        }

	/**
	 * Creates new form PrototypeGUI2
	 */
	public SimulationGUI(SimulationManager manager) {
		initComponents();

		setLocation((getToolkit().getScreenSize().width - getWidth()) / 2,
				(getToolkit().getScreenSize().height - getHeight()) / 2);

		setAlwaysOnTop(true);
		ActionListener timerListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                                if(SimulationGUI.START_TIME ==0){
                                    time = 0xff;
                                    timeLabel.setText("No Time Limit");
                                }
                            
                                else if (time > 0 && isVisible()) {
					time--;
					timeLabel.setText(time
							/ 60
							+ ":"
							+ ((time - (time / 60) * 60) >= 10 ? ""
									+ (time - (time / 60) * 60) : "0"
									+ (time - (time / 60) * 60)));
				}
                                else if (time == 0 && isVisible()) {
					JOptionPane.showMessageDialog(rootPane, "TIME OVER!\n"
							+ "You will be logged off automatically");
					setVisible(false);
					SimulationManager.state = SimulationManager.LOGIN_STATE;
				}
				if (!isVisible()){
					time = SimulationGUI.START_TIME;
                                        
                                            
                                }

			}
		};
		Timer timer = new Timer(1000, timerListener);

		timer.start();
		((DefaultTableModel) documentationTable.getModel())
				.addRow(new Object[] { "12-12-12", "5:00PM",
						"SampleMultipleLines\n\n Eric S " });

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootTabbedPane = new javax.swing.JTabbedPane();
        jcaho_Panel = new javax.swing.JPanel();
        jcahoScrollPane = new javax.swing.JScrollPane();
        jcahoLabel = new javax.swing.JLabel();
        mar_Panel = new javax.swing.JPanel();
        roomNumberText = new javax.swing.JLabel();
        roomNumSetter = new javax.swing.JLabel();
        patientNameText = new javax.swing.JLabel();
        patientNameLabel = new javax.swing.JLabel();
        diagnosisText = new javax.swing.JLabel();
        diagnosisSetter = new javax.swing.JLabel();
        allergiesText = new javax.swing.JLabel();
        allergiesSetter = new javax.swing.JLabel();
        marScrollPane = new javax.swing.JScrollPane();
        marTable = new javax.swing.JTable();
        giveMedicationButton = new javax.swing.JButton();
        hourDueButton = new javax.swing.JButton();
        documentation_Panel = new javax.swing.JPanel();
        documentationScrollPane = new javax.swing.JScrollPane();
        documentationPane = new javax.swing.JPanel();
        docTabelHolder = new javax.swing.JScrollPane();
        documentationTable = new javax.swing.JTable();
        insertNewNarrativeButton = new javax.swing.JButton();
        viewSelectedNarrativeButton = new javax.swing.JButton();
        deleteNarrativeButton = new javax.swing.JButton();
        editNarrativeButton = new javax.swing.JButton();
        cancelSimulationButton = new javax.swing.JButton();
        timeLeftTextLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        printSampleButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Medical Administration Records");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        jcahoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/JAHCO.png"))); // NOI18N
        jcahoScrollPane.setViewportView(jcahoLabel);

        javax.swing.GroupLayout jcaho_PanelLayout = new javax.swing.GroupLayout(jcaho_Panel);
        jcaho_Panel.setLayout(jcaho_PanelLayout);
        jcaho_PanelLayout.setHorizontalGroup(
            jcaho_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcaho_PanelLayout.createSequentialGroup()
                .addGap(333, 333, 333)
                .addComponent(jcahoScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        jcaho_PanelLayout.setVerticalGroup(
            jcaho_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcaho_PanelLayout.createSequentialGroup()
                .addComponent(jcahoScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        rootTabbedPane.addTab("JCAHO", jcaho_Panel);

        roomNumberText.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        roomNumberText.setText("Room:");

        roomNumSetter.setText("number");

        patientNameText.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        patientNameText.setText("Name:");

        patientNameLabel.setText("patientName");

        diagnosisText.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        diagnosisText.setText("Diagnosis:");

        diagnosisSetter.setText("jLabel8");

        allergiesText.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        allergiesText.setText("Allergies:");

        allergiesSetter.setText("jLabel10");

        marTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Insulin", null, null, null},
                {"Morphine", null, null, null},
                {"Cocaine", null, null, null}
            },
            new String [] {
                "Medication", "Dose", "Route", "Hour Due"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        marTable.setRowHeight(45);
        marTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        marScrollPane.setViewportView(marTable);

        giveMedicationButton.setText("Give Medication");
        giveMedicationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giveMedicationButtonActionPerformed(evt);
            }
        });

        hourDueButton.setText("Hour Due Details");
        hourDueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourDueButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mar_PanelLayout = new javax.swing.GroupLayout(mar_Panel);
        mar_Panel.setLayout(mar_PanelLayout);
        mar_PanelLayout.setHorizontalGroup(
            mar_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mar_PanelLayout.createSequentialGroup()
                .addGroup(mar_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mar_PanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(mar_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mar_PanelLayout.createSequentialGroup()
                                .addComponent(diagnosisText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(diagnosisSetter))
                            .addGroup(mar_PanelLayout.createSequentialGroup()
                                .addComponent(patientNameText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(patientNameLabel)))
                        .addGap(123, 123, 123)
                        .addComponent(roomNumberText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomNumSetter)
                        .addGap(61, 61, 61)
                        .addComponent(allergiesText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(allergiesSetter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hourDueButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(giveMedicationButton))
                    .addGroup(mar_PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(marScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(1158, 1158, 1158))
        );
        mar_PanelLayout.setVerticalGroup(
            mar_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mar_PanelLayout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addGroup(mar_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientNameText)
                    .addComponent(patientNameLabel)
                    .addComponent(allergiesText)
                    .addComponent(roomNumberText)
                    .addComponent(roomNumSetter)
                    .addComponent(allergiesSetter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mar_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diagnosisText)
                    .addComponent(diagnosisSetter))
                .addContainerGap())
            .addGroup(mar_PanelLayout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addComponent(marScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mar_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giveMedicationButton)
                    .addComponent(hourDueButton))
                .addGap(232, 232, 232))
        );

        rootTabbedPane.addTab("MAR", mar_Panel);

        documentationPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        documentationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Narrative", "Follow Up", "Initialls"
            }
        ));
        documentationTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        documentationTable.setName("sample");
        documentationTable.getTableHeader().setReorderingAllowed(false);
        docTabelHolder.setViewportView(documentationTable);
        documentationTable.getColumnModel().getColumn(0).setMinWidth(60);
        documentationTable.getColumnModel().getColumn(0).setPreferredWidth(60);
        documentationTable.getColumnModel().getColumn(0).setMaxWidth(60);
        documentationTable.getColumnModel().getColumn(1).setMinWidth(90);
        documentationTable.getColumnModel().getColumn(1).setPreferredWidth(90);
        documentationTable.getColumnModel().getColumn(1).setMaxWidth(90);
        documentationTable.getColumnModel().getColumn(2).setResizable(false);
        documentationTable.getColumnModel().getColumn(2).setPreferredWidth(695);
        documentationTable.getColumnModel().getColumn(3).setMinWidth(80);
        documentationTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        documentationTable.getColumnModel().getColumn(3).setMaxWidth(80);
        documentationTable.getColumnModel().getColumn(4).setMinWidth(50);
        documentationTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        documentationTable.getColumnModel().getColumn(4).setMaxWidth(50);

        documentationPane.add(docTabelHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 985, 370));

        insertNewNarrativeButton.setText("Insert a new Narrative");
        insertNewNarrativeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertNewNarrativeButtonActionPerformed(evt);
            }
        });
        documentationPane.add(insertNewNarrativeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        viewSelectedNarrativeButton.setText("ViewSelectedNarrative");
        viewSelectedNarrativeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSelectedNarrativeButtonActionPerformed(evt);
            }
        });
        documentationPane.add(viewSelectedNarrativeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, -1, -1));

        deleteNarrativeButton.setText("Delete the Selected Narrative");
        deleteNarrativeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteNarrativeButtonActionPerformed(evt);
            }
        });
        documentationPane.add(deleteNarrativeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, -1, -1));

        editNarrativeButton.setText("Edit Selected Narrative");
        editNarrativeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editNarrativeButtonActionPerformed(evt);
            }
        });
        documentationPane.add(editNarrativeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, -1));

        documentationScrollPane.setViewportView(documentationPane);

        javax.swing.GroupLayout documentation_PanelLayout = new javax.swing.GroupLayout(documentation_Panel);
        documentation_Panel.setLayout(documentation_PanelLayout);
        documentation_PanelLayout.setHorizontalGroup(
            documentation_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(documentationScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
        );
        documentation_PanelLayout.setVerticalGroup(
            documentation_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(documentation_PanelLayout.createSequentialGroup()
                .addComponent(documentationScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addContainerGap())
        );

        rootTabbedPane.addTab("Documentation", documentation_Panel);

        cancelSimulationButton.setBackground(new java.awt.Color(204, 0, 0));
        cancelSimulationButton.setText("Cancel Simulation");
        cancelSimulationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelSimulationButtonActionPerformed(evt);
            }
        });

        timeLeftTextLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        timeLeftTextLabel.setText("Time Left:");

        timeLabel.setText("15:00");

        submitButton.setBackground(new java.awt.Color(0, 204, 0));
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        printSampleButton.setText("Print");
        printSampleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printSampleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(timeLeftTextLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeLabel)
                        .addGap(81, 915, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(cancelSimulationButton)
                        .addGap(223, 223, 223)
                        .addComponent(printSampleButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitButton)
                        .addGap(104, 104, 104))))
            .addComponent(rootTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rootTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timeLeftTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeLabel))
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(printSampleButton)
                            .addComponent(cancelSimulationButton)
                            .addComponent(submitButton))
                        .addGap(24, 24, 24))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void cancelSimulationButtonActionPerformed(ActionEvent evt){
            
        }
        private void deleteNarrativeButtonActionPerformed(Object evt){
    
}
        private void hourDueButtonActionPerformed(Object evt){
            
        }
	private void insertNewNarrativeButtonActionPerformed(
			java.awt.event.ActionEvent evt) {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		DateFormat dayFormat = new SimpleDateFormat("HH:mma");
		((DefaultTableModel) documentationTable.getModel())
				.addRow(new String[] {
						dateFormat.format(Calendar.getInstance(
								TimeZone.getDefault()).getTime()),
						dayFormat.format(Calendar.getInstance(
								TimeZone.getDefault()).getTime()),
						"Temperature:\nPulse:\n Resp:\n BP:\n O2 Sat:\n Pain Scale:\n FSBS:\n Site:\n Related Diagnosis/Reason for medication:\n" });
		// documentationTable.isfo
	}

	private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
            
            /*
             *this code is a prototype of recording a Completed scenario to a student(The one taking this test) 
             */
//		((Student)SimulationManager.CURRENT_USER).
//                        addCompletedScenario
//                        (new CompletedScenario(marTable, Evaluator.giveSuggestion(), SimulationManager.CURRENT_SCENARIO));
                setVisible(false);
		SimulationManager.state = SimulationManager.LOGIN_STATE;
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		setVisible(false);
		SimulationManager.state = SimulationManager.LOGIN_STATE;
	}

	private void viewSelectedNarrativeButtonActionPerformed(
			java.awt.event.ActionEvent evt) {

		if (documentationTable.getSelectedRow() < 0)
			JOptionPane.showMessageDialog(this, "Please Select a Narrative");
		else {
			JDialog t = new JDialog(this);
			t.setLocation(
					(t.getToolkit().getScreenSize().width - getWidth()) / 2,
					(t.getToolkit().getScreenSize().height - getHeight()) / 2);

			t.setTitle(patientNameLabel.getText()
					+ ": "
					+ (String) documentationTable.getValueAt(
							documentationTable.getSelectedRow(), 0)
					+ " at "
					+ (String) documentationTable.getValueAt(
							documentationTable.getSelectedRow(), 1));
			t.setSize(400, 300);

			JTextPane t2 = new JTextPane();
			t2.setEditable(false);
			JScrollPane pane = new JScrollPane();
			pane.setViewportView(t2);
			t2.setText((String) documentationTable.getValueAt(
					documentationTable.getSelectedRow(), 2));
			t.add(pane);

			t.setVisible(true);
			t.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		}
	}

	private void giveMedicationButtonActionPerformed(
			java.awt.event.ActionEvent evt) {

		if (marTable.getSelectedRow() < 0)
			JOptionPane.showMessageDialog(this,
					"Select a Medication before giving");
		else {
			MedicationDialog dialog = new MedicationDialog(this, true,
					documentationTable.getModel());
		}
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

		if (!(documentationTable.getSelectedRow() < 0))
			((DefaultTableModel) documentationTable.getModel())
					.removeRow(documentationTable.getSelectedRow());

	}

	private void editNarrativeButtonActionPerformed(
			java.awt.event.ActionEvent evt) {

		if (documentationTable.getSelectedRow() < 0)
			JOptionPane.showMessageDialog(this, "Please Select a Narrative");
		else {
			final JDialog t = new JDialog(this);
			t.setLayout(new GridLayout(1, 2));

			t.setSize(800, 300);
			t.setLocation(
					(t.getToolkit().getScreenSize().width - getWidth()) / 2,
					(t.getToolkit().getScreenSize().height - getHeight()) / 2);

			t.setTitle(patientNameLabel.getText()
					+ ": "
					+ (String) documentationTable.getValueAt(
							documentationTable.getSelectedRow(), 0)
					+ " at "
					+ (String) documentationTable.getValueAt(
							documentationTable.getSelectedRow(), 1));

			JTextPane t2 = new JTextPane();
			t2.setSize(350, 300);

			final JTextPane t3 = t2;

			JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			// t2.setEditable(false);
			JScrollPane pane = new JScrollPane();
			pane.setViewportView(t2);
			t2.setText((String) documentationTable.getValueAt(
					documentationTable.getSelectedRow(), 2));

			t.add(pane);

			JButton saveButton = new JButton("Save");
			saveButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					documentationTable.setValueAt((Object) t3.getText(),
							documentationTable.getSelectedRow(), 2);
					t.dispose();
				}
			});
			panel.add(saveButton);
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					t.dispose();
				}
			});
			panel.add(cancelButton);

			t.add(panel);

			t.setVisible(true);
			t.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		}
	}

	private void printSampleButtonActionPerformed(java.awt.event.ActionEvent evt) {
		try {

			setAlwaysOnTop(false);

			PrinterJob job = PrinterJob.getPrinterJob();

			PageFormat format = new PageFormat();
			format.setOrientation(PageFormat.LANDSCAPE);

			job.setPrintable(this, format);
			if (job.printDialog())
				job.print();
			setAlwaysOnTop(true);
		} catch (PrinterException ex) {
			Logger.getLogger(SimulationGUI.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	/**
	 * 
	 * @author Eric
	 */
	private class MedicationDialog extends javax.swing.JDialog {
		/**
		 * Creates new form MedicationDialog
		 */
		public MedicationDialog(Frame parent, boolean modal,
				TableModel recordingTable) {
			super(parent, modal);
			initComponents();
			setLocation((getToolkit().getScreenSize().width - getWidth()) / 2,
					(getToolkit().getScreenSize().height - getHeight()) / 2);

			medicationNameLabel.setText((String) ((SimulationGUI) parent)
					.getMarTable()
					.getModel()
					.getValueAt(
							((SimulationGUI) parent).getMarTable()
									.getSelectedRow(), 0));

			setVisible(true);

		}

		/**
		 * This method is called from within the constructor to initialize the
		 * form. WARNING: Do NOT modify this code. The content of this method is
		 * always regenerated by the Form Editor.
		 */
		@SuppressWarnings("unchecked")
		// <editor-fold defaultstate="collapsed" desc="Generated Code">
		private void initComponents() {

			giveMedicationConfirmButton = new javax.swing.JButton();
			jLabel1 = new javax.swing.JLabel();
			medicationNameLabel = new javax.swing.JLabel();
			amountTextField = new javax.swing.JTextField();
			jLabel3 = new javax.swing.JLabel();
			unitsTextField = new javax.swing.JTextField();
			jLabel4 = new javax.swing.JLabel();
			jScrollPane1 = new javax.swing.JScrollPane();
			notesTextPane = new javax.swing.JTextPane();
			cancelButton = new javax.swing.JButton();
			jLabel2 = new javax.swing.JLabel();
			followUpTextField = new javax.swing.JTextField();
			jLabel5 = new javax.swing.JLabel();
			initialsTextField = new javax.swing.JTextField();
			jLabel6 = new javax.swing.JLabel();

			setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(
					new org.netbeans.lib.awtextra.AbsoluteLayout());

			giveMedicationConfirmButton.setText("Give Medication");
			giveMedicationConfirmButton
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							giveMedicationConfirmButtonActionPerformed(evt);
						}
					});

			amountTextField.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent evt) {
					amountTextFieldKeyPressed(evt);
				}
			});

			getContentPane().add(
					giveMedicationConfirmButton,
					new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 108,
							-1, -1));

			jLabel1.setText("Amount");
			getContentPane().add(
					jLabel1,
					new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10,
							-1, -1));

			medicationNameLabel.setText("Medication Name");
			getContentPane().add(
					medicationNameLabel,
					new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 33,
							-1, -1));

			amountTextField
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							amountTextFieldActionPerformed(evt);
						}
					});
			getContentPane().add(
					amountTextField,
					new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30,
							60, -1));

			jLabel3.setText("Units");
			getContentPane().add(
					jLabel3,
					new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 11,
							-1, -1));

			unitsTextField
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							unitsTextFieldActionPerformed(evt);
						}
					});
			getContentPane().add(
					unitsTextField,
					new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 30,
							121, -1));

			jLabel4.setText("Notes");
			getContentPane().add(
					jLabel4,
					new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 96,
							-1, -1));

			jScrollPane1.setViewportView(notesTextPane);

			getContentPane().add(
					jScrollPane1,
					new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 116,
							363, 173));

			cancelButton.setText("Cancel");
			cancelButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					cancelButtonActionPerformed(evt);
				}
			});
			getContentPane().add(
					cancelButton,
					new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 236,
							107, -1));

			jLabel2.setText("Follow up");
			getContentPane().add(
					jLabel2,
					new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 11,
							-1, -1));
			getContentPane().add(
					followUpTextField,
					new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30,
							114, -1));

			jLabel5.setText("Initials");
			getContentPane().add(
					jLabel5,
					new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 11,
							-1, -1));
			getContentPane().add(
					initialsTextField,
					new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 30,
							49, -1));

			jLabel6.setText("Medication");
			getContentPane().add(
					jLabel6,
					new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10,
							-1, -1));

			pack();

			amountTextField
					.addPropertyChangeListener(new PropertyChangeListener() {

						@Override
						public void propertyChange(PropertyChangeEvent evt) {
							Integer i;
							try {
								i = Integer.parseInt(amountTextField.getText());
							} catch (Exception e) {
								i = null;

							}
							if (i == null)
								amountTextField.setText("");
						}
					});
		}// </editor-fold>

		private void amountTextFieldKeyPressed(KeyEvent evt) {

			if (!((evt.getKeyChar() >= java.awt.event.KeyEvent.VK_0) && (evt
					.getKeyChar() <= java.awt.event.KeyEvent.VK_9))
					&& evt.getKeyChar() != java.awt.event.KeyEvent.VK_BACK_SPACE
					&& amountTextField.isFocusOwner()) {

				amountTextField
						.setText(amountTextField
								.getText()
								.substring(
										0,
										(amountTextField.getText().length() > 0 ? amountTextField
												.getText().length() - 1 : 0)));

			}

		}

		private void giveMedicationConfirmButtonActionPerformed(
				java.awt.event.ActionEvent evt) {
			// TODO add your handling code here:
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
			DateFormat dayFormat = new SimpleDateFormat("HH:mma");

			((DefaultTableModel) documentationTable.getModel())
					.addRow(new String[] {
							dateFormat.format(Calendar.getInstance(
									TimeZone.getDefault()).getTime()),
							dayFormat.format(Calendar.getInstance(
									TimeZone.getDefault()).getTime()),
							"Medication Given: "
									+ medicationNameLabel.getText()
									+ "\nDose:"
									+ amountTextField.getText()+unitsTextField.getText()
									+ "\nRoute: "
									+ marTable.getValueAt(
											marTable.getSelectedRow(), 2)
									+ " \nNotes:\n"
									+ notesTextPane.getText()
									+ "\n\nTemperature:\nPulse:\nResp:\nBP:\nO2 Sat:\nPain Scale:\nFSBS:\nSite:\nRelated Diagnosis/Reason for medication:\n",
							followUpTextField.getText(),
							initialsTextField.getText() });
			rootTabbedPane.setSelectedIndex(2);
			documentationTable.setRowSelectionInterval(
					documentationTable.getRowCount() - 1,
					documentationTable.getRowCount() - 1);
			this.dispose();

		}

		private void unitsTextFieldActionPerformed(
				java.awt.event.ActionEvent evt) {

		}

		private void amountTextFieldActionPerformed(
				java.awt.event.ActionEvent evt) {
			Integer i;
			try {
				i = Integer.parseInt(amountTextField.getText());
			} catch (Exception e) {
				i = null;

			}
			if (i == null)
				amountTextField.setText("");

		}

		private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
			dispose();
		}

		// Variables declaration - do not modify
		private javax.swing.JTextField amountTextField;
		private javax.swing.JButton cancelButton;
		private javax.swing.JTextField followUpTextField;
		private javax.swing.JButton giveMedicationConfirmButton;
		private javax.swing.JTextField initialsTextField;
		private javax.swing.JLabel jLabel1;
		private javax.swing.JLabel jLabel2;
		private javax.swing.JLabel jLabel3;
		private javax.swing.JLabel jLabel4;
		private javax.swing.JLabel jLabel5;
		private javax.swing.JScrollPane jScrollPane1;
		private javax.swing.JLabel medicationNameLabel;
		private javax.swing.JTextPane notesTextPane;
		private javax.swing.JTextField unitsTextField;
		private javax.swing.JLabel jLabel6;
		// End of variables declaration
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
		// </editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new SimulationGUI(new SimulationManager()).setVisible(true);
			}
		});
	}

	public void setMarTable(JTable marTable) {
		this.marTable = marTable;
	}

	public void setDocumentationTable(JTable documentationTable) {
		this.documentationTable = documentationTable;
	}

	public JTable getMarTable() {
		return marTable;
	}

	public JTable getDocumentationTable() {
		return documentationTable;
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		// throw new UnsupportedOperationException("Not supported yet.");
		if (pageIndex > 1) {
			return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D) graphics;
		if (pageIndex == 0) {
			rootTabbedPane.setSelectedIndex(1);
			pageFormat.setOrientation(PageFormat.LANDSCAPE);
			g2d.translate(pageFormat.getImageableX() + 20,
					pageFormat.getImageableY() + 20);
			g2d.scale(.60, .60);
			rootTabbedPane.paint(graphics);
			graphics.drawString("Hello world!", 100, 100);
		} else {
			rootTabbedPane.setSelectedIndex(2);
			pageFormat.setOrientation(PageFormat.LANDSCAPE);
			g2d.translate(pageFormat.getImageableX() + 20,
					pageFormat.getImageableY() + 20);
			g2d.scale(.60, .60);
			rootTabbedPane.paint(graphics);
			graphics.drawString("Hello world!", 100, 100);
		}

		return PAGE_EXISTS;
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel allergiesSetter;
    private javax.swing.JLabel allergiesText;
    private javax.swing.JButton cancelSimulationButton;
    private javax.swing.JButton deleteNarrativeButton;
    private javax.swing.JLabel diagnosisSetter;
    private javax.swing.JLabel diagnosisText;
    private javax.swing.JScrollPane docTabelHolder;
    private javax.swing.JPanel documentationPane;
    private javax.swing.JScrollPane documentationScrollPane;
    private javax.swing.JTable documentationTable;
    private javax.swing.JPanel documentation_Panel;
    private javax.swing.JButton editNarrativeButton;
    private javax.swing.JButton giveMedicationButton;
    private javax.swing.JButton hourDueButton;
    private javax.swing.JButton insertNewNarrativeButton;
    private javax.swing.JLabel jcahoLabel;
    private javax.swing.JScrollPane jcahoScrollPane;
    private javax.swing.JPanel jcaho_Panel;
    private javax.swing.JScrollPane marScrollPane;
    private javax.swing.JTable marTable;
    private javax.swing.JPanel mar_Panel;
    private javax.swing.JLabel patientNameLabel;
    private javax.swing.JLabel patientNameText;
    private javax.swing.JButton printSampleButton;
    private javax.swing.JLabel roomNumSetter;
    private javax.swing.JLabel roomNumberText;
    private javax.swing.JTabbedPane rootTabbedPane;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeLeftTextLabel;
    private javax.swing.JButton viewSelectedNarrativeButton;
    // End of variables declaration//GEN-END:variables
}
