package edu.axel.balam.mancera.miramontes.reto12;

import edu.axel.balam.mancera.miramontes.reto12.classes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
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

    /**
     * Hacer un método que lea un archivo de texto con información de empleados, los agregue a un arrayList y retorne dicho arraylist.
     * @param nombreArchivo: represents the name of the text file whose information is going to be read.
     * @return lstJrsOutput: represents a list containing all the jr engineers found in the text file.
     */
    public static List<JrEngineer> readFromFile(String nombreArchivo){
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
        return lstJrsOutput;
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


        /**
         * determinar cuantos empleados tienen entre 20 y 25 años de edad
         */
        short count = (short) lstJrsOutput.stream()
                .filter(jr -> jr.edad >= 20 && jr.edad <= 25).count();
        System.out.println("El número de empleados que tienen entre 20 y 25 años de edad es: " + count);

        /**
         * con la lista ordenada alfabéticamente, imprimir en pantalla los primeros 10 empleados de la lista.
         */
        System.out.println("Imprimir lista de los primeros 10 jr. engineers ordenados alfabpeticamente:\n");
        lstJrsOutput.stream()
                .sorted(Comparator.comparing(jr -> jr.nombre))
                .limit(10)
                .forEach(jr -> System.out.println(jr.toString()));

        /**
         * encontrar el promedio de edad de todos los empleados.
         */
        double avrgAge = lstJrsOutput.stream()
                .mapToDouble(jr -> jr.edad)
                .average()
                .orElse(Double.NaN);
        System.out.println("La edad promedio de los empleados es: " + avrgAge);

        /**
         * encontrar el último empleado de la lista si esta tiene como primer criterio de ordenamiento la edad y segundo criterio el nombre(alfabéticamente).
         */
        List<JrEngineer> auxLstJrsOutput = lstJrsOutput.stream().sorted(Comparator.comparing(jr -> jr.edad)).toList();
        lstJrsOutput.sort(Comparator.comparing(jr -> jr.nombre));
        System.out.println("EL último empleado es:\n" + auxLstJrsOutput.get(auxLstJrsOutput.size() - 1).toString());

    }
}
