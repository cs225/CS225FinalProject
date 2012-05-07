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
        result += unit;
    else if(fileScan.hasNext(intUnit))
        result += intUnit;
    else if(fileScan.hasNext(daily))
        result += daily;
    else if(fileScan.hasNext(everyOther))
        result += everyOther;
    else if(fileScan.hasNext(trailing0))
        result += trailing0;
    else if(fileScan.hasNext(morphine))
        result += morphine;
    else if(fileScan.hasNext(sulfate))
        result += sulfate;
    else if(fileScan.hasNext(magSulfate))
        result += magSulfate;
    else if(fileScan.hasNext(microgram))
        result += microgram;
    else if(fileScan.hasNext(halfStrength))
        result += halfStrength;
    else if(fileScan.hasNext(threeWeek))
        result += threeWeek;
    else if(fileScan.hasNext(subcutaneous1))
        result += subcutaneous1;
    else if(fileScan.hasNext(subcutaneous2))
        result += subcutaneous2;
    else if(fileScan.hasNext(discharge))
        result += discharge;
    else if(fileScan.hasNext(cubic))
        result += cubic;
    else if(fileScan.hasNext(rightEar))
        result += rightEar;
    else if(fileScan.hasNext(leftEar))
        result += leftEar;
    else if(fileScan.hasNext(bothEars))
        result += bothEars;
    else if(fileScan.hasNext(rightEye))
        result += rightEye;
    else if(fileScan.hasNext(leftEye))
        result += leftEye;
    else if(fileScan.hasNext(bothEyes))
        result += bothEyes;
    
    return result;
    
    }
}

