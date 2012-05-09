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
        result="";
        fileScan = new Scanner(input);

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

        if (fileScan.hasNext(unit)) {
            result += unit + "\n";
        }
        if (fileScan.hasNext(intUnit)) {
            result += intUnit + "\n";
        }
        if (fileScan.hasNext(daily)) {
            result += daily + "\n";
        }
        if (fileScan.hasNext(everyOther)) {
            result += everyOther + "\n";
        }
        if (fileScan.hasNext(trailing0)) {
            result += trailing0 + "\n";
        }
        if (fileScan.hasNext(morphine)) {
            result += morphine + "\n";
        }
        if (fileScan.hasNext(sulfate)) {
            result += sulfate + "\n";
        }
        if (fileScan.hasNext(magSulfate)) {
            result += magSulfate + "\n";
        }
        if (fileScan.hasNext(microgram)) {
            result += microgram + "\n";
        }
        if (fileScan.hasNext(halfStrength)) {
            result += halfStrength + "\n";
        }
        if (fileScan.hasNext(threeWeek)) {
            result += threeWeek + "\n";
        }
        if (fileScan.hasNext(subcutaneous1)) {
            result += subcutaneous1 + "\n";
        }
        if (fileScan.hasNext(subcutaneous2)) {
            result += subcutaneous2 + "\n";
        }
        if (fileScan.hasNext(discharge)) {
            result += discharge + "\n";
        }
        if (fileScan.hasNext(cubic)) {
            result += cubic + "\n";
        }
        if (fileScan.hasNext(rightEar)) {
            result += rightEar + "\n";
        }
        if (fileScan.hasNext(leftEar)) {
            result += leftEar + "\n";
        }
        if (fileScan.hasNext(bothEars)) {
            result += bothEars + "\n";
        }
        if (fileScan.hasNext(rightEye)) {
            result += rightEye + "\n";
        }
        if (fileScan.hasNext(leftEye)) {
            result += leftEye + "\n";
        }
        if (fileScan.hasNext(bothEyes)) {
            result += bothEyes + "\n";
        }

        return result;

    }
}
