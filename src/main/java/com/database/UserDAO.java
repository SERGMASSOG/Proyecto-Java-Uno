package com.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    //Metodo para poder insertar un usuario
    public void inserUser(User User){
        String sql = "INSERT INTO Users(Name,email) VALUES (?,?)";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, User.getName());
            pstmt.setString(2, User.getEmail());
            pstmt.executeUpdate();
            System.out.println("Usuario insertado exitosamente.");
        }catch (SQLException e){
            System.err.println("Error al insertar usuario: "+ e.getMessage());
        }
    }

    //Metodo para obtener los datos
    public  List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = databaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                User user = new User(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("email")
                );
                users.add(user);
            }
        } catch (SQLException e){
            System.err.println("Error al obtener usuarios: " + e.getMessage());
        }
        return  users;
    }

    // Metodo para actualizar un usuario
    public void updateUser(int id, String newName, String newEmail) {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newEmail);
            preparedStatement.setInt(3, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            System.out.println("Usuario actualizado. Filas afectadas: " + rowsUpdated);
        } catch (SQLException e) {
            System.err.println("Error al actualizar el usuario: " + e.getMessage());
        }
    }

    // Eliminacion de un usuario
    public  void  deleteUser(int Id){
        String sql = "DELETE FROM users WHERE Id = ?";
        try (
            Connection conn = databaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, Id);
            pstmt.executeUpdate();
            System.out.println("Usuario eliminado exitosamente");
        }catch (SQLException e){
            System.err.println("Error al eliminar usuario: "+ e.getMessage());
        }
    }

}

