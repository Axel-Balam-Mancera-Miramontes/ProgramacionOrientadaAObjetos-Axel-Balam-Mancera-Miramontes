package edu.axel.balam.mancera.miramontes.reto11.classes;

/**
 * The Employee class includes the attributes that are necessary to represent an employee.
 * As it's an abstract class, some of its methods will be overriden by its subclasses.
 */
public abstract class Employee {
    private String nomina;
    private String fechaContratacion;
    private double salario;
    public String nombre;
    public String email;
    public short edad;

    /**
     * trabajar: this method will be overriden by Employee's subclasses.
     */
    public abstract void trabajar();

}
