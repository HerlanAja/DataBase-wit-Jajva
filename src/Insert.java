import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {

    static final String jdbc = "jdbc:mysql://localhost:3306/";
    static final String url = "jdbc:mysql://localhost:3306/akademik";
    static final String user = "root";
    static final String password = "";

    static Connection conn;
    static PreparedStatement ps;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan NIM (max 10 karakter): ");
        String nim = sc.next();
        if (nim.length() < 8 || nim.length() > 10) {
            System.out.println("NIM harus 8-10 karakter.");
            return;
        }
        System.out.print("Masukkan Nama (max 50 karakter): ");
        sc.nextLine();  // Consume the newline left-over
        String nama = sc.nextLine();
        if (nama.length() > 50) {
            System.out.println("Nama terlalu panjang. Harus kurang dari 50 karakter.");
            return;
        }
        System.out.print("Masukkan Alamat (max 100 karakter): ");
        String alamat = sc.nextLine();
        if (alamat.length() > 100) {
            System.out.println("Alamat terlalu panjang. Harus kurang dari 100 karakter.");
            return;
        }

        String query = "INSERT INTO mahasiswa (NIM, Nama, Alamat) VALUES (?, ?, ?)";
        try {
            conn = DriverManager.getConnection(url, user, password);
            ps = conn.prepareStatement(query);
            ps.setString(1, nim);
            ps.setString(2, nama);
            ps.setString(3, alamat);
            ps.execute();
            System.out.println("Data Berhasil");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
