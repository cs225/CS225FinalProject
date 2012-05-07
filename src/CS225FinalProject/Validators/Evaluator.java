package CS225FinalProject.Validators;
//basically you can use data 
//object to access SimulationDataStructure
// for example data.validateLogIn() right away without initialize;

import static CS225FinalProject.SimulationManager.*;
import java.util.Scanner;


import javax.swing.JTable;

/**
 */
public class Evaluator {
    private Scanner fileScan;
    private String unit, intUnit, daily, everyOther, trailing0, morphine, 
            sulfate, magSulfate, microgram, halfStrength, threeWeek,
            subcutaneous1, subcutaneous2, discharge, cubic, rightEar, leftEar, 
            bothEars, leftEye, rightEye, bothEyes, result;

    public String giveSuggestion(String input){
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
    
    if(fileScan.hasNext(unit))
        return result += unit;
    else if(fileScan.hasNext(intUnit))
        return result += intUnit;
    else if(fileScan.hasNext(daily))
        return result += daily;
    else if(fileScan.hasNext(everyOther))
        return result += everyOther;
    else if(fileScan.hasNext(trailing0))
        return result += trailing0;
    else if(fileScan.hasNext(morphine))
        return result += morphine;
    else if(fileScan.hasNext(sulfate))
        return result += sulfate;
    else if(fileScan.hasNext(magSulfate))
        return result += magSulfate;
    else if(fileScan.hasNext(microgram))
        return result += microgram;
    else if(fileScan.hasNext(halfStrength))
        return result += halfStrength;
    else if(fileScan.hasNext(threeWeek))
        return result += threeWeek;
    else if(fileScan.hasNext(subcutaneous1))
        return result += subcutaneous1;
    else if(fileScan.hasNext(subcutaneous2))
        return result += subcutaneous2;
    else if(fileScan.hasNext(discharge))
        return result += discharge;
    else if(fileScan.hasNext(cubic))
        return result += cubic;
    else if(fileScan.hasNext(rightEar))
        return result += rightEar;
    else if(fileScan.hasNext(leftEar))
        return result += leftEar;
    else if(fileScan.hasNext(bothEars))
        return result += bothEars;
    else if(fileScan.hasNext(rightEye))
        return result += rightEye;
    else if(fileScan.hasNext(leftEye))
        return result += leftEye;
    else if(fileScan.hasNext(bothEyes))
        return result += bothEyes;
    
    else
        return "No errors from JAHCO";
    }
}

