package finalProjectGrade;
/**
 * 
 * @author Athullia Paulose
 * Description: This application take two input files 
 * 			as command line arguments , which is the details
 * 			of students with marks in different exams.
 * 			The program finds the average,maximum and minimum 
 * 			of all the exams in the console.
 * 			It also finds the grade of each student and 
 * 			write the name and grade to the output 
 * 			file after sorting
 */

public class TestLetterGrade {
	
	public static void main(String args[]){
			// proceed because you found two arguments
			// check if user gave the command line arguments
			if (args.length == 2) {
				System.out.println("Input will be read from:"+
                        args[0] +
               "\nOutput will be written into: " +
                        args[1]);
				System.out.println();
				
	        } else {
	        	System.out.println("Usage: java TestLetterGrade inputFile outputFile");
	            System.exit(1);
	        	
	        }
			// Creating object of the LetterGrade class and invokes constructor
			LetterGrade letterGrader = new LetterGrade(args[0],args[1]);
			 
			letterGrader.readScore(); 			//Function call to read Scores
			letterGrader.calcLetterGrade(); 	//Function call to calculate grade
			letterGrader.printGrade();			//Function call to print grade
			letterGrader.displayAverages();		//Function call to display average
			letterGrader.doCleanUp();			
		}
}
