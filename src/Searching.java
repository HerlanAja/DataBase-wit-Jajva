import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Searching {
    static final String jdbc = "jdbc:mysql://localhost:3306/";
    static final String url = "jdbc:mysql://localhost:3306/akademik";
    static final String user = "root";
    static final String password = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Cari Nim :");
        String nim = sc.next();
        System.out.print("Cari nama:");
        String nama = sc.next();
        String query = "SELECT * FROM mahasiswa WHERE NIM = ? OR NAMA = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, nim);
            ps.setString(2, nama);
            ResultSet rs = ps.executeQuery();

            int nomor = 0;
            while (rs.next()) {
                nomor++;
                System.out.println("No: " + nomor);
                System.out.println("NIM: " + rs.getString("NIM"));
                System.out.println("NAMA: " + rs.getString("Nama"));
                System.out.println("ALAMAT: " + rs.getString("Alamat"));
                System.out.println("====================================");
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}