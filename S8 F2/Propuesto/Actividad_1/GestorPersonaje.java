package Actividad_1;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GestorPersonaje {

    private static final String DB_URL = "jdbc:sqlite:personajes.db";
    private List<Personaje> personajes;

    public GestorPersonaje() {
        personajes = new ArrayList<>();
        cargarPersonajesDesdeBD();
    }

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Personaje (" +
                                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                    "nombre TEXT NOT NULL," +
                                    "nivel INTEGER NOT NULL)";
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTableSQL);
                System.out.println("Tabla Personaje creada o ya existe.");
            }
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }

        GestorPersonaje gestor = new GestorPersonaje();

        String[] nombres = {"Guerrero", "Mago", "Arquero"};
        int[] niveles = {1, 5, 10};

        for (int i = 0; i < nombres.length; i++) {
            gestor.insertarPersonaje(nombres[i], niveles[i]);
        }

        System.out.println("\nConsulta personalizada:");
        gestor.consultarPersonajes(new String[]{"id", "nombre"}, "nivel > 1", "nivel", "asc", 2);
    }

    private static class Personaje {
        int id;
        String nombre;
        int nivel;

        Personaje(int id, String nombre, int nivel) {
            this.id = id;
            this.nombre = nombre;
            this.nivel = nivel;
        }
    }

    private void cargarPersonajesDesdeBD() {
        String selectSQL = "SELECT * FROM Personaje";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                personajes.add(new Personaje(rs.getInt("id"), rs.getString("nombre"), rs.getInt("nivel")));
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar personajes: " + e.getMessage());
        }
    }

    public void insertarPersonaje(String nombre, int nivel) {
        String insertSQL = "INSERT INTO Personaje (nombre, nivel) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, nombre);
            pstmt.setInt(2, nivel);
            pstmt.executeUpdate();
            System.out.println("Personaje insertado con éxito: " + nombre);
            personajes.add(new Personaje(personajes.size() + 1, nombre, nivel)); 
        } catch (SQLException e) {
            System.out.println("Error al insertar personaje: " + e.getMessage());
        }
    }

    public void consultarPersonajes(String[] camposMostrar, String condicion, String campoOrden, String orden, int limite) {

        List<Personaje> resultado = personajes.stream()
                .filter(p -> cumpleCondicion(p, condicion))
                .sorted(getComparador(campoOrden, orden))
                .limit(limite)
                .collect(Collectors.toList());

        for (Personaje p : resultado) {
            for (String campo : camposMostrar) {
                switch (campo) {
                    case "id":
                        System.out.print("ID: " + p.id + " ");
                        break;
                    case "nombre":
                        System.out.print("Nombre: " + p.nombre + " ");
                        break;
                    case "nivel":
                        System.out.print("Nivel: " + p.nivel + " ");
                        break;
                }
            }
            System.out.println();
        }
    }

    private boolean cumpleCondicion(Personaje p, String condicion) {
        if (condicion == null || condicion.isEmpty()) {
            return true;
        }

        String[] parts = condicion.split(" ");
        if (parts.length == 3) {
            String campo = parts[0];
            String operador = parts[1];
            int valor = Integer.parseInt(parts[2]);

            switch (campo) {
                case "nivel":
                    return switch (operador) {
                        case ">" -> p.nivel > valor;
                        case "<" -> p.nivel < valor;
                        case "=" -> p.nivel == valor;
                        default -> false;
                    };
                default:
                    return false;
            }
        }
        return false;
    }

    private Comparator<Personaje> getComparador(String campoOrden, String orden) {
        Comparator<Personaje> comparator;
        switch (campoOrden) {
            case "id":
                comparator = Comparator.comparingInt(p -> p.id);
                break;
            case "nombre":
                comparator = Comparator.comparing(p -> p.nombre);
                break;
            case "nivel":
                comparator = Comparator.comparingInt(p -> p.nivel);
                break;
            default:
                throw new IllegalArgumentException("Campo de orden inválido: " + campoOrden);
        }

        return orden.equalsIgnoreCase("desc") ? comparator.reversed() : comparator;
    }
}
