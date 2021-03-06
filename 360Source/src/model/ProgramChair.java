/*****************************************************
 * Group 3: Lisa Taylor, Nathanael Toporek, Anh Tran *
 * TCSS 360, Spring 2016                             *
 * Deliverable #3                                    *
 *****************************************************/

package model;

import java.io.Serializable;
import java.util.ArrayList;

import enums.AcceptanceStatus;

/** 
 * Class that provides the UI menus for a Program Chair. 
 * 
 * @author Lisa Taylor
 * @version 7 May 2016
 */
public class ProgramChair implements Serializable {

	private static final long serialVersionUID = -4256379357013407968L;

	/** The list of Subprogram Chairs. */
    private ArrayList<String> mySPCs;
    
    private String myUsername;
    /** Constructs a ProgramChair object. 
     * 
     * @param theSPCs the Subprogram Chairs
     */
    public ProgramChair(String uname, ArrayList<String> theSPCs) {
        mySPCs = theSPCs;
        myUsername = uname;
    }
    /**
     * Returns the program chair's username.
     * @return Program chair's username.
     */
    public String getUsername() {
    	return myUsername;
    }
    
    /** Adds a designated registered user to the list of Subprogram Chairs. 
     * 
     * @param the registered user
     */
    public void addSPC(String username) {
        mySPCs.add(username);
    }
    
    /** Returns a list of Subprogram Chairs. */
    public ArrayList<String> getSPCS() {
        return mySPCs;
    }
    
    /** Assigns a Manuscript to a Subprogram Chair. 
     * 
     * @param index the index of the SPC the Manuscript is being assigned to
     * @param paper the Manuscript to be assigned
     */
    public void assignManuscriptToSPC(final SubprogramChair subPC, Manuscript paper) {
        paper.setSPCsUsername(subPC.getUserName());;
    }
    
    /** Accepts or rejects a Manuscript. 
     * 
     * @param paper the Manuscript being accepted or rejected
     * @param decision the acceptance or rejection of the Manuscript
     * @return the updated Manuscript
     */
    public void acceptOrRejectManuscript(final Manuscript paper, final AcceptanceStatus decision) {
        paper.setAcceptance(decision);
    }
}
