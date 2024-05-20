// DAO para gestionar envíos
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnvioDAO {

    public void registrarEnvio(Envio envio) {
        String sql = "INSERT INTO envios (cliente_id, origen, destino, fecha_envio, estado) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, envio.getClienteId());
            pstmt.setString(2, envio.getOrigen());
            pstmt.setString(3, envio.getDestino());
            pstmt.setDate(4, new java.sql.Date(envio.getFechaEnvio().getTime()));
            pstmt.setString(5, envio.getEstado());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }