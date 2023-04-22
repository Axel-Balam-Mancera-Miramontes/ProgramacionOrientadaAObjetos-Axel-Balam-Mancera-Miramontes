package edu.axel.balam.mancera.miramontes.reto11.classes;

import java.util.List;

/**
 * The JrEngineer class includes the attributes that are necessary to represent a junior engineer.
 */
public class JrEngineer extends Employee implements Programmer {
    /**
     * Modificar la clase JrEngineer para que tenga un atributo adicional, (String RFC).
     * (en total tendría al menos 3, nombre y edad heredados de Empleado y esta nueva adición)
     */
    public String RFC;
    public List<String> tecnologias;
    public String proyectoActual;

    /**
     * trabajar: executes the junior engineer's job.
     */
    @Override
    public void trabajar() {
        System.out.println("trabajar - JrEngineer.");
    }

    /**
     * trabajar: generates the solicited code.
     */
    @Override
    public void programar() {
        System.out.println("programar - JrEngineer.");
    }

}
