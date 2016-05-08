/*****************************************************
 * Group 3: Lisa Taylor, Nathanael Toporek, Anh Tran *
 * TCSS 360, Spring 2016                             *
 * Deliverable #2                                    *
 *****************************************************/

package view;

import java.util.ArrayList;
import java.util.Scanner;

/** 
 * Class that provides the UI menus for a Reviewer. 
 * 
 * @author Lisa Taylor
 * @version 7 May 2016
 */
public class ReviewerUI {

    /** The name of the conference. */
    private String myConference;
    
    /** The name of the user. */
    private String myName;
    
    /** The list of manuscripts the Author has submitted to a conference. */
    private ArrayList<Manuscript> myManuscripts;
    
    /** Holds the current menu choice selection. */
    private int mySelection;
    
    public ReviewerUI(final String theConference, final String theName,
                      final ArrayList<Manuscript> theManuscripts) {
        myConference = theConference;
        myName = theName;
        myManuscripts = theManuscripts;
        mySelection = 0;
    }
    
    /** Prints out the header information. */
    public void printHeader() {
        System.out.println();
        System.out.println(myConference);
        System.out.println("User: " + myName);
    }
    
    /**
     * Displays the main menu selections.
     */
    public void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        printHeader();
        System.out.println(" Reviewer Options");
        System.out.println(" ----------------------");
        System.out.println(" 1) Submit Reviews");
        System.out.println(" 2) Logout");
        System.out.println();
        do {
            System.out.println("\nPlease enter a selection: ");
            try {
                mySelection = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Invalid Entry. Must enter a valid corresponding integer. ");
            }
            if (mySelection < 1 || mySelection > 2)
                System.out.println("Invalid Entry. Must enter a valid corresponding integer.");
        } while (mySelection < 0 || mySelection > 2);
        scanner.close();
        switch(mySelection) {
            case 1:
                displaySubmitReviewsMenu();
                break;
            case 2:
                //Code here?
                break;
        }
    }
    
    public void displaySubmitReviewsMenu() {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        System.out.println(" Assigned Manuscripts");
        System.out.println(" ---------------------");
        for( Manuscript paper : myManuscripts ) {
            System.out.println(" \"" + ++counter + ") " + paper.getTitle() + "\"");
            System.out.println();
        }
        do {
            System.out.println("Enter the number of the Manuscript to be assigned: ");
            try {
                mySelection = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Invalid Entry. Must enter a valid corresponding integer.");
            }
            if (mySelection < 1 || mySelection > counter)
                System.out.println("Invalid Entry. Must enter a valid corresponding integer.");
        } while (mySelection < 1 || mySelection > counter);
        System.out.println("Submitting review for " + myManuscripts.get(mySelection).getTitle());
        System.out.println();
        System.out.println("Please enter the full pathname for the review to be submitted: ");
        String filename = scanner.nextLine();
        try {
            //Code here
        } catch (Exception e) {  //Can change the exception one known what type will be thrown
            System.out.println("Invalid pathname. File could not be found.");
            System.out.println();
            displayMainMenu();
        }
        System.out.println("Review submitted successfully.");
        System.out.println();
        displayMainMenu();
    }
}