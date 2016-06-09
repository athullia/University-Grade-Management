package finalProjectGrade;
/**
 * @author Athullia Paulose
 * Description: LetterGrade class where all 
 * the functions are implemented
 */
	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Scanner;

	public class LetterGrade {
		File inputFile;  
		File outputFile;

		private double total;
		private String name;
		private String[] marks ;
		private String[] singleRecord;
		
		/**Array list for storing records
		 * are created.
		 * 
		 * **/
		ArrayList<String> records = new ArrayList<String>();
		ArrayList<Integer> quiz1 = new ArrayList<Integer>();
		ArrayList<Integer> quiz2 = new ArrayList<Integer>();
		ArrayList<Integer> quiz3 = new ArrayList<Integer>();
		ArrayList<Integer> quiz4 = new ArrayList<Integer>();
		ArrayList<Integer> midterm1 = new ArrayList<Integer>();
		ArrayList<Integer> midterm2 = new ArrayList<Integer>();
		ArrayList<Integer> finalMarks = new ArrayList<Integer>();
		ArrayList<Character> grade = new ArrayList<Character>();
		ArrayList<Double> totalMarks = new ArrayList<Double>();
		ArrayList<String> nameString = new ArrayList<String>();
		
		/**
		 * 
		 * @param tempargs1 gets the input file 
		 * @param tempargs2 gets the output file
		 */
		LetterGrade(String tempargs1,String tempargs2){
			inputFile = new File(tempargs1);
			outputFile = new File(tempargs2);
		}
		/**
		 * The  data from the input file is read here.
		 */
		public void readScore(){
			try (Scanner in = new Scanner(inputFile);){
				while (in.hasNextLine()) {	//while loop for reading all the data in the input file to records list
					records.add(in.nextLine());
				}
	        Collections.sort(records);		//Sorts the list 
	        	for (int i = 0; i < records.size(); i++) {		        //accessing each line of data 
	        		singleRecord = records.get(i).split(",\t");			//extracting name and marks from input file
	            	nameString.add(singleRecord[0]);
	            	marks = singleRecord[1].split(",",7);
	                
	            	// Finding the sum of the marks of a student
	            	total = Double.parseDouble(marks[0].trim()) * 0.10 + Double.parseDouble(marks[1].trim()) * 0.10 +
	                		Double.parseDouble(marks[2].trim()) * 0.10  + Double.parseDouble(marks[3].trim()) * 0.10 +
	                		Double.parseDouble(marks[4].trim()) * 0.20 +Double.parseDouble(marks[5].trim()) * 0.15 +
	                		Double.parseDouble(marks[6].trim()) * 0.25 ;
	            	totalMarks.add(Math.floor(total));
	            	//Adding marks in each exams to corresponding lists in integer format
	            	quiz1.add(Integer.parseInt(marks[0].trim()));//marks of quiz1
	            	quiz2.add(Integer.parseInt(marks[1].trim()));
	            	quiz3.add(Integer.parseInt(marks[2].trim()));
	            	quiz4.add(Integer.parseInt(marks[3].trim()));
	            	midterm1.add(Integer.parseInt(marks[4].trim()));
	            	midterm2.add(Integer.parseInt(marks[5].trim()));
	            	finalMarks.add(Integer.parseInt(marks[6].trim()));
	            	
	            }
	            in.close();
			}catch (IOException exe) {
				 System.out.println("File not found");
			}
		}
		/**
		 * Function to calculate the grade of each student
		 * Adding the grade to list grade
		 */
		public void calcLetterGrade(){			
			for(int k=0;k<records.size();k++){
				if (totalMarks.get(k) >= 90) 
	        		grade.add('A');
	        	else if (totalMarks.get(k) >= 80 && totalMarks.get(k) <= 89) 
	        		grade.add('B');
	            else if (totalMarks.get(k) >= 70 && totalMarks.get(k) <= 79) 
	            	grade.add('C');
	            else if (totalMarks.get(k) >= 60 && totalMarks.get(k) <= 69) 
	            	grade.add('D');
	            else
	            	grade.add('F');
	        }
		}
	         
		/**
		 * writes the name and grade to the output file
		 */
		public void printGrade(){
			try(FileWriter file= new FileWriter(outputFile); PrintWriter out=new PrintWriter(file);){
				for(int k=0;k<records.size();k++){
					out.print(nameString.get(k) + ":\t");
					out.println("\t" + grade.get(k));
			}out.close();

			}catch (IOException exe) {
				System.out.println("File not found");
			}

		}
		/**
		 * 
		 * @param marks, gets the corresponding exams mark
		 * calculates the average of each fields
		 * @return
		 */
		public double average(ArrayList<Integer> marks) {
			double total = 0.0;
			for (int i = 0; i < marks.size(); i++) {
				total = total+marks.get(i);
			}
			return (total / marks.size());
		}
		/**
		 * prints the maximum, minimum and average of corresponding fields
		 */
		public void displayAverages(){	
			
			System.out.println("\t" + "     " + "Q1\t\tQ2\tQ3\tQ4\tMidI\tMidII\tFinal");
			
			//Printing average to the console
	        System.out.printf("Average:     %4.2f\t%4.2f\t%4.2f\t%4.2f\t%4.2f\t%4.2f\t%4.2f",average(quiz1),average(quiz2),average(quiz3),
	        average(quiz4),average(midterm1),average(midterm2),average(finalMarks));
	        System.out.println();
	        
	        //Printing minimum to the console
	        System.out.println("Minimum:     " + Collections.min(quiz1) + "\t\t" + Collections.min(quiz2) + "\t" + Collections.min(quiz3)
	                + "\t" + Collections.min(quiz4) + "\t" + Collections.min(midterm1) + "\t" + Collections.min(midterm2) + "\t" + Collections.min(finalMarks));
	       
	        //Printing minimum to the console
	        System.out.println("Maximum:     " + Collections.max(quiz1) + "\t" + Collections.max(quiz2) + "\t" + Collections.max(quiz3)
	                 + "\t" +Collections.max(quiz4) + "\t" + Collections.max(midterm1) + "\t" + Collections.max(midterm2) + "\t" + Collections.max(finalMarks));

	    }
			public void doCleanUp(){
			//closed all files in each modules
			}

	}


