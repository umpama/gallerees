package gallerees.dao;

import gallerees.model.AsetVisual;
import gallerees.model.DesainVektor;
import gallerees.model.FotoKamera;
import gallerees.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object untuk operasi CRUD tabel aset_visual.
 */
public class AsetVisualDAO {

    // ────────────────────────── CREATE ───────────────────────────

    public void insert(AsetVisual aset) {
        String sql = "INSERT INTO aset_visual (nama_aset, tema, jenis, path_file) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, aset.getNamaAset());
            ps.setString(2, aset.getTema());
            ps.setString(3, aset.getJenis());
            ps.setString(4, aset.getPathFile());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Gagal INSERT: " + e.getMessage());
        }
    }

    // ────────────────────────── READ ─────────────────────────────

    public List<AsetVisual> getAll() {
        List<AsetVisual> list = new ArrayList<>();
        String sql = "SELECT * FROM aset_visual";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int    id       = rs.getInt("id");
                String nama     = rs.getString("nama_aset");
                String tema     = rs.getString("tema");
                String jenis    = rs.getString("jenis");
                String pathFile = rs.getString("path_file");

                AsetVisual aset;
                if ("Desain Vektor".equalsIgnoreCase(jenis)) {
                    aset = new DesainVektor(id, nama, tema, pathFile);
                } else {
                    aset = new FotoKamera(id, nama, tema, pathFile);
                }
                list.add(aset);
            }

        } catch (SQLException e) {
            System.err.println("Gagal SELECT: " + e.getMessage());
        }
        return list;
    }

    // ────────────────────────── UPDATE ───────────────────────────

    public void update(AsetVisual aset) {
        String sql = "UPDATE aset_visual SET nama_aset = ?, tema = ?, jenis = ?, path_file = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, aset.getNamaAset());
            ps.setString(2, aset.getTema());
            ps.setString(3, aset.getJenis());
            ps.setString(4, aset.getPathFile());
            ps.setInt(5, aset.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Gagal UPDATE: " + e.getMessage());
        }
    }

    // ────────────────────────── DELETE ───────────────────────────

    public void delete(int id) {
        String sql = "DELETE FROM aset_visual WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Gagal DELETE: " + e.getMessage());
        }
    }
}
