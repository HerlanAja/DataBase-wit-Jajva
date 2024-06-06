import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowData {
    static final String jdbc = "jdbc:mysql://localhost:3306/";
    static final String url = "jdbc:mysql://localhost:3306/akademik";
    static final String user = "root";
    static final String password = "";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "SELECT * FROM mahasiswa";
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);

            int nomor = 0;
            while (rs.next()) {
                nomor++;
                System.out.println("No: " + nomor);
                System.out.println("NIM: " + rs.getString("NIM"));
                System.out.println("NAMA: " + rs.getString("Nama"));
                System.out.println("ALAMAT: " + rs.getString("Alamat"));
                System.out.println("====================================");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}