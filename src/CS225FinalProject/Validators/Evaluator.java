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
            bothEars, leftEye, rightEye, bothEyes;

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
        return "Student wrote: "+ unit;
    else if(fileScan.hasNext(intUnit))
        return  "Student wrote: "+ intUnit;
    else if(fileScan.hasNext(daily))
        return  "Student wrote: "+ daily;
    else if(fileScan.hasNext(everyOther))
        return  "Student wrote: "+ everyOther;
    else if(fileScan.hasNext(trailing0))
        return  "Student wrote: "+ trailing0;
    else if(fileScan.hasNext(morphine))
        return  "Student wrote: "+ morphine;
    else if(fileScan.hasNext(sulfate))
        return  "Student wrote: "+ sulfate;
    else if(fileScan.hasNext(magSulfate))
        return  "Student wrote: "+ magSulfate;
    else if(fileScan.hasNext(microgram))
        return  "Student wrote: "+ microgram;
    else if(fileScan.hasNext(halfStrength))
        return  "Student wrote: "+ halfStrength;
    else if(fileScan.hasNext(threeWeek))
        return  "Student wrote: "+ threeWeek;
    else if(fileScan.hasNext(subcutaneous1))
        return  "Student wrote: "+ subcutaneous1;
    else if(fileScan.hasNext(subcutaneous2))
        return  "Student wrote: "+ subcutaneous2;
    else if(fileScan.hasNext(discharge))
        return  "Student wrote: "+ discharge;
    else if(fileScan.hasNext(cubic))
        return  "Student wrote: "+ cubic;
    else if(fileScan.hasNext(rightEar))
        return  "Student wrote: "+ rightEar;
    else if(fileScan.hasNext(leftEar))
        return  "Student wrote: "+ leftEar;
    else if(fileScan.hasNext(bothEars))
        return  "Student wrote: "+ bothEars;
    else if(fileScan.hasNext(rightEye))
        return  "Student wrote: "+ rightEye;
    else if(fileScan.hasNext(leftEye))
        return  "Student wrote: "+ leftEye;
    else if(fileScan.hasNext(bothEyes))
        return  "Student wrote: "+ bothEyes;
    
    else
        return "No errors from JAHCO";
    }
}

