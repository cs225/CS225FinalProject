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
            bothEars, leftEye, rightEye, bothEyes, result, dosage;

    public static String giveSuggestion(String input) {
        dosage = "";
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
        result="";
        String err = "";
      //  System.out.println(input);
        fileScan = new Scanner(input);
        
     // System.out.println(dosage);
      
      /**
       * this loop is implemented by 
       * @author Eric Santana
       */
      while(fileScan.hasNextLine()){
          String line = fileScan.nextLine();
          String[] words = line.split("([\\s|\\n])+");//([\\s|\\n]+?)
          for(String word: words){
              //System.out.println(word.trim());
              if(!word.equals("")){
                  if(unit.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(intUnit.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(daily.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(everyOther.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(trailing0.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(morphine.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(sulfate.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(magSulfate.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(microgram.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(halfStrength.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(threeWeek.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(subcutaneous1.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(subcutaneous2.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(discharge.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(cubic.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(rightEar.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(leftEar.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(bothEars.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(rightEye.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(leftEye.equalsIgnoreCase(word))
                      err+=word+"\n";
                  else if(bothEyes.equalsIgnoreCase(word))
                      err+=word+"\n";
                  
//                  else if( PATTERN fits the word){
//                      err+= word;
//                  }
              }
              
          }
          
          
      }

      if(!err.equals(""))
              return ""+err;
          else
              return "";
        

    }
}
