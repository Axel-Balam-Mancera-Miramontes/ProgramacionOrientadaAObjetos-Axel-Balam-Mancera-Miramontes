package edu.axel.balam.mancera.miramontes.reto10.classes;

/**
 * The Manager class includes the attributes that are necessary to represent a manager.
 */
public class Manager extends Employee implements Interviewer{
    String area;

    /**
     * trabajar: executes the manager's job.
     */
    @Override
    public void trabajar() {
        System.out.println("trabajar - Manager.");
    }

    /**
     * interview: asks the questions of the interview.
     */
    @Override
    public void interview() {
        System.out.println("interview - Manager.");
    }
}
