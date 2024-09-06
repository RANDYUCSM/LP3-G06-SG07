public abstract class Persona {
    private String nombre;
    private String email;
    
    public Persona(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public abstract String obtenerInformacion(); //Metodo abstracto
}
//
public class Estudiante extends Persona {
    private static final String TIPO_PERSONA = "Estudiante";
    
    public Estudiante(String nombre, String email) {
        super(nombre, email);
    }
    
    public String obtenerInformacion() {
        return "Nombre: " + getNombre() + ", Email: " + getEmail() + ", Tipo: " + TIPO_PERSONA;
    }
}
//
public class Profesor extends Persona {
    private static final String TIPO_PERSONA = "Profesor";
    
    public Profesor(String nombre, String email) {
        super(nombre, email);
    }
    public String obtenerInformacion() {
        return "Nombre: " + getNombre() + ", Email: " + getEmail() + ", Tipo: " + TIPO_PERSONA;
    }
}
//
import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private String categoria;
    private Profesor profesor;
    private List<Estudiante> estudiantes;
    
    public Curso(String nombre, String categoria, Profesor profesor) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public Profesor getProfesor() {
        return profesor;
    }
    
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    public void inscribirEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
    
    public int contarEstudiantes() {
        return estudiantes.size();
    }
    
    public String obtenerInformacionCurso() {
        return "Curso: " + nombre + ", Categoría: " + categoria + ", Profesor: " + profesor.getNombre() + ", Estudiantes inscritos: " + contarEstudiantes();
    }
}
//
import java.util.ArrayList;
import java.util.List;

public class SistemaGestion {
    private List<Curso> cursos;
    
    public SistemaGestion() {
        this.cursos = new ArrayList<>();
    }
    
    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }
    
    public void mostrarInformacionCursos() {
        for (Curso curso : cursos) {
            System.out.println(curso.obtenerInformacionCurso());
        }
    }
}
//
public class Main {
    public static void main(String[] args) {
        Profesor prof1 = new Profesor("Carlos P", "CAR.perez@gmail.com");
        Profesor prof2 = new Profesor("Juana G", "Ju.gomez@gmail.com");
        
        Estudiante est1 = new Estudiante("Luz Martínez", "l.martinez@gmail.com");
        Estudiante est2 = new Estudiante("María Rodríguez", "m.rodriguez@gmail.com");
        
        Curso curso1 = new Curso("Matemáticas II", "Matemáticas", prof1);
        Curso curso2 = new Curso("Programación en Java", "Programación", prof2);
        
        curso1.inscribirEstudiante(est1);
        curso1.inscribirEstudiante(est2);
        curso2.inscribirEstudiante(est2);
        
        SistemaGestion sistema = new SistemaGestion();
        sistema.agregarCurso(curso1);
        sistema.agregarCurso(curso2);
        
        sistema.mostrarInformacionCursos();
    }
}
