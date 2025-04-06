package com.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static  void  main(String[] args){
        // Probar conexion a base de datos
        try {
            Connection conn = databaseConnection.getConnection();
            System.out.println("Conexion exitosa a la base da datos.");
            conn.close();// Cerramos la conexion
        }catch (SQLException e){
            System.err.println("Error con la conexion a la base de datos: " + e.getMessage());
            return; //Salir de la base de datos si no se logra conectar
        }
        // Inicia el DAO y el Menu
        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Menu de operaciones CRUD ---");
            System.out.println("1. Insertar Usuario");
            System.out.println("2. Consultar usuario");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opcion: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar

            switch (option){
                case 1:
                    //Insertar Usuario
                    System.out.print("Ingrese el nombre: ");
                    String Name = scanner.nextLine();
                    System.out.print("Ingrese el correo; ");
                    String email = scanner.nextLine();

                    User newUser = new User(0, Name, email); // Id es autoincrement
                    userDAO.inserUser(newUser);
                    break;

                case 2:
                    //Consultar querys
                    userDAO.getAllUsers().forEach(User ->
                            System.out.println("Id: "+ User.getId() + ", Nombre: " + User.getName() + ", Email: " + User.getEmail())
                            );
                    break;

                case 3:
                    //Actualizar usuarios
                    System.out.print("Ingrese el Id del usuario a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Limpiar
                    System.out.print("Ingrese el nuevo nombre; ");
                    String newName = scanner.nextLine();
                    System.out.print("Ingrese el nuevo correo: ");
                    String newEmail = scanner.nextLine();

                    userDAO.updateUser(updateId,newName,newEmail);
                    break;

                case 4:
                    // Eliminar usuario
                    System.out.print("Ingrese el id del usuario a eliminar: ");
                    int deleteId = scanner.nextInt();
                    userDAO.deleteUser(deleteId);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opcion no valida intente de nuevo.");
            }
        } while (option !=5);
        scanner.close();
    }
}
