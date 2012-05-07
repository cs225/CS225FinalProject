/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CS225FinalProject.GUI;

import CS225FinalProject.DataStructure.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import CS225FinalProject.SimulationManager;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.crypto.Data;

/**
 * 
 * @author Eric
 */
public class MaintenanceManagerGUI extends javax.swing.JFrame {

	private DefaultListModel sessionListModel;
	private DefaultListModel studentListModel;
	private DefaultListModel scenarioListModel;

	private SimulationController controller = SimulationController
			.getInstance();
        
        
        
        

	/**
	 * Creates new form MaintenanceManagerGUI
	 */
	public MaintenanceManagerGUI() {
		initComponents();
                
                scenarioList.addListSelectionListener(new ListSelectionListener() {

                    
                    
                    /**
                     * this is for loading the selected scenario to the gui
                     */
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(scenarioList.getSelectedIndex()>-1){
                    Scenario scenario = controller.getScenarioByName((String)scenarioList.getSelectedValue());
                    
                    while(medJTable.getRowCount()>0){
                        ((DefaultTableModel)medJTable.getModel()).removeRow(0);
                    }
                    for(Medication medication:scenario.getMedicationList()){
                        ((DefaultTableModel)medJTable.getModel()).addRow(new String[]{medication.getMedicationName(), medication.getDosage(), medication.getRouteOfMedication(), medication.getMedicationDueTimes()});
                    }
                    
                    while(documentationTable.getRowCount()>0){
                        ((DefaultTableModel)documentationTable.getModel()).removeRow(0);
                    }
                    for(Narrative medication:scenario.getNarrativeList()){
                        ((DefaultTableModel)documentationTable.getModel()).addRow(medication.getNarrativeAsArrayStrings());
                    }
                    
                    scenarioSummaryTextPane.setText(scenario.getSummary());
                    roomNumberTextField.setText(scenario.getRoom()+"");
                    patientNameTextField.setText(scenario.getPatientName());
                    diagnosisTextArea.setText(scenario.getDiagnosis());
                    allergiesTextArea.setText(scenario.getAllergies());
                    
                }
            }
        });
                
                
                
                
                rootTabbedPane.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if(rootTabbedPane.getSelectedIndex()==1){
                    ((DefaultListModel)scenarioList.getModel()).removeAllElements();
                    for(Scenario scenario: controller.getScenarios())
                        ((DefaultListModel)scenarioList.getModel()).addElement(scenario.getPatientName());
                }
                if(rootTabbedPane.getSelectedIndex()==2){
                    currentProfessorUserNameLabel.setText(controller.getUsers().get(0).getUserName());
                    currentProfessorPasswordLabel.setText(controller.getUsers().get(0).getPassword());
                    
//                    ((DefaultListModel)scenarioList.getModel()).removeAllElements();
//                    for(Scenario scenario: controller.getScenarios())
//                        ((DefaultListModel)scenarioList.getModel()).addElement(scenario.getPatientName());
            }}
        });
                
                
                studentList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(studentList.getSelectedIndex()>0){
                    studentManagerControlTabbedPane.setSelectedIndex(0);
                    studentManagerControlTabbedPane.setSelectedIndex(1);
                    int studentListnum = studentList.getSelectedIndex();
                    studentList.clearSelection();
                    studentList.setSelectedIndex(studentListnum);
                }
            }
        });
                
                studentManagerControlTabbedPane.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if(studentManagerControlTabbedPane.getSelectedIndex()==1 && studentList.getSelectedIndex()>-1){
                    User student = null;
                    while(((DefaultTableModel) studentTable.getModel()).getRowCount()>0)
                        ((DefaultTableModel) studentTable.getModel()).removeRow(0);
                    for(User user:  controller.getStudentsInClass((String)classList.getSelectedValue())){
                        if(!user.isInstructor()&& user.getRealName().equals(studentList.getSelectedValue())&&
                                user.getClassName().equals(classList.getSelectedValue())){
                            student = user;
                            break;
                        }
                   
                    }
                    if(student!=null){
                        studentManagerControlTabbedPane.setVisible(true);
                    for(CompletedScenario completedScenario:((Student)student).getCompletedScenarios()){
                        ((DefaultTableModel) studentTable.getModel()).addRow(
                                new String[]{completedScenario.getScenarioTaken().getPatientName(),
                                    completedScenario.getDateTaken(),
                                    completedScenario.getEvaluationSuggestion(),
                                    ""+completedScenario.getScore()} );
                        
                    }
                    currentStudentUserNameLabel.setText(student.getUserName());
                    currentStudentPasswordLabel.setText(student.getPassword());
                    studentNameLabel.setText(student.getRealName());
                    }
                    
                }
                //else
                       // studentManagerControlTabbedPane.setVisible(false);
                   
            }
        });
		setTitle("Simulation Data Management");
		setVisible(false);

		setLocation((getToolkit().getScreenSize().width - getWidth()) / 2,
				(getToolkit().getScreenSize().height - getHeight()) / 2);

		loadClasses();
		loadStudentsByClass();
	}

	private void loadClasses() {
		for (String cName : controller.getClassNames()) {
			sessionListModel.addElement((String) cName);
		}
		classList.setSelectedIndex(0);
	}

	private void loadStudentsByClass() {
		studentListModel = new DefaultListModel();
		studentList.setModel(studentListModel);

		for (User u : controller.getUsers()) {

			if (classList.getSelectedValue() != null
					&& !u.isInstructor()
					&& classList.getSelectedValue().toString()
							.equalsIgnoreCase(u.getClassName())) {
				studentListModel.addElement((String) u.getRealName());
			}
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootTabbedPane = new javax.swing.JTabbedPane();
        studentManagerPanel = new javax.swing.JPanel();
        classScrollPane = new javax.swing.JScrollPane();
        classList = new javax.swing.JList();
        studentScrollPane = new javax.swing.JScrollPane();
        studentList = new javax.swing.JList();
        classScrollPaneLabel = new javax.swing.JLabel();
        studentScrollPaneLabel = new javax.swing.JLabel();
        addClassButton = new javax.swing.JButton();
        addStudentButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        removeClassButton = new javax.swing.JButton();
        removeStudentButton = new javax.swing.JButton();
        removeAllButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        removalAreaLabel = new javax.swing.JLabel();
        selectionArealabel = new javax.swing.JLabel();
        addingAreaLabel = new javax.swing.JLabel();
        studentManagerControlTabbedPane = new javax.swing.JTabbedPane();
        classControlPanel = new javax.swing.JPanel();
        classControlScrollPane = new javax.swing.JScrollPane();
        classControlJTable = new javax.swing.JTable();
        studentControlPanel = new javax.swing.JPanel();
        studentControlScrollPane = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        viewSelectedScenarioButton = new javax.swing.JButton();
        studentNameLabel = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();
        SimulationScoreLabel = new javax.swing.JLabel();
        changePasswordButton = new javax.swing.JButton();
        changeUserNameButton = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        LoginModLabel = new javax.swing.JLabel();
        currentStudentUserNameLabel = new javax.swing.JLabel();
        currentStudentPasswordLabel = new javax.swing.JLabel();
        SimResultsAreaLabel = new javax.swing.JLabel();
        ViewScenarioSuggestionButton = new javax.swing.JButton();
        setScenarioScoreButton = new javax.swing.JButton();
        scenarioManagerPanel = new javax.swing.JPanel();
        scenarioScrollPanel = new javax.swing.JScrollPane();
        scenarioList = new javax.swing.JList();
        selectScenarioLabel = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        previewTabbedPane = new javax.swing.JTabbedPane();
        marPanel = new javax.swing.JPanel();
        medScrollPane = new javax.swing.JScrollPane();
        medJTable = new javax.swing.JTable();
        roomNumLabel = new javax.swing.JLabel();
        diagnosisLabel = new javax.swing.JLabel();
        patientNameLabel = new javax.swing.JLabel();
        allergiesLabel = new javax.swing.JLabel();
        roomNumberTextField = new javax.swing.JTextField();
        allergiesScrollPane = new javax.swing.JScrollPane();
        allergiesTextArea = new javax.swing.JTextArea();
        patientNameTextField = new javax.swing.JTextField();
        diagnosisScrollPane = new javax.swing.JScrollPane();
        diagnosisTextArea = new javax.swing.JTextArea();
        addMedicationButton = new javax.swing.JButton();
        removeMedicationButton = new javax.swing.JButton();
        documentationPanel = new javax.swing.JPanel();
        documentationScrollPane = new javax.swing.JScrollPane();
        documentationTable = new javax.swing.JTable();
        addNarrativeButton = new javax.swing.JButton();
        removeNarrativeButton = new javax.swing.JButton();
        removeAllNarrativeButton = new javax.swing.JButton();
        scenarioSummaryPanel = new javax.swing.JPanel();
        scenarioSummaryLabel = new javax.swing.JLabel();
        ScenarioScrollPane = new javax.swing.JScrollPane();
        scenarioSummaryTextPane = new javax.swing.JTextPane();
        saveChangesButton = new javax.swing.JButton();
        scenarioPreviewLabel = new javax.swing.JLabel();
        UndoAllChangesButton = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        addScenarioButton = new javax.swing.JButton();
        removeScenarioButton = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        importExportAreaLabel = new javax.swing.JLabel();
        importScenarioButton = new javax.swing.JButton();
        exportScenarioButton = new javax.swing.JButton();
        professorLoginManager = new javax.swing.JPanel();
        currentProfessorPasswordLabel = new javax.swing.JLabel();
        changeProffesorPasswordButton = new javax.swing.JButton();
        currentProfessorUserNameLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulation Maintenance Manager");
        setResizable(false);

        rootTabbedPane.setPreferredSize(new java.awt.Dimension(1037, 727));
        rootTabbedPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                rootTabSelectionChanged(evt);
            }
        });

        studentManagerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sessionListModel = new DefaultListModel();
        classList.setModel(
            sessionListModel
        );
        classList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                classListValueChanged(evt);
            }
        });
        classList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                classListFocusGained(evt);
            }
        });
        classScrollPane.setViewportView(classList);

        studentManagerPanel.add(classScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 55, 150, 120));

        studentList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentListFocusGained(evt);
            }
        });
        studentScrollPane.setViewportView(studentList);

        studentManagerPanel.add(studentScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 55, 200, 120));

        classScrollPaneLabel.setText("Class");
        studentManagerPanel.add(classScrollPaneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        studentScrollPaneLabel.setText("Student");
        studentManagerPanel.add(studentScrollPaneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        addClassButton.setText("Add Class");
        addClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassButtonActionPerformed(evt);
            }
        });
        studentManagerPanel.add(addClassButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 90, -1));

        addStudentButton.setText("Add Student");
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });
        studentManagerPanel.add(addStudentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        studentManagerPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 0, 8, 180));
        studentManagerPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 183, 1032, 10));

        removeClassButton.setText("Remove Class");
        removeClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeClassButtonActionPerformed(evt);
            }
        });
        studentManagerPanel.add(removeClassButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 110, -1));

        removeStudentButton.setText("Remove Student");
        removeStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeStudentButtonActionPerformed(evt);
            }
        });
        studentManagerPanel.add(removeStudentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, -1, -1));

        removeAllButton.setText("Remove All");
        removeAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllButtonActionPerformed(evt);
            }
        });
        studentManagerPanel.add(removeAllButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 97, 66));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        studentManagerPanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 11, 180));

        removalAreaLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        removalAreaLabel.setForeground(new java.awt.Color(255, 0, 0));
        removalAreaLabel.setText("Removal");
        studentManagerPanel.add(removalAreaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        selectionArealabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        selectionArealabel.setText("Selection");
        studentManagerPanel.add(selectionArealabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        addingAreaLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        addingAreaLabel.setText("Adding");
        studentManagerPanel.add(addingAreaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        classControlJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Student Name", "Average Score", "Number of Simulations Completed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        classControlScrollPane.setViewportView(classControlJTable);

        javax.swing.GroupLayout classControlPanelLayout = new javax.swing.GroupLayout(classControlPanel);
        classControlPanel.setLayout(classControlPanelLayout);
        classControlPanelLayout.setHorizontalGroup(
            classControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(classControlScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
        );
        classControlPanelLayout.setVerticalGroup(
            classControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(classControlScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
        );

        studentManagerControlTabbedPane.addTab("Class Control", classControlPanel);

        studentControlPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ScenarioName", "DateTaken", "Suggestion", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        studentControlScrollPane.setViewportView(studentTable);

        studentControlPanel.add(studentControlScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1025, 222));

        viewSelectedScenarioButton.setText("View Selected Scenario Input");
        viewSelectedScenarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSelectedScenarioButtonActionPerformed(evt);
            }
        });
        studentControlPanel.add(viewSelectedScenarioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 200, -1));

        studentNameLabel.setText("StudentName");
        studentControlPanel.add(studentNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 0, -1, -1));

        printButton.setText("Print Selected Scenario Input");
        studentControlPanel.add(printButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 200, -1));

        SimulationScoreLabel.setText("AVG Simulation Score");
        studentControlPanel.add(SimulationScoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        changePasswordButton.setText("Change Student Password");
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });
        studentControlPanel.add(changePasswordButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 402, -1, -1));

        changeUserNameButton.setText("Change User Name");
        changeUserNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeUserNameButtonActionPerformed(evt);
            }
        });
        studentControlPanel.add(changeUserNameButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 331, -1, -1));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        studentControlPanel.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 258, 50, 202));

        LoginModLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LoginModLabel.setText("Login Modification");
        studentControlPanel.add(LoginModLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(684, 248, -1, -1));

        currentStudentUserNameLabel.setText("current Username");
        studentControlPanel.add(currentStudentUserNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 311, -1, -1));

        currentStudentPasswordLabel.setText("current Password");
        studentControlPanel.add(currentStudentPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 382, -1, -1));

        SimResultsAreaLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        SimResultsAreaLabel.setText("Simulation Results");
        studentControlPanel.add(SimResultsAreaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 248, -1, -1));

        ViewScenarioSuggestionButton.setText("View Selected Scenario Suggestion");
        ViewScenarioSuggestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewScenarioSuggestionButtonActionPerformed(evt);
            }
        });
        studentControlPanel.add(ViewScenarioSuggestionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 200, -1));

        setScenarioScoreButton.setText("Set score for the Selected Scenario");
        setScenarioScoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setScenarioScoreButtonActionPerformed(evt);
            }
        });
        studentControlPanel.add(setScenarioScoreButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, -1, -1));

        studentManagerControlTabbedPane.addTab("Student Control", studentControlPanel);

        studentManagerPanel.add(studentManagerControlTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1030, 490));

        rootTabbedPane.addTab("StudentManager", studentManagerPanel);

        scenarioManagerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scenarioListModel = new DefaultListModel();
        scenarioListModel.add(0,"CS225 TESTING");
        scenarioListModel.add(0,"CS225 TESTING");
        scenarioListModel.add(0,"CS225 TESTING");
        scenarioListModel.add(0,"CS225 TESTING");
        scenarioList.setModel(scenarioListModel);
        scenarioList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                scenarioListValueChanged(evt);
            }
        });
        scenarioScrollPanel.setViewportView(scenarioList);

        scenarioManagerPanel.add(scenarioScrollPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 160, 76));

        selectScenarioLabel.setText("Select Scenario to edit");
        scenarioManagerPanel.add(selectScenarioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 12, -1, -1));

        jSeparator4.setPreferredSize(new java.awt.Dimension(0, 10));
        scenarioManagerPanel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1030, 10));

        medJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Insulin", "10 units", null, "10AM,3PM"},
                {"Morphine", "50 milligrams", null, null},
                {"Cocaine", "1 gram", null, null}
            },
            new String [] {
                "Medication", "Dose", "Route", "Hour Due"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        medJTable.setRowHeight(45);
        medScrollPane.setViewportView(medJTable);

        roomNumLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        roomNumLabel.setText("Room:");

        diagnosisLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        diagnosisLabel.setText("Diagnosis:");

        patientNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        patientNameLabel.setText("Name:");

        allergiesLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        allergiesLabel.setText("Allergies:");

        roomNumberTextField.setText("jTextField1");

        allergiesTextArea.setColumns(20);
        allergiesTextArea.setRows(5);
        allergiesScrollPane.setViewportView(allergiesTextArea);

        patientNameTextField.setText("jTextField2");

        diagnosisTextArea.setColumns(20);
        diagnosisTextArea.setRows(5);
        diagnosisScrollPane.setViewportView(diagnosisTextArea);

        addMedicationButton.setText("Add Medication");
        addMedicationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMedicationButtonActionPerformed(evt);
            }
        });

        removeMedicationButton.setText("Remove Selected Medication");
        removeMedicationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMedicationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout marPanelLayout = new javax.swing.GroupLayout(marPanel);
        marPanel.setLayout(marPanelLayout);
        marPanelLayout.setHorizontalGroup(
            marPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(marPanelLayout.createSequentialGroup()
                .addGroup(marPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(marPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(medScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(marPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(marPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(diagnosisLabel)
                            .addComponent(roomNumLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(marPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(marPanelLayout.createSequentialGroup()
                                .addComponent(roomNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(patientNameLabel)
                                .addGap(18, 18, 18)
                                .addComponent(patientNameTextField))
                            .addComponent(diagnosisScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(allergiesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(marPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(allergiesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(marPanelLayout.createSequentialGroup()
                                .addComponent(addMedicationButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeMedicationButton)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        marPanelLayout.setVerticalGroup(
            marPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(marPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(medScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(marPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomNumLabel)
                    .addComponent(patientNameLabel)
                    .addComponent(roomNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMedicationButton)
                    .addComponent(removeMedicationButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(marPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(diagnosisScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(allergiesScrollPane)
                    .addGroup(marPanelLayout.createSequentialGroup()
                        .addGroup(marPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(allergiesLabel)
                            .addComponent(diagnosisLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        previewTabbedPane.addTab("MAR", marPanel);

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
        documentationScrollPane.setViewportView(documentationTable);
        documentationTable.getColumnModel().getColumn(2).setPreferredWidth(625);

        addNarrativeButton.setText("Add New Narrative");
        addNarrativeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNarrativeButtonActionPerformed(evt);
            }
        });

        removeNarrativeButton.setText("Remove Narrative");
        removeNarrativeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeNarrativeButtonActionPerformed(evt);
            }
        });

        removeAllNarrativeButton.setText("RemoveAll");
        removeAllNarrativeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllNarrativeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout documentationPanelLayout = new javax.swing.GroupLayout(documentationPanel);
        documentationPanel.setLayout(documentationPanelLayout);
        documentationPanelLayout.setHorizontalGroup(
            documentationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(documentationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(documentationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(documentationPanelLayout.createSequentialGroup()
                        .addComponent(addNarrativeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeNarrativeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeAllNarrativeButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(documentationScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE))
                .addContainerGap())
        );
        documentationPanelLayout.setVerticalGroup(
            documentationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(documentationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(documentationScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(documentationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNarrativeButton)
                    .addComponent(removeNarrativeButton)
                    .addComponent(removeAllNarrativeButton))
                .addContainerGap(173, Short.MAX_VALUE))
        );

        previewTabbedPane.addTab("Documentation", documentationPanel);

        scenarioSummaryLabel.setText("Scenario Summary");

        ScenarioScrollPane.setViewportView(scenarioSummaryTextPane);

        javax.swing.GroupLayout scenarioSummaryPanelLayout = new javax.swing.GroupLayout(scenarioSummaryPanel);
        scenarioSummaryPanel.setLayout(scenarioSummaryPanelLayout);
        scenarioSummaryPanelLayout.setHorizontalGroup(
            scenarioSummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scenarioSummaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scenarioSummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scenarioSummaryLabel)
                    .addComponent(ScenarioScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(488, Short.MAX_VALUE))
        );
        scenarioSummaryPanelLayout.setVerticalGroup(
            scenarioSummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scenarioSummaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scenarioSummaryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScenarioScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        previewTabbedPane.addTab("Summary", scenarioSummaryPanel);

        scenarioManagerPanel.add(previewTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        saveChangesButton.setText("Save Changes");
        saveChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesButtonActionPerformed(evt);
            }
        });
        scenarioManagerPanel.add(saveChangesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 626, -1, -1));

        scenarioPreviewLabel.setText("Scenario Preview");
        scenarioManagerPanel.add(scenarioPreviewLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        UndoAllChangesButton.setText("Undo All");
        UndoAllChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoAllChangesButtonActionPerformed(evt);
            }
        });
        scenarioManagerPanel.add(UndoAllChangesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 626, -1, -1));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        scenarioManagerPanel.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 10, 120));

        addScenarioButton.setText("addScenario");
        addScenarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addScenarioButtonActionPerformed(evt);
            }
        });
        scenarioManagerPanel.add(addScenarioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        removeScenarioButton.setText("Remove Scenario");
        removeScenarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeScenarioButtonActionPerformed(evt);
            }
        });
        scenarioManagerPanel.add(removeScenarioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        scenarioManagerPanel.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 40, 120));

        importExportAreaLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        importExportAreaLabel.setText("Import and Export Scenario List");
        scenarioManagerPanel.add(importExportAreaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, -1));

        importScenarioButton.setText("Import");
        importScenarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importScenarioButtonActionPerformed(evt);
            }
        });
        scenarioManagerPanel.add(importScenarioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 100, 60));

        exportScenarioButton.setText("Export");
        exportScenarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportScenarioButtonActionPerformed(evt);
            }
        });
        scenarioManagerPanel.add(exportScenarioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 110, 60));

        rootTabbedPane.addTab("ScenarioManager", scenarioManagerPanel);

        professorLoginManager.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        currentProfessorPasswordLabel.setText("CurrentPassword");
        professorLoginManager.add(currentProfessorPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 95, -1, -1));

        changeProffesorPasswordButton.setText("Change Password");
        changeProffesorPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeProffesorPasswordButtonActionPerformed(evt);
            }
        });
        professorLoginManager.add(changeProffesorPasswordButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 150, -1));

        currentProfessorUserNameLabel.setText("CurrentUserName");
        professorLoginManager.add(currentProfessorUserNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 41, -1, -1));

        jLabel1.setText("Username:");
        professorLoginManager.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 70, -1));

        jLabel2.setText("Password:");
        professorLoginManager.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 95, -1, -1));

        rootTabbedPane.addTab("ProfessorLoginManager", professorLoginManager);

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
            .addComponent(rootTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logOutButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rootTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logOutButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rootTabSelectionChanged(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_rootTabSelectionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rootTabSelectionChanged

	private void classListValueChanged(javax.swing.event.ListSelectionEvent evt) {
		// change students based on selected class
		loadStudentsByClass();
                while( ((DefaultTableModel)classControlJTable.getModel()).getRowCount()>0)
               ((DefaultTableModel)classControlJTable.getModel()).removeRow(0);
               
               for(User user:controller.getStudentsInClass((String)classList.getSelectedValue()))
                   ((DefaultTableModel)classControlJTable.getModel()).addRow(new Object[]{user.getRealName(),new Double(0), new Double( ((Student)user).getCompletedScenarios().size())});
	}

	private void viewSelectedScenarioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void setScenarioScoreButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void ViewScenarioSuggestionButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void changePasswordButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
            if(studentManagerControlTabbedPane.getSelectedIndex()==1 && studentList.getSelectedIndex()>-1){
                    User student = null;
                    while(((DefaultTableModel) studentTable.getModel()).getRowCount()>0)
                        ((DefaultTableModel) studentTable.getModel()).removeRow(0);
                    for(User user:  controller.getStudentsInClass((String)classList.getSelectedValue())){
                        if(!user.isInstructor()&& user.getRealName().equals(studentList.getSelectedValue())&&
                                user.getClassName().equals(classList.getSelectedValue())){
                            student = user;
                            break;
                        }
                   
                    }
                    if(student!=null){
                    for(CompletedScenario completedScenario:((Student)student).getCompletedScenarios()){
                        ((DefaultTableModel) studentTable.getModel()).addRow(
                                new String[]{completedScenario.getScenarioTaken().getPatientName(),
                                    completedScenario.getDateTaken(),
                                    completedScenario.getEvaluationSuggestion(),
                                    ""+completedScenario.getScore()} );
                        
                    }
                    
                    String newUsername = JOptionPane.showInputDialog("Enter new password");
                    if(newUsername!= null){
                        student.setPassword(newUsername);
                        controller.writeUsers();
                        studentManagerControlTabbedPane.setSelectedIndex(0);
                        studentManagerControlTabbedPane.setSelectedIndex(1);
                    }
                        
                    }
                }
            
	}

	private void addNarrativeButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void removeNarrativeButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void removeAllNarrativeButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void importScenarioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
            DataIO io = new DataIO();
            
            JFileChooser fileChooser = new JFileChooser();
            if(JFileChooser.APPROVE_OPTION==fileChooser.showOpenDialog(this)){
                controller.setScenarios(io.loadScenarioList(fileChooser.getSelectedFile().getAbsolutePath()));
                controller.writeScenarios();
                
            }
	}

	private void exportScenarioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
            DataIO io = new DataIO();
            
            JFileChooser fileChooser = new JFileChooser();
            if(JFileChooser.APPROVE_OPTION==fileChooser.showSaveDialog(this)){
                io.writeScenarioList(fileChooser.getSelectedFile().getAbsolutePath(),controller.getScenarios());
                
                
            }
	}

	private void UndoAllChangesButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
            int num = scenarioList.getSelectedIndex();
            scenarioList.clearSelection();
            scenarioList.setSelectedIndex(num);
	}

	private void sortByNameButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void sortByScoreButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void removeAllButtonActionPerformed(java.awt.event.ActionEvent evt) {
		int n = JOptionPane.showConfirmDialog(this,
				"Are you sure you want to remove all student and class data?",
				"Confirm Removal", JOptionPane.YES_NO_OPTION);

		if (n == JOptionPane.YES_OPTION) {
			int x = JOptionPane
					.showConfirmDialog(
							this,
							"Are you sure you want to remove all student and class data?",
							"Confirm Removal", JOptionPane.YES_NO_OPTION);
		}

		if (n == JOptionPane.YES_OPTION) {
			controller.removeAllStudents();
			controller.writeUsers();
			loadStudentsByClass();
		}
	}

	private void changeProffesorPasswordButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
            String password = JOptionPane.showInputDialog(this, "Enter new password");
            if(password!=null){
                controller.getUsers().get(0).setPassword(password);
                controller.writeUsers();
                rootTabbedPane.setSelectedIndex(2);
                rootTabbedPane.setSelectedIndex(1);
                
                
            }
	}

	private void changeProffessorUsernameButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
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
                        studentList.clearSelection();
                        classList.clearSelection();

			setVisible(false);
		}
	}

	private void removeScenarioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		int n = JOptionPane.showConfirmDialog(this,
				"Are you sure you want to delete this selection?",
				"Confirm Removal", JOptionPane.YES_NO_OPTION);

		if (n == JOptionPane.YES_OPTION) {
			String scenario = (String) scenarioListModel.get(scenarioList
					.getSelectedIndex());// use this string wisely!!! :)
			scenarioListModel.remove(scenarioList.getSelectedIndex());
			if (scenarioListModel.getSize() == 0) {
				previewTabbedPane.setVisible(false);
			}
                        controller.removeScenarioByName(scenario);
		}
	}

	private void addScenarioButtonActionPerformed(java.awt.event.ActionEvent evt) {

		String scenarioName = JOptionPane.showInputDialog("Enter Session name");
		if (scenarioName != null) {
			scenarioListModel.addElement(scenarioName);
		}
		scenarioList.setSelectedIndex(scenarioListModel.getSize() - 1);
		if (!previewTabbedPane.isVisible()) {
			previewTabbedPane.setVisible(true);
		}
		// TODO implement adding a new scenario to the DataStructure
	}

	private void saveChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {

		String selectedScenarioName = (String) scenarioList.getSelectedValue();
		if (selectedScenarioName != null) {
			Scenario scenario = controller
					.getScenarioByName(selectedScenarioName);

			// templates for setters when recording/editing a scenario.
			scenario.setAge(WIDTH);
			scenario.setAllergies(selectedScenarioName);
			scenario.setSummary(selectedScenarioName);
			scenario.setDiagnosis(selectedScenarioName);
			// scenario.setPatientName(selectedScenarioName);
			scenario.setScenarioName(selectedScenarioName);

			// little work to be done here.....
			scenario.setNarrativeList(null);

		}
	}

	private void removeMedicationButtonActionPerformed(
			java.awt.event.ActionEvent evt) {

		((DefaultTableModel) medJTable.getModel()).removeRow(medJTable
				.getSelectedRow());
	}

	private void addMedicationButtonActionPerformed(
			java.awt.event.ActionEvent evt) {

		String route = (String) JOptionPane.showInputDialog(this,
				"Please select the route of medication:",
				"Route of medication selection", JOptionPane.PLAIN_MESSAGE,
				null, new Object[] { "PO", "Buccal", "SL", "NGT", "GT", "PEG",
						"IM", "SC", "IV", "IVP", "IVPB", "ID", "Topical",
						"Transdermal", "Inhalation", "Nasal", "AD", "AS", "AU",
						"OD", "OS", "OU", "PR", "Vaginal" }, null);

		if (route != null) {
			((DefaultTableModel) medJTable.getModel()).addRow(new Object[] {
					"", "", route });
		}
	}

	private void scenarioListValueChanged(
			javax.swing.event.ListSelectionEvent evt) {
		if (scenarioList.getSelectedIndex() >= 0) {
			updateScenarioPreview((String) scenarioListModel.get(scenarioList
					.getSelectedIndex()));
		}
	}

	private void studentListFocusGained(java.awt.event.FocusEvent evt) {
		studentManagerControlTabbedPane.setSelectedIndex(1);
	}

	private void classListFocusGained(java.awt.event.FocusEvent evt) {
		studentList.clearSelection();
		studentManagerControlTabbedPane.setSelectedIndex(0);
                
               
	}

	private void removeStudentButtonActionPerformed(
			java.awt.event.ActionEvent evt) {

		if (studentList.getSelectedIndex() != -1) {
                  String name = ((String)studentList.getSelectedValue());

                    controller.removeStudentByNameAndClassroom(name,(String) classList.getSelectedValue());
                    classListValueChanged(null);
//			String studentName = JOptionPane.showInputDialog(this,
//					"Enter the Student User Name");
//
//			String studentPW = JOptionPane.showInputDialog(this,
//					"Enter the Student Password");
//
//			if (controller.removeStudent(studentName, studentPW)
//					&& studentList.getSelectedIndex() > -1) {
//				studentListModel.remove(studentList.getSelectedIndex());
//				controller.writeUsers();
//			} else {
//				// student not removed - try again!
//			}
//		} else {
//			JOptionPane.showMessageDialog(this, "Please Select a Student.");
		}
	}

	private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {

		// taking this data should be handled better. messy code
		String userName = JOptionPane.showInputDialog(this,
				"Enter the Student's User Name");

		String studentName = JOptionPane.showInputDialog(this,
				"Enter the Student's Real Name");

		String studentPW = JOptionPane.showInputDialog(this,
				"Enter the Student Password");

		Object[] choices = new Object[sessionListModel.getSize()];
		for (int i = 0; i < sessionListModel.getSize(); i++) {
			choices[i] = (String) sessionListModel.get(i);
		}

		String className = (String) JOptionPane.showInputDialog(this,
				"Enter the Class Name:", "Class Name",
				JOptionPane.PLAIN_MESSAGE, null, choices, "ham");

		if (userName != "" && studentName != "" && studentPW != "") {
			if (controller.addStudent(userName, studentName, studentPW,
					className)
					&& className.equalsIgnoreCase(classList.getSelectedValue()
							.toString())) {
				studentListModel.addElement(studentName);
				controller.writeUsers();
				loadStudentsByClass();
			}
		} else {
			System.out.println("Student not created!");
			// student not created -try again!
		}
	}

	private void addClassButtonActionPerformed(java.awt.event.ActionEvent evt) {

		// duplicate class name found should be handled
		// this code will only prompt for re-entry once.

		String className = JOptionPane.showInputDialog(this,
				"Enter the class name:");

		if (className != "" && controller.addClass(className)) {
			sessionListModel.addElement(className);
			controller.writeClassNames();
		} else {
			// class name exists - prompt re-entry.
			className = JOptionPane.showInputDialog(this,
					"Invalid name, enter a different name:");
		}
	}

	private void removeClassButtonActionPerformed(ActionEvent evt) {

		int n = JOptionPane.showConfirmDialog(this,
				"Are you sure you want to delete this selection?",
				"Confirm Removal", JOptionPane.YES_NO_OPTION);

		if (n == JOptionPane.YES_OPTION) {
			if (controller.removeClass((String) classList.getSelectedValue())
					&& classList.getSelectedIndex() > -1) {
				sessionListModel.remove(classList.getSelectedIndex());
                                for(User u:controller.getUsers()){
                                    if(u.getClassName().equals((String)classList.getSelectedValue()))
                                        controller.getUsers().remove(u);
                                }
                                controller.writeUsers();
				controller.writeClassNames();
			} else {
				System.out.println("class not removed!");
				// class removal unsuccessful -try again!
			}
		}
	}

        /**
         * this needs to validate if there is another username instance before changing username
         * @param evt 
         */
	private void changeUserNameButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
            if(studentManagerControlTabbedPane.getSelectedIndex()==1 && studentList.getSelectedIndex()>-1){
                    User student = null;
                    while(((DefaultTableModel) studentTable.getModel()).getRowCount()>0)
                        ((DefaultTableModel) studentTable.getModel()).removeRow(0);
                    for(User user:  controller.getStudentsInClass((String)classList.getSelectedValue())){
                        if(!user.isInstructor()&& user.getRealName().equals(studentList.getSelectedValue())&&
                                user.getClassName().equals(classList.getSelectedValue())){
                            student = user;
                            break;
                        }
                   
                    }
                    if(student!=null){
                    for(CompletedScenario completedScenario:((Student)student).getCompletedScenarios()){
                        ((DefaultTableModel) studentTable.getModel()).addRow(
                                new String[]{completedScenario.getScenarioTaken().getPatientName(),
                                    completedScenario.getDateTaken(),
                                    completedScenario.getEvaluationSuggestion(),
                                    ""+completedScenario.getScore()} );
                        
                    }
                    
                    String newUsername = JOptionPane.showInputDialog("Enter new userName");
                    if(newUsername!= null){
                        student.setUserName(newUsername);
                        controller.writeUsers();
                        studentManagerControlTabbedPane.setSelectedIndex(0);
                        studentManagerControlTabbedPane.setSelectedIndex(1);
                    }
                        
                    }
                }
            
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
					MaintenanceManagerGUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(
					MaintenanceManagerGUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(
					MaintenanceManagerGUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(
					MaintenanceManagerGUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		File n = new File(System.getProperty("user.dir"));

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new MaintenanceManagerGUI().setVisible(true);
			}
		});
	}

	/**
	 * Load all resources for this GUI.
	 */
	public void loadResources() {
	}

	/**
	 * This method updates the Scenario preview(the componentes of
	 * previewTabbedPane) by reloading the data stru
	 * 
	 * @param string
	 *            name of the scenario to load to the preview from data
	 *            structure.
	 */
	private void updateScenarioPreview(String string) {
		// scenarioListModel.addElement("Awsome");
	}

	@Override
	public void setVisible(boolean b) {
		// TODO implement loading Datastructer into this GUI.
		if (b) {
			loadResources();
                        rootTabbedPane.setSelectedIndex(1);
                       rootTabbedPane.setSelectedIndex(0);
		}
		super.setVisible(b);
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoginModLabel;
    private javax.swing.JScrollPane ScenarioScrollPane;
    private javax.swing.JLabel SimResultsAreaLabel;
    private javax.swing.JLabel SimulationScoreLabel;
    private javax.swing.JButton UndoAllChangesButton;
    private javax.swing.JButton ViewScenarioSuggestionButton;
    private javax.swing.JButton addClassButton;
    private javax.swing.JButton addMedicationButton;
    private javax.swing.JButton addNarrativeButton;
    private javax.swing.JButton addScenarioButton;
    private javax.swing.JButton addStudentButton;
    private javax.swing.JLabel addingAreaLabel;
    private javax.swing.JLabel allergiesLabel;
    private javax.swing.JScrollPane allergiesScrollPane;
    private javax.swing.JTextArea allergiesTextArea;
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JButton changeProffesorPasswordButton;
    private javax.swing.JButton changeUserNameButton;
    private javax.swing.JTable classControlJTable;
    private javax.swing.JPanel classControlPanel;
    private javax.swing.JScrollPane classControlScrollPane;
    private javax.swing.JList classList;
    private javax.swing.JScrollPane classScrollPane;
    private javax.swing.JLabel classScrollPaneLabel;
    private javax.swing.JLabel currentProfessorPasswordLabel;
    private javax.swing.JLabel currentProfessorUserNameLabel;
    private javax.swing.JLabel currentStudentPasswordLabel;
    private javax.swing.JLabel currentStudentUserNameLabel;
    private javax.swing.JLabel diagnosisLabel;
    private javax.swing.JScrollPane diagnosisScrollPane;
    private javax.swing.JTextArea diagnosisTextArea;
    private javax.swing.JPanel documentationPanel;
    private javax.swing.JScrollPane documentationScrollPane;
    private javax.swing.JTable documentationTable;
    private javax.swing.JButton exportScenarioButton;
    private javax.swing.JLabel importExportAreaLabel;
    private javax.swing.JButton importScenarioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JButton logOutButton;
    private javax.swing.JPanel marPanel;
    private javax.swing.JTable medJTable;
    private javax.swing.JScrollPane medScrollPane;
    private javax.swing.JLabel patientNameLabel;
    private javax.swing.JTextField patientNameTextField;
    private javax.swing.JTabbedPane previewTabbedPane;
    private javax.swing.JButton printButton;
    private javax.swing.JPanel professorLoginManager;
    private javax.swing.JLabel removalAreaLabel;
    private javax.swing.JButton removeAllButton;
    private javax.swing.JButton removeAllNarrativeButton;
    private javax.swing.JButton removeClassButton;
    private javax.swing.JButton removeMedicationButton;
    private javax.swing.JButton removeNarrativeButton;
    private javax.swing.JButton removeScenarioButton;
    private javax.swing.JButton removeStudentButton;
    private javax.swing.JLabel roomNumLabel;
    private javax.swing.JTextField roomNumberTextField;
    private javax.swing.JTabbedPane rootTabbedPane;
    private javax.swing.JButton saveChangesButton;
    private javax.swing.JList scenarioList;
    private javax.swing.JPanel scenarioManagerPanel;
    private javax.swing.JLabel scenarioPreviewLabel;
    private javax.swing.JScrollPane scenarioScrollPanel;
    private javax.swing.JLabel scenarioSummaryLabel;
    private javax.swing.JPanel scenarioSummaryPanel;
    private javax.swing.JTextPane scenarioSummaryTextPane;
    private javax.swing.JLabel selectScenarioLabel;
    private javax.swing.JLabel selectionArealabel;
    private javax.swing.JButton setScenarioScoreButton;
    private javax.swing.JPanel studentControlPanel;
    private javax.swing.JScrollPane studentControlScrollPane;
    private javax.swing.JList studentList;
    private javax.swing.JTabbedPane studentManagerControlTabbedPane;
    private javax.swing.JPanel studentManagerPanel;
    private javax.swing.JLabel studentNameLabel;
    private javax.swing.JScrollPane studentScrollPane;
    private javax.swing.JLabel studentScrollPaneLabel;
    private javax.swing.JTable studentTable;
    private javax.swing.JButton viewSelectedScenarioButton;
    // End of variables declaration//GEN-END:variables
}
