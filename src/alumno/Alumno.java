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
    public static final String [] ASIGNATURAS={"Entornos","Programacion","Sistemas","Fol"
     ,"Bases de datos","Lenguajes de marcas"};
    
    public Alumno(String nomApe,Calendar fechaNac,long telef,char sex,int numHerma)
    {
        this.nombreApellidos=nomApe;
        this.fechaNac = fechaNac;
        this.telefono= telef;
        this.sexo = sex;
        this.numHermanos = numHerma;
        observaciones = new String[ASIGNATURAS.length];
        //se inicializa el array con un tamaño igual al numero de asignaturas
        notas = new int[ASIGNATURAS.length];
    }
    
    /**
     * Metodo que devuelve la nota que tiene el alumno en una asignatura
     * @param indiceAsig es el indice de la asignatura de la que se quiere
     * obtener la nota
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
       
        return (float)(sumaNotas/notas.length);
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
     * Metodo que modifica el numero de telefono del alumno
     * @param telefono es el nuevo numero de telefono que se quiere
     * introducir
     */
    public void setTelefono(long telefono)
    {
        this.telefono = telefono;
        
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
            System.out.println("Indice : " + i + " - " + ASIGNATURAS[i]);
                
        }
    }
    
    /**
     * Metodo que calcula la edad del alumno a partir de su fecha
     * de nacimiento
     * @return la edad del alumno
     */
    public int edad()
    {
        int edad = 0;
        //Primero se obtiene del sistema la fecha actual
        Calendar fechaActual = Calendar.getInstance();
        //se calcula la edad y si el dia del año correspondiente a la fecha de
        //nacimiento es mayor que el dia del año de la fecha actual se resta
        //1 a la edad
        edad = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        if(fechaNac.get(Calendar.DAY_OF_YEAR)> fechaActual.get(Calendar.DAY_OF_YEAR))
        {
            edad--;
        }
        return edad;
    }
    
    /**
     * Metodo que visualiza los datos del alumno
     */
    public void verFicha()
    {
        
        System.out.println("Nombre y apellidos : " + nombreApellidos + "\n"
                           + "Edad : "  + edad() + "\n"
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
