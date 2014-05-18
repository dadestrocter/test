// Danny Thai
// 10/22/13
// CSE142
// TA:  Cody Gibb
// Assignment #3 Admit
//
// This program will give a user information about two applicants and compute their individual overall score.

import java.util.*; // so I can use Scanner

public class Admit {
   public static void main(String[] args) {
      giveIntro();
      Scanner console = new Scanner(System.in);
      System.out.println("Information for applicant #1:");
         double firstApp = App(console);
      System.out.println("Information for applicant #2:");
         double secondApp = App(console);
      result(firstApp, secondApp);
   }
   
   // Introduces the program to the user
   public static void giveIntro() {
      System.out.println("This program compares two applicants to determine");
      System.out.println("which one seems like the stronger applicant. For");
      System.out.println("each candidate I will need either SAT or ACT scores");
      System.out.println("plus a weighted GPA.");
      System.out.println();
   }
   
   // Prompts user for one person's SAT or ACT scores and their overall GPA, returning the result
   public static double App(Scanner console) {
      System.out.print("   Do you have 1) SAT scores or 2) ACT scores? ");
      int satOrAct = console.nextInt();
      if (satOrAct == 1) {
         double satExam = askSat(console);
         double gpaScore = askGpa(console);
         return round1(satExam + gpaScore);
      } else if (satOrAct == 2) {
         double actExam = askAct(console);
         double gpaScore = askGpa(console);
         return round1(actExam + gpaScore);
      } else { // Anything other than 1 or 2
         System.out.println("Sorry, that was not an option.");
         System.out.println();
      }
      return satOrAct;
   }
   
   // Questions the user about SAT scores if selected 1
   public static double askSat(Scanner console) {
      System.out.print("   SAT Math? ");
      int satMath = console.nextInt();
      System.out.print("   SAT Critical Reading? ");
      int satCrit = console.nextInt();
      System.out.print("   SAT Writing? ");
      int satWrite = console.nextInt();
      double satExam = satScore(satMath, satCrit, satWrite);
      System.out.println("   Exam Score = " + satExam);
      return satExam;
   }
   
   // Questions the user about ACT scores if selected 2
   public static double askAct(Scanner console) {
      System.out.print("   ACT English? ");
      int actEng = console.nextInt();
      System.out.print("   ACT Math? ");
      int actMath = console.nextInt();
      System.out.print("   ACT Reading? ");
      int actRead = console.nextInt();
      System.out.print("   ACT Science? ");
      int actSci = console.nextInt();
      double actExam = actScore(actEng, actMath, actRead, actSci);
      System.out.println("   Exam Score = " + round1(actExam));
      return actExam;
   }
   
   // Questions the user about overall GPA, max GPA, and transcript multiplier
   public static double askGpa(Scanner console) {
      System.out.print("   Overall GPA? ");
      double overGpa = console.nextDouble();
      System.out.print("   Max GPA? ");
      double maxGpa = console.nextDouble();
      System.out.print("   Transcript Multiplier? ");
      double transMulti = console.nextDouble();
      double gpaScore = finalGpa(overGpa, maxGpa, transMulti);
      System.out.println("   GPA Score = " + round1(gpaScore));
      System.out.println();
      return gpaScore;
   }
   
   // Calculates the overall exam score for an applicant with SAT scores
   public static double satScore(int satMath, int satCrit, int satWrite) {
      return round1(((2*satMath)+satCrit+satWrite) / 32.0);
   }
   
   // Calculates the overall exam score for an applicant with ACT scores
   public static double actScore(int actEng, int actMath, int actRead, int actSci) {
      return (actEng + (2*actMath) + actRead + actSci)/1.8;
   }
   
   // Calculates the final GPA, taking into consideration their transcript multiplier
   public static double finalGpa(double overGpa, double maxGpa, double transMulti) {
      return (overGpa/maxGpa)*100*transMulti;
   }
   
   // Rounds n to 1 digits after the decimal point
   public static double round1(double n) {
      return Math.round(n * 10.0) / 10.0;
   }
   
   // Reports both of the applicant's overall score and which applicant is better or if they're equal
   public static void result(double firstApp, double secondApp) {
      System.out.println("First applicant's overall score  = " + firstApp);
      System.out.println("Second applicant's overall score = " + secondApp);
      if (firstApp > secondApp) {
         System.out.println("The first applicant seems to be better");
      } else if (firstApp < secondApp){
         System.out.println("The second applicant seems to be better");
      } else {
         System.out.println("The two applicants seem to be equal");
      }
   }
}