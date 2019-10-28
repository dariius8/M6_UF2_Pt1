package pt1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	static final String url = "jdbc:sqlite:../UF2_Pt1/src/pt1/ForHonor.db";

	public static void main(String[] args) {
		// conexion BD
		connect();
		// creacion tablas
		tablaFaccion();
		tablaPersonaje();
		// inserts en las tablas
		insertsFaccion();
		insertsPersonaje();
		// selects para mostrar las tablas
		selectFaccion();
		selectPersonaje();
		// select para mostrar los caballeros
		selectCaballeros();
		// select samurai con mas ataque
		selectSamuraiAtaque();
	}

	public static void connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("BD ForHonor conectada.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	public static void tablaFaccion() {
		String query = "CREATE TABLE IF NOT EXISTS Faccion (faccion_id integer PRIMARY KEY, nombre_faccion text(15), lore text(200));";
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			System.out.println("\nTabla 'Faccion' creada.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void tablaPersonaje() {
		String query = "CREATE TABLE IF NOT EXISTS Personaje (personaje_id integer PRIMARY KEY, nombre_personaje text(15), ataque integer, defensa integer, faccion_id integer, FOREIGN KEY (faccion_id) REFERENCES Faccion(faccion_id));";
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			System.out.println("Tabla 'Personaje' creada.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void insertsFaccion() {
		String query = "INSERT INTO Faccion (faccion_id, nombre_faccion, lore) VALUES(?,?,?)";
		try {
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(query);
			// Caballeros
			pstmt.setInt(1, 1);
			pstmt.setString(2, "Caballeros");
			pstmt.setString(3, "Los caballeros de Ashfeld son paradigmas del poder");
			pstmt.executeUpdate();
			System.out.println("\nFaccion 'Caballeros' insertada en la tabla Faccion.");
			// Vikingos
			pstmt.setInt(1, 2);
			pstmt.setString(2, "Vikingos");
			pstmt.setString(3, "Los vikingos son los maestros indiscutibles del mar y el agua");
			pstmt.executeUpdate();
			System.out.println("Faccion 'Vikingos' insertada en la tabla Faccion.");
			// Samurais
			pstmt.setInt(1, 3);
			pstmt.setString(2, "Samurais");
			pstmt.setString(3, "Los samurais son la faccion mas unificada de las tres");
			pstmt.executeUpdate();
			System.out.println("Faccion 'Samurais' insertada en la tabla Faccion.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void insertsPersonaje() {
		String query = "INSERT INTO Personaje (personaje_id, nombre_personaje, ataque, defensa, faccion_id) VALUES(?,?,?,?,?)";
		try {
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(query);
			// Caballeros
			// Guardian (Caballeros)
			pstmt.setInt(1, 1);
			pstmt.setString(2, "Guardian");
			pstmt.setInt(3, 3);
			pstmt.setInt(4, 8);
			pstmt.setInt(5, 1);
			pstmt.executeUpdate();
			System.out.println("\nPersonaje 'Guardian' (Caballeros) insertado en la tabla Personaje.");
			// Conquistador (Caballeros)
			pstmt.setInt(1, 2);
			pstmt.setString(2, "Conquistador");
			pstmt.setInt(3, 9);
			pstmt.setInt(4, 3);
			pstmt.setInt(5, 1);
			pstmt.executeUpdate();
			System.out.println("Personaje 'Conquistador' (Caballeros) insertado en la tabla Personaje.");
			// Pacificadora (Caballeros)
			pstmt.setInt(1, 3);
			pstmt.setString(2, "Pacificadora");
			pstmt.setInt(3, 6);
			pstmt.setInt(4, 6);
			pstmt.setInt(5, 1);
			pstmt.executeUpdate();
			System.out.println("Personaje 'Pacificadora' (Caballeros) insertado en la tabla Personaje.");
			// Vikingos
			// Huscarle (Vikingos)
			pstmt.setInt(1, 4);
			pstmt.setString(2, "Huscarle");
			pstmt.setInt(3, 4);
			pstmt.setInt(4, 7);
			pstmt.setInt(5, 2);
			pstmt.executeUpdate();
			System.out.println("Personaje 'Huscarle' (Vikingos) insertado en la tabla Personaje.");
			// Berserker (Vikingos)
			pstmt.setInt(1, 5);
			pstmt.setString(2, "Berserker");
			pstmt.setInt(3, 7);
			pstmt.setInt(4, 5);
			pstmt.setInt(5, 2);
			pstmt.executeUpdate();
			System.out.println("Personaje 'Berserker' (Vikingos) insertado en la tabla Personaje.");
			// Samurais
			// Shinobi (Samurais)
			pstmt.setInt(1, 6);
			pstmt.setString(2, "Shinnobi");
			pstmt.setInt(3, 5);
			pstmt.setInt(4, 9);
			pstmt.setInt(5, 3);
			pstmt.executeUpdate();
			System.out.println("Personaje 'Shinobi' (Samurais) insertado en la tabla Personaje.");
			// Aramusha (Samurais)
			pstmt.setInt(1, 7);
			pstmt.setString(2, "Aramusha");
			pstmt.setInt(3, 8);
			pstmt.setInt(4, 4);
			pstmt.setInt(5, 3);
			pstmt.executeUpdate();
			System.out.println("Personaje 'Aramusha' (Samurais) insertado en la tabla Personaje.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void selectFaccion() {
		String query = "SELECT * FROM Faccion";
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// recorremos el result set
			System.out.println("\n---Tabla Faccion---");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void selectPersonaje() {
		String query = "SELECT * FROM Personaje";
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// recorremos el result set
			System.out.println("\n---Tabla Personaje---");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4)
						+ "\t" + rs.getInt(5));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void selectCaballeros() {
		String query = "SELECT * FROM Personaje WHERE faccion_id = 1";
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// recorremos el result set
			System.out.println("\n---Personajes de la Faccion Caballeros---");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4)
						+ "\t" + rs.getInt(5));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void selectSamuraiAtaque() {
		String query = "SELECT * FROM Personaje WHERE faccion_id = 3 AND ataque = (SELECT MAX(ataque) FROM Personaje where faccion_id = 3)";
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// recorremos el result set
			System.out.println("\n---Personaje de la Faccion Samurais con mas ataque---");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4)
						+ "\t" + rs.getInt(5));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}