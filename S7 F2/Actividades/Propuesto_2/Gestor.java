package Propuesto_2;

import java.io.*;
import java.util.*;

public class Gestor {
    private List<Personaje> personajes;
    private final String archivo;

    public Gestor(String archivo) {
        this.archivo = archivo;
        this.personajes = new ArrayList<>();
        cargarPersonajes();
    }

    private void cargarPersonajes() {
        File file = new File(archivo);
        if (!file.exists()) {
            System.out.println("El archivo no existe. Se creará uno nuevo.");
            return; // No hay nada que cargar
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(" ");
                if (datos.length < 6) continue; // Saltar líneas mal formadas
                String nombre = datos[0];
                int vida = Integer.parseInt(datos[1]);
                int ataque = Integer.parseInt(datos[2]);
                int defensa = Integer.parseInt(datos[3]);
                int alcance = Integer.parseInt(datos[4]);
                int nivel = Integer.parseInt(datos[5]);
                personajes.add(new Personaje(nombre, vida, ataque, defensa, alcance, nivel));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato de los datos: " + e.getMessage());
        }
    }

    private void guardarPersonajes() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Personaje p : personajes) {
                pw.println(p.toString());
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void cargarPersonajesAleatorios() {
        String[] nombres = {"Mago", "Paladin", "Assassin", "Hechicero"};
        Random random = new Random();

        for (String nombre : nombres) {
            int vida = random.nextInt(5) + 1;
            int ataque = random.nextInt(5) + 1;
            int defensa = random.nextInt(5) + 1;
            int alcance = random.nextInt(5) + 1;
            int nivel = random.nextInt(3) + 1;
            agregarPersonaje(nombre, vida, ataque, defensa, alcance, nivel);
        }
    }

    public void agregarPersonaje(String nombre, int vida, int ataque, int defensa, int alcance, int nivel) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("El personaje ya existe.");
                return;
            }
        }
        Personaje nuevoPersonaje = new Personaje(nombre, vida, ataque, defensa, alcance, nivel);
        personajes.add(nuevoPersonaje);
        guardarPersonajes();
        System.out.println("Personaje agregado: " + nuevoPersonaje);
    }

    public void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes para mostrar.");
            return;
        }
        for (Personaje p : personajes) {
            System.out.println(p);
        }
    }

    public void filtrarPorAtributo(String atributo) {
        Comparator<Personaje> comparator = null;

        switch (atributo.toLowerCase()) {
            case "vida":
                comparator = Comparator.comparingInt(Personaje::getVida);
                break;
            case "ataque":
                comparator = Comparator.comparingInt(Personaje::getAtaque);
                break;
            case "defensa":
                comparator = Comparator.comparingInt(Personaje::getDefensa);
                break;
            case "alcance":
                comparator = Comparator.comparingInt(Personaje::getAlcance);
                break;
            default:
                System.out.println ("Atributo no válido.");
                return;
        }

        personajes.stream().sorted(comparator).forEach(System.out::println);
    }

    public void actualizarAtributoIndividual(String nombre, String atributo, int nuevoValor) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                switch (atributo.toLowerCase()) {
                    case "vida":
                        p.setVida(nuevoValor);
                        break;
                    case "ataque":
                        p.setAtaque(nuevoValor);
                        break;
                    case "defensa":
                        p.setDefensa(nuevoValor);
                        break;
                    case "alcance":
                        p.setAlcance(nuevoValor);
                        break;
                    default:
                        System.out.println("Atributo no válido.");
                        return;
                }
                guardarPersonajes();
                System.out.println("Atributo actualizado: " + p);
                return;
            }
        }
        System.out.println("El personaje no existe.");
    }

    public void mostrarEstadisticas() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes para mostrar estadísticas.");
            return;
        }
        int totalPersonajes = personajes.size();
        double promedioVida = personajes.stream().mapToInt(Personaje::getVida).average().orElse(0);
        double promedioAtaque = personajes.stream().mapToInt(Personaje::getAtaque).average().orElse(0);
        double promedioDefensa = personajes.stream().mapToInt(Personaje::getDefensa).average().orElse(0);
        double promedioAlcance = personajes.stream().mapToInt(Personaje::getAlcance).average().orElse(0);

        System.out.println("Total de personajes: " + totalPersonajes);
        System.out.println("Promedio de Vida: " + promedioVida);
        System.out.println("Promedio de Ataque: " + promedioAtaque);
        System.out.println("Promedio de Defensa: " + promedioDefensa);
        System.out.println("Promedio de Alcance: " + promedioAlcance);
    }

    public void eliminarPersonaje(String nombre) {
        Iterator<Personaje> it = personajes.iterator();
        while (it.hasNext()) {
            Personaje p = it.next();
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                it.remove();
                guardarPersonajes();
                System.out.println("Personaje eliminado: " + p);
                return;
            }
        }
        System.out.println("El personaje no existe.");
    }
}