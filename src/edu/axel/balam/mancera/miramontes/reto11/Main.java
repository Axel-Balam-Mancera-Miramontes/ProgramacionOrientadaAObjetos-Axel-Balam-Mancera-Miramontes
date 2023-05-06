package edu.axel.balam.mancera.miramontes.reto11;

import edu.axel.balam.mancera.miramontes.reto11.classes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    /**
     * Hacer un método que reciba dicha lista e imprima únicamente aquellos empleados cuya edad sea mayor a 20: 10pts
     */
    public static void filterByAge(List<JrEngineer> lstJrEngineer){
        for(JrEngineer itJrEngineer : lstJrEngineer){
            if(itJrEngineer.edad > 20){
                System.out.println(itJrEngineer.nombre + ":");
                System.out.println("Nombre = " + itJrEngineer.nombre);
                System.out.println("Edad = " + itJrEngineer.edad);
            }
        }
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
        String nombreArchivo = "Lista de ingenieros junior.txt";
        int i;

        testEmployee(jrEngineer);
        testEmployee(manager);
        testInterviewer(hr);
        testInterviewer(manager);
        testProgrammer(jrEngineer);
        testProgrammer(srEngineer);

        /**
         * Crear una lista de 10 JrEngineer con nombres y edades variadas
         * (las  edades se pueden llegar a repetir pero los nombres no)
         */
        List<JrEngineer> lstJrsInput = new ArrayList<JrEngineer>();
        for(i = 0; i < 10; ++i){
            JrEngineer jrEngineer2 = new JrEngineer();
            jrEngineer2.nombre = "Nombre_" + i;
            jrEngineer2.edad = (short)(new Random().nextInt(100 - 18 + 1) + 18);
            lstJrsInput.add(jrEngineer2);
        }

        /**
         * Guardar la lista en un archivo de texto, hay libertad sobre el formato en que se guarde la información: 30 pts
         */
        try (FileWriter fileWriter = new FileWriter(nombreArchivo);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            i = 0;
            for (JrEngineer itJr : lstJrsInput) {
                String strJr = "Jr engineer " + i + "{" +
                        "\nNombre = " + itJr.nombre +
                        "\nEdad = " + itJr.edad +
                        "\n}";
                bufferedWriter.write(strJr);
                bufferedWriter.newLine();
                ++i;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Leer el archivo de texto con los alumnos y almacenarlos en un arraylist: 20pts
         */
        List<JrEngineer> lstJrsOutput = new ArrayList<JrEngineer>();
        try (FileReader fileReader = new FileReader(nombreArchivo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String txtLine, name = "";
            short age = 0;
            while ((txtLine = bufferedReader.readLine()) != null) {
                String[] substrings = txtLine.split(" ");

                if(substrings[0].equals("Nombre")){
                    name = substrings[2];
                }
                if(substrings[0].equals("Edad")){
                    age = Short.parseShort(substrings[2]);
                }
                if(substrings[0].equals("}")){
                    JrEngineer jrEngineer3 = new JrEngineer();
                    jrEngineer3.nombre = name;
                    jrEngineer3.edad = age;
                    lstJrsOutput.add(jrEngineer3);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        filterByAge(lstJrsOutput);

    }
}
