package CS225FinalProject.Validators;
//basically you can use data 
//object to access SimulationDataStructure
// for example data.validateLogIn() right away without initialize;

import static CS225FinalProject.SimulationManager.*;
import java.util.Scanner;


import javax.swing.JTable;

/**
 * 
 * @author Kevin Mee
 */
public class Evaluator {

    private static Scanner fileScan;
    private static String unit, intUnit, daily, everyOther, trailing0, morphine,
            sulfate, magSulfate, microgram, halfStrength, threeWeek,
            subcutaneous1, subcutaneous2, discharge, cubic, rightEar, leftEar,
            bothEars, leftEye, rightEye, bothEyes, result;

    public static String giveSuggestion(String input) {
        result="The potential JCAHO errors are: ";
        System.out.println(input);
        fileScan = new Scanner(input);
        System.out.println(input);
        fileScan.nextLine();
        String dosage = fileScan.nextLine();
      
        unit = "u";
        intUnit = "iu";
        daily = "q.d.";
        everyOther = "q.o.d.";
        trailing0 = ".0";
        morphine = "ms";
        sulfate = "mso4";
        magSulfate = "mgso4";
        microgram = "ug";
        halfStrength = "h.s.";
        threeWeek = "t.i.w.";
        subcutaneous1 = "s.c.";
        subcutaneous2 = "s.q.";
        discharge = "d/c";
        cubic = "c.c.";
        rightEar = "a.s.";
        leftEar = "a.d.";
        bothEars = "a.u.";
        rightEye = "o.s.";
        leftEye = "o.d.";
        bothEyes = "o.u.";

        System.out.println(input);
        if (dosage.toLowerCase().contains(unit)) {
            result += unit + "\n";
        }
        if (dosage.toLowerCase().contains(intUnit)) {
            result += intUnit + "\n";
        }
        if (dosage.toLowerCase().contains(daily)) {
            result += daily + "\n";
        }
        if (dosage.toLowerCase().contains(everyOther)) {
            result += everyOther + "\n";
        }
        if (dosage.toLowerCase().contains(trailing0)) {
            result += trailing0 + "\n";
        }
        if (dosage.toLowerCase().contains(morphine)) {
            result += morphine + "\n";
        }
        if (dosage.toLowerCase().contains(sulfate)) {
            result += sulfate + "\n";
        }
        if (dosage.toLowerCase().contains(magSulfate)) {
            result += magSulfate + "\n";
        }
        if (dosage.toLowerCase().contains(microgram)) {
            result += microgram + "\n";
        }
        if (dosage.toLowerCase().contains(halfStrength)) {
            result += halfStrength + "\n";
        }
        if (dosage.toLowerCase().contains(threeWeek)) {
            result += threeWeek + "\n";
        }
        if (dosage.toLowerCase().contains(subcutaneous1)) {
            result += subcutaneous1 + "\n";
        }
        if (dosage.toLowerCase().contains(subcutaneous2)) {
            result += subcutaneous2 + "\n";
        }
        if (dosage.toLowerCase().contains(discharge)) {
            result += discharge + "\n";
        }
        if (dosage.toLowerCase().contains(cubic)) {
            result += cubic + "\n";
        }
        if (dosage.toLowerCase().contains(rightEar)) {
            result += rightEar + "\n";
        }
        if (dosage.toLowerCase().contains(leftEar)) {
            result += leftEar + "\n";
        }
        if (dosage.toLowerCase().contains(bothEars)) {
            result += bothEars + "\n";
        }
        if (dosage.toLowerCase().contains(rightEye)) {
            result += rightEye + "\n";
        }
        if (dosage.toLowerCase().contains(leftEye)) {
            result += leftEye + "\n";
        }
        if (dosage.toLowerCase().contains(bothEyes)) {
            result += bothEyes + "\n";
        }

        return result;

    }
}
