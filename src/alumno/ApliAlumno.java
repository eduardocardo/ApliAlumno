/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumno;

import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Eduardo
 */
public class ApliAlumno {
    

    public static void main(String[] args) {
        //indica nombre y apellidos de alumno
        String nombreApellidos;
        Calendar fechaNac = null;
        long telefono;
        char sexo;
        int numHermanos;
        Alumno objAlumno = null;

        //se crea un objeto de tipo Scanner para interactuar con el usuario
        Scanner teclado = new Scanner(System.in);
        //se recopila datos del alumno
        //se solicita el nombre y apellidos
        teclado.useDelimiter("\n");
        System.out.println("Introduce nombre y apellidos del alumno");
        nombreApellidos = teclado.next();

        //se solicita fecha de nacimiento
        System.out.println("Introduce mes de nacimiento(yyyy/mm/dd)");
        int mes = teclado.nextInt();
        System.out.println("Introduce dia de nacimiento(yyyy/mm/dd)");
        int dia = teclado.nextInt();
        System.out.println("Introduce año de nacimiento(yyyy/mm/dd)");
        int anio = teclado.nextInt();
        try {
            String fecha = mes + "/" + dia + "/" + anio;
            String pattern = "DD/MM/YYYY";
            DateFormat format = new SimpleDateFormat(pattern);
            Date date = format.parse(fecha);
            fechaNac = dateToCalendar(date);
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
        }

        //se solicita el numero de telefono
        System.out.println("Introduce el numero de telefono");
        telefono = teclado.nextLong();
        //se comprueba que el numero de telefono es valido
        while (!comprobarDigitosTelefono(telefono)) {
            System.out.println("Has introducido un numero que no tiene 9 digitos");
            System.out.println("Introduce el numero de telefono");
            telefono = teclado.nextInt();
        }

        //se solicita el sexo del alumno
        System.out.println("Introduce el sexo del alumno(masculino = m,femenino = f");
        sexo = teclado.next().charAt(0);
        //control de rango para comprobar que introduce un caracter correcto
        while (sexo != 'm' && sexo != 'M' && sexo != 'f' && sexo != 'F') {
            System.out.println("Has introducido un caracter erroneo");
            System.out.println("Introduce el sexo del alumno(masculino = m,femenino = f");
            sexo = teclado.next().charAt(0);
        }

        //se solicita el numero de hermanos del alumno
        System.out.println("Introduce el numero de hermanos del alumno");
        numHermanos = teclado.nextInt();
        //control de rango para que el valor sea positivo
        while (numHermanos < 0) {
            System.out.println("Has introducido un numero de hermanos negativo");
            System.out.println("Introduce el numero de hermanos del alumno");
            numHermanos = teclado.nextInt();
        }

        //se inicializa el objeto alumno
        objAlumno = new Alumno(nombreApellidos, fechaNac, telefono, sexo, numHermanos);

        //se modifican las notas del alumno
        String pregunta = "Quieres modificar alguna nota del alumno? (s/n)";
        char respuesta = preguntar(pregunta);

        //se repite el bucle mientras responda s/S
        while (respuesta == 's' || respuesta == 'S') {
            //se muestra al usuario los indices de las asignaturas
            objAlumno.mostrarIndices();
            
            //se le pide que indtroduzca un indice de asignatura valido
            String pregunta6 = "Introduce indice de la asignatura a modificar";
            int indiceAsig = indiceAsignatura(pregunta6,objAlumno);
            
            //se pide que meta la nota
            System.out.println("Introduce la nota");
            int nota = teclado.nextInt();

            //control de rango para comprobar que introduce una nota correcta
            while (nota < 0 || nota > 10) {
                System.out.println("Has introducido un valor erroneo de nota");
                System.out.println("Introduce una nota");
                nota = teclado.nextInt();
            }
            
            //se modifica la nota
            objAlumno.setNota(indiceAsig, nota);
            
            //se le pregunta si quiere modificar otra nota
            respuesta = preguntar(pregunta);
        }

        //se pregunta si quiere modificar el numero de hermanos
        String pregunta2 = "Quieres modificar el numero de hermanos del alumno?(s/n)";
        char respuesta2 = preguntar(pregunta2);

        //si responde que si
        if (respuesta2 == 's' || respuesta2 == 'S') {
            System.out.println("Introduce el nuevo numero de hermanos");
            int numHer = teclado.nextInt();
            //control de rango para que el numero de hermanos sea positivo
            while (numHer < 0) {
                System.out.println("Has introducido un numero de hermanos negativo");
                System.out.println("Introduce el nuevo numero de hermanos");
                numHer = teclado.nextInt();
            }
            //se modifica el numero de hermanos
            objAlumno.setNumeroHermanos(numHer);

        }

        //se pregunta si quiere añadir alguna observacion sobre alguna asignatura
        String pregunta3 = "Quieres añadir o modificar alguna observacion sobre alguna asignatura?(s/n)";
        char respuesta3 = preguntar(pregunta3);

        //se repite el bucle mientras la respuesta sea s
        while (respuesta3 == 's' || respuesta3 == 'S') {
            //se muestra los indices de las asignaturas
            objAlumno.mostrarIndices();
            //se solicita que meta un indice valido de la asignatura sobre la que quiere añadir o modificar la observacion
            String pregunta7 = "Introduce el indice de la asignatura de la que quieres añadir o modificar la observacion";
            int indiceAsig = indiceAsignatura(pregunta7,objAlumno);
            
            //se pide que introduzca la observacion
            System.out.println("Introduce la observacion para esa asignatura");
            String observa = teclado.next();
            
            //se añade esa observacion a la coleccion
            objAlumno.addObservacion(indiceAsig, observa);

            //se pregunta si quiere añadir alguna observacion sobre alguna asignatura
            pregunta3 = "Quieres añadir o modificar alguna observacion sobre alguna asignatura?(s/n)";
            respuesta3 = preguntar(pregunta3);

        }

        //se pregunta al usuario si quiere ver los datos del alumno
        String pregunta4 = "Quieres ver la ficha del alumno?(s/n)";
        char respuesta4 = preguntar(pregunta4);

        //si la respuesta es 's'
        if (respuesta4 == 's' || respuesta4 == 'S') {
            //se muestran los datos del alumno
            objAlumno.verFicha();
        }

        //se pregunta al usuario si quiere ver las observaciones que hay de cada asignatura
        String pregunta5 = "Quieres ver las observaciones que hay de cada asignatura?(s/n)";
        char respuesta5 = preguntar(pregunta5);

        //si la respuesta es 's'
        if (respuesta5 == 's' || respuesta5 == 'S') {
            objAlumno.mostrarObservaciones();
        }
        
   

    }

    /**
     * Metodo que ante una pregunta de tipo String obtiene una respuesta s o n
     *
     * @param pregunta es la pregunta que se le hace al usuario
     * @return respuesta es la respuesta frente a la pregunta hecha
     */
    private static char preguntar(String pregunta) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(pregunta);
        char respuesta = teclado.next().charAt(0);
        //control de rango
        while (respuesta != 's' && respuesta != 'S' && respuesta != 'n' && respuesta != 'N') {
            System.out.println("Has introducido una respuesta erronea");
            System.out.println(pregunta);
            respuesta = teclado.next().charAt(0);
        }
        return respuesta;
    }

    /**
     * Metodo que comprueba si un numero de telefono es valido,es decir tiene 9
     * digitos
     *
     * @param telefono es el numero de telefono
     * @return true si el numero es valido,false si no lo es
     */
    private static boolean comprobarDigitosTelefono(long telefono) {
        //se considera que el numero de telefono tiene 9 digitos
        boolean digitos = true;
        int cont = 0;
        //se repite el bucle mientras queden digitos en el numero de telefono
        while (telefono != 0) 
        {
            telefono = telefono / 10;
            cont++;
        }
        //se comprueba si el numero tiene 9 digitos
        if (cont != 9) 
        {
            digitos = false;
        }
        return digitos;
    }

         /**
     * Metodo que devuelve un indice de asignatura valido
     *
     * @param pregunta es la pregunta que se le hace al usuario
     * @param objAlumno es el alumno sobre el que se quiere hacer la pregunta
     * @return el indice de la asignatura
     */
    public static  int indiceAsignatura(String pregunta,Alumno objAlumno) 
    {
        Scanner teclado = new Scanner(System.in);
        System.out.println(pregunta);
        int indice = teclado.nextInt();
        //control de rango para comprobar que mete un indice de asignatura valido
        while (indice < 0 || indice >= objAlumno.getLengthAsignaturas()) {
            System.out.println("Has introducido un indice incorrecto");
            //se vuelve a mostrar los indices de las asignaturas
            objAlumno.mostrarIndices();
            System.out.println(pregunta);
            indice = teclado.nextInt();
        }
        return indice;
    }

    /**
     * @param date
     * @return 
     *
     */
    public static Calendar dateToCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}
