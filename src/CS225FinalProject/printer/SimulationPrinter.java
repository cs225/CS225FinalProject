package CS225FinalProject.printer;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JComponent;
import javax.swing.RepaintManager;

import CS225FinalProject.DataStructure.CompletedScenario;
import CS225FinalProject.DataStructure.Scenario;
import CS225FinalProject.DataStructure.Student;
import CS225FinalProject.GUI.MaintenanceManagerGUI;
import CS225FinalProject.GUI.SimulationGUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.*;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 * This class contains the methods for printing results USING JAVA API.
 * 
 * @author Eric
 */
public class SimulationPrinter implements Printable{
	private JComponent componentToBePrinted;
	
	public static void printComponent(JComponent c){
		new SimulationPrinter(c).print();
	}
	
	public SimulationPrinter(JComponent componentToBePrinted){
		this.componentToBePrinted = componentToBePrinted;
	}
	public void print() {
		PrinterJob printJob = PrinterJob.getPrinterJob();
		printJob.setPrintable(this);
		if (printJob.printDialog())
			try {
				printJob.print();
			} catch(PrinterException pe) {
				System.out.println("Error printing: " + pe);
			}
	}
	public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
		if (pageIndex > 0) {
			return(NO_SUCH_PAGE);
		} else {
			Graphics2D g2d = (Graphics2D)g;
			g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
			disableDoubleBuffering(componentToBePrinted);
			componentToBePrinted.paint(g2d);
			enableDoubleBuffering(componentToBePrinted);
			return(PAGE_EXISTS);
		}
	}

	public static void disableDoubleBuffering(Component c) {
		RepaintManager currentManager = RepaintManager.currentManager(c);
		currentManager.setDoubleBufferingEnabled(false);
	}

	public static void enableDoubleBuffering(Component c) {
		RepaintManager currentManager = RepaintManager.currentManager(c);
		currentManager.setDoubleBufferingEnabled(true);
	}
	
	public static void printScenario(Scenario scenario) {

	}

        /**
         * Fully implemented Student record
         * @param student
         * @param table 
         */
	public static void printStudentRecord(final Student student, final TableModel model , final TableColumnModel cmodel) {
            try {
			PrinterJob job = PrinterJob.getPrinterJob();
                        JTable table = new JTable(model,cmodel);
                        table.setVisible(true);
			PageFormat format = new PageFormat();
			format.setOrientation(PageFormat.LANDSCAPE);

                        Printable printable = table.getPrintable(JTable.PrintMode.FIT_WIDTH, 
                                new MessageFormat(
                                student.getRealName()+ " "+
                                student.getClassName()+
                                " Report as of "+new SimpleDateFormat("M-d-yy").format(Calendar.getInstance().getTime())), 
                                
                                new MessageFormat(
                                "Completed Scenarios:"+student.getCompletedScenarios().size()+
                                " Average Score: "+ (student.getAverageScore()==null?"not available":student.getAverageScore()) + 
                                " Page - {0}"));
                        
			job.setPrintable(printable, format);
			if (job.printDialog())
				job.print();
			
		} catch (PrinterException ex) {
			Logger.getLogger(SimulationGUI.class.getName()).log(Level.SEVERE,
					null, ex);
		}

	}

	public static void printCompletedScenario(final Student student, int completedScenarioIndex) {
           final CompletedScenario completedScenario = student.getCompletedScenarios().get(completedScenarioIndex);
           Book printBook = new Book();

          
           PageFormat format = new PageFormat();
           
           format.setOrientation(PageFormat.LANDSCAPE);
           SimulationGUI guiPrint = new SimulationGUI(completedScenario.getScenarioTaken(), completedScenario.getStudentInput());

           final BufferedImage image[] = new BufferedImage[2];
                   image[0] =new  BufferedImage(guiPrint.getRootTabbedPane().getWidth(),guiPrint.getRootTabbedPane().getHeight(), BufferedImage.TYPE_INT_ARGB);
                   image[1] =new  BufferedImage(guiPrint.getRootTabbedPane().getWidth(),guiPrint.getRootTabbedPane().getHeight(), BufferedImage.TYPE_INT_ARGB);

           Graphics g = image[0].createGraphics();
           guiPrint.setSelectedRootTabbedPaneIndex(1);
           guiPrint.getRootTabbedPane().paint(g);
           g.dispose();
           
            g = image[1].createGraphics();
           guiPrint.setSelectedRootTabbedPaneIndex(2);
           guiPrint.getRootTabbedPane().paint(g);
           g.dispose();

           
           Printable p1 = new Printable() {

            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if(pageIndex==0 ||pageIndex ==1 ){
                    ((Graphics2D)graphics).translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                    ((Graphics2D)graphics).scale(.6,.6);
                    ((Graphics2D)graphics).drawImage(image[0],0,0,null);
                    
                    ((Graphics2D)graphics).scale(1,1);
                     graphics.setFont(new Font(Font.SERIF, Font.BOLD, 12));
                     graphics.setColor(Color.black);
                    ((Graphics2D)graphics).drawString(
                            "Student Name: " + student.getRealName()+
                            " Class: "+student.getClassName()+
                            " Date Taken: "+ completedScenario.getDateTaken(),0,600);
                    return PAGE_EXISTS;
                }
                else
                    return Printable.NO_SUCH_PAGE;
            }
        };
           Printable p2= new Printable() {

            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if(pageIndex==1||pageIndex==2 ){
                    ((Graphics2D)graphics).translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                    ((Graphics2D)graphics).scale(.6,.6);
                    ((Graphics2D)graphics).drawImage(image[1 ],0,0,null);
                    return PAGE_EXISTS;
                }
                else
                    return Printable.NO_SUCH_PAGE;
            }
        };
           guiPrint.setVisible(false);
          
           String suggestion = completedScenario.getEvaluationSuggestion();
           ArrayList<StringBuffer> stringBuffers = new ArrayList<StringBuffer>();
           int index = 0;
           int counter = 0;
           char[] chars = suggestion.toCharArray();
           StringBuffer buffer = new StringBuffer("");
           while(index<chars.length){
               char c = chars[index];
               if(c=='\n'){
                   stringBuffers.add(buffer);
                   
                   buffer = new StringBuffer();    
                   counter=buffer.length();
               }
               else if( c!='\n' && counter==70){
                   buffer.append(""+c+"-");
                   stringBuffers.add(buffer);
                   
                   buffer = new StringBuffer("");
                   counter=buffer.length();
               }
               else if(c!='\n'&& counter<70){
                   buffer.append(c);
                   counter++;
                   if(index==chars.length-1){
                       stringBuffers.add(buffer);
                       break;
                   }
               }
               index++;
           }
           String suggestionPrint = new String();
           for(StringBuffer b: stringBuffers){
               //System.out.println(b.toString());
               suggestionPrint+="\n"+b;
           }
           
         
//           Pattern  pattern = Pattern.compile("[^\n{100,}?]");
//           String[] suggestionCut = suggestion.split(pattern.toString());
//           for(String string: suggestionCut){
//               System.out.println(string+"\n");
//           }
           
           JTextArea textArea = new JTextArea();
           textArea.setText(
                     "Student Name: "+student.getRealName()+"\n"
                   + "Class: "+student.getClassName()+"\n"
                   + "Scenario: "+completedScenario.getScenarioTaken().getPatientName()+"\n"
                   + "Taken on "+completedScenario.getDateTaken()+"\n"
                   + "Score: "+(completedScenario.getScore()==null? "not available":completedScenario.getScore())+"\n"
                   + "Suggestion and Notes:\n"
                   + suggestionPrint);
           
           
           Printable report = textArea.getPrintable(null, null);
           
           PageFormat format1 = new PageFormat();
           format1.setOrientation(PageFormat.PORTRAIT);
          //printBook.append(report, format1);
          //printBook.append(report, format1);
          printBook.append(p1,format);
          printBook.append(p2, format);

           PrinterJob job = PrinterJob.getPrinterJob();
          
           if(job.printDialog()){
               
            try {
               job.setPrintable(report,format1);
                job.print();
                if(JOptionPane.showConfirmDialog(
                        null, 
                        "Would you like to add additional visual represation of this student's input of this scenario?", 
                        null,JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){
                job.setPageable(printBook);
                job.print();
                }
            } catch (PrinterException ex) {
                Logger.getLogger(SimulationPrinter.class.getName()).log(Level.SEVERE, null, ex);
            }
               
           }

	}
}
