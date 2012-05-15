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
        fileScan = new Scanner(input);
        fileScan.nextLine();
        String dosage = fileScan.nextLine();
      
        unit = "u";
        intUnit = "iu";
        daily = "Q.D.";
        everyOther = "Q.O.D.";
        trailing0 = ".0";
        morphine = "MS";
        sulfate = "MSO4";
        magSulfate = "MgSO4";
        microgram = "ug";
        halfStrength = "H.S.";
        threeWeek = "T.I.W.";
        subcutaneous1 = "S.C.";
        subcutaneous2 = "S.Q.";
        discharge = "D/C";
        cubic = "c.c.";
        rightEar = "A.S.";
        leftEar = "A.D.";
        bothEars = "A.U.";
        rightEye = "O.S.";
        leftEye = "O.D.";
        bothEyes = "O.U.";

        System.out.println(input);
        if (dosage.contains(unit)) {
            result += unit + "\n";
        }
        if (dosage.contains(intUnit)) {
            result += intUnit + "\n";
        }
        if (dosage.contains(daily)) {
            result += daily + "\n";
        }
        if (dosage.contains(everyOther)) {
            result += everyOther + "\n";
        }
        if (dosage.contains(trailing0)) {
            result += trailing0 + "\n";
        }
        if (dosage.contains(morphine)) {
            result += morphine + "\n";
        }
        if (dosage.contains(sulfate)) {
            result += sulfate + "\n";
        }
        if (dosage.contains(magSulfate)) {
            result += magSulfate + "\n";
        }
        if (dosage.contains(microgram)) {
            result += microgram + "\n";
        }
        if (dosage.contains(halfStrength)) {
            result += halfStrength + "\n";
        }
        if (dosage.contains(threeWeek)) {
            result += threeWeek + "\n";
        }
        if (dosage.contains(subcutaneous1)) {
            result += subcutaneous1 + "\n";
        }
        if (dosage.contains(subcutaneous2)) {
            result += subcutaneous2 + "\n";
        }
        if (dosage.contains(discharge)) {
            result += discharge + "\n";
        }
        if (dosage.contains(cubic)) {
            result += cubic + "\n";
        }
        if (dosage.contains(rightEar)) {
            result += rightEar + "\n";
        }
        if (dosage.contains(leftEar)) {
            result += leftEar + "\n";
        }
        if (dosage.contains(bothEars)) {
            result += bothEars + "\n";
        }
        if (dosage.contains(rightEye)) {
            result += rightEye + "\n";
        }
        if (dosage.contains(leftEye)) {
            result += leftEye + "\n";
        }
        if (dosage.contains(bothEyes)) {
            result += bothEyes + "\n";
        }

        return result;

    }
}
