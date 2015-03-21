/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumno;
import java.util.Calendar;
/**
 *Esta clase representa los datos de un alumno
 * @author Eduardo
 */
public class Alumno {

   //indica el nombre y los apellidos del alumno
    private String nombreApellidos;
    //indica la fecha de nacimiento del alumno
    private Calendar fechaNac;
    //almacena el telefono del alumno
    private long telefono;
    //indica el sexo del alumno
    private char sexo;
    //indica el numero de hermanos que tiene el alumno
    private int numHermanos;
    //almacena la observaciones que se tiene sobre el alumno
    private String [] observaciones;
    //array que almacena todas las notas de las asignaturas
    private int[] notas;
    //array que almacena las asignaturas que tiene el alumno
    private static final String [] ASIGNATURAS={"Entornos","Programacion","Sistemas","Fol"
     ,"Bases de datos","Lenguajes de marcas"};
    
    public Alumno(String nomApe,Calendar fechaNac,long telef,char sex,int numHerma)
    {
        this.nombreApellidos=nomApe;
        this.fechaNac = fechaNac;
        this.telefono= telef;
        this.sexo = sex;
        this.numHermanos = numHerma;
        observaciones = new String[6];
        //se inicializa el array con un tamaño igual al numero de asignaturas
        notas = new int[6];
    }
    
    /**
     * Metodo que devuelve la nota que tiene el alumno en una asignatura
     * @param indiceAsig es el indice que tiene la asignatura en el array
     * @return la nota de esa asignatura
     */
    public int getNota(int indiceAsig)
    {
        return notas[indiceAsig];
    }
    
    /**
     * Metodo que calcula la nota media de todas las asignaturas
     * del alumno
     * @return la nota media del alumno
     */
    public float notaMedia()
    {
        
        //guarda la suma de las notas del alumno
        int sumaNotas = 0;
        for (int i = 0; i < notas.length; i++)
        {
           sumaNotas += notas[i];
            
        }
       
        return sumaNotas/notas.length;
    }
    
    /**
     * Metodo que calcula el numero de aprobados
     * @return el numero de asignaturas aprobadas 
     */
    public int numeroAprobados()
    {
        int aprobados = 0;
        //se recorre la coleccion de notas,si alguna nota es mayor o igual a 5
        //se aumenta el contador de aprobados
        for (int i = 0; i < notas.length; i++) {
            if(notas[i] >= 5)
            {
                aprobados++;
            }
            
        }
        return aprobados;
    }
    
    /**
     * Metodo que calcula el numero de suspensos que tiene el alumno
     * @return el numero de asignaturas suspensas 
     */
    public int numeroSuspensos()
    {
        return notas.length - numeroAprobados();
    }
    
    /**
     * Metodo que devuelve el numero de hermanos que tiene el alumno
     * @return numero de hermanos del alumno
     */
    public int getNumeroHermanos()
    {
        return numHermanos;
    }
    
    /**
     * Metodo que modifica el numero de hermanos del alumno
     * @param numHerma es el numero de hermanos que se quiere modificar
     */
    public void setNumeroHermanos(int numHerma)
    {
        numHermanos = numHerma;
    }
    
    /**
     * Metodo que devuelvel el nombre y apellidos del alumno
     * @return nombre y apellidos del alumno
     */
    public String getNombreApellidos()
    {
        return nombreApellidos;
    }
    
    /**
     * Metodo que devuelve la fecha de nacimiento del alumno
     * @return la fecha de nacimiento del alumno
     */
    public Calendar getFechaNac()
    {
        return fechaNac;
    }
    
    /**
     * Metodo que devuelve el telefono del alumno
     * @return el telefono del alumno
     */
    public long getTelefono()
    {
        return telefono;
    }
    
    /**
     * Metodo que devuelve el sexo del alumno
     * @return el sexo del alumno
     */
    public char getSexo()
    {
        return sexo;
    }
    
    /**
     * Metodo que devuelve las observaciones que hay sobre el alumno
     * @param indiceAsig es el indice de la asignatura sobre la que se quiere
     * obtener las observaciones
     * @return devuelve las observaciones que haya de un alumno en una
     * determina asignatura
     */
    public String getObservaciones(int indiceAsig)
    {
        if(observaciones[indiceAsig] == null)
        {
            observaciones[indiceAsig] = "Ninguna";
        }
        
        return observaciones[indiceAsig]; 
    }
    
    /**
     * Metodo que añade o modifica observaciones sobre el alumno
     * @param indiceAsig es el indice de la asignatura sobra que se quiere 
     * modificar las observaciones
     * @param observacion es lo que se quiere añadir a las observaciones
     */
    public void addObservacion(int indiceAsig,String observacion)
    {
        observaciones[indiceAsig] = observacion;
    }
    
    /**
     * Metodo que muestras todas las observaciones de cada asignatura
     */
    public void mostrarObservaciones()
    {
        for (int i = 0; i < observaciones.length; i++) 
        {
            //si no hay observaciones en la asignatura
            if(observaciones[i] == null)
            {
                observaciones[i] = "Ninguna";
            }
            System.out.println("Asignatura : " + ASIGNATURAS[i]
                               + " Observacion : " + observaciones[i]);
            
        }
    }
    
    
    /**
     * Metodo que modifica la nota de una determinada asignatura
     * @param indiceAsig es el indice de la asignatura que se quiere modificar
     * la nota
     * @param nota es la nota que se quiere introducir
     */
    public void setNota(int indiceAsig,int nota)
    {
        notas[indiceAsig] = nota;
    }
    
    /**
     * Metodo que muestra los indices de las asignaturas y las asignaturas
     */
    public void mostrarIndices()
    {
       System.out.println("Lista de asignaturas :");
       for (int i = 0; i < ASIGNATURAS.length; i++)
       {
            System.out.println("Indice : " + i + " " + ASIGNATURAS[i]);
                
        }
    }
    
    /**
     * Metodo que devuelve el tamaño de la coleccion de asignaturas
     * @return el tamaño de la coleccion
     */
    public int getLengthAsignaturas()
    {
        return ASIGNATURAS.length;
    }
    
    /**
     * Metodo que visualiza los datos del alumno
     */
    public void verFicha()
    {
        
        System.out.println("Nombre y apellidos : " + nombreApellidos + "\n"
                           + "Fecha de nacimiento : " + fechaNac + "\n"
                           + "Telefono : " + telefono + "\n" + "Sexo : " + sexo
                           + "\n" + "Numero de hermanos : " + numHermanos);
        System.out.println("Relacion de notas por asignatura :");
        for (int i = 0; i < ASIGNATURAS.length; i++) {
            System.out.println(ASIGNATURAS[i] + ":" + notas[i]);
            
        }
        System.out.println("Numero de asignaturas aprobadas : " + numeroAprobados()
                           + "\n" + "Numero de asignaturas suspensas : " 
                           + numeroSuspensos() + "\n" + "Nota media del alumno : " + notaMedia());
        
    }
}
