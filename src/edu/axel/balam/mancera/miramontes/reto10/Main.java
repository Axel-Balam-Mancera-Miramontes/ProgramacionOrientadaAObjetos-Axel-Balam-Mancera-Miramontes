package edu.axel.balam.mancera.miramontes.reto10;

import edu.axel.balam.mancera.miramontes.reto10.classes.*;

public class Main {

    //The only purpose of the following methods is to prove the existence of polimorphism through their implementation.
    /**
     * testEmployee: takes objects of the Employee's subclasses in order to execute the methods they inherit
     * in order to prove the existence of polymorphism.
     */
    public static void testEmployee(Employee employee){
        employee.trabajar();
    }
    /**
     * testInterviewer: takes objects of the Interviewer's subclasses in order to execute the methods they inherit
     * in order to prove the existence of polymorphism.
     */
    public static void testInterviewer(Interviewer interviewer){
        interviewer.interview();
    }

    /**
     * testProgrammer: takes objects of the Programmer's subclasses in order to execute the methods they inherit
     * in order to prove the existence of polymorphism.
     */
    public static void testProgrammer(Programmer programmer){
        programmer.programar();
    }

    public static void main(String[] args) {
        CEO ceo = new CEO();
        HR hr = new HR();
        JrEngineer jrEngineer = new JrEngineer();
        Manager manager = new Manager();
        SrEngineer srEngineer = new SrEngineer();

        Programmer programmer = new JrEngineer();
        Employee employee = new Manager();
        Interviewer interviewer = new HR();

        testEmployee(jrEngineer);
        testEmployee(manager);
        testInterviewer(hr);
        testInterviewer(manager);
        testProgrammer(jrEngineer);
        testProgrammer(srEngineer);
    }
}
