package edu.axel.balam.mancera.miramontes.reto12.classes;

/**
 * The HR class includes the attributes that are necessary to represent a human resources agent.
 */
public class HR extends Employee implements Interviewer {

    /**
     * trabajar: executes the interviewer's job.
     */
    @Override
    public void trabajar() {
        System.out.println("trabajar - HR.");
    }

    /**
     * interview: asks the questions of the interview.
     */
    @Override
    public void interview() {
        System.out.println("interview - HR.");
    }
}
