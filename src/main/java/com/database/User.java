package com.database;

// se crea para representar a un usuario dentro de un programa, especialmente
// cuando estás trabajando con bases de datos, aplicaciones web o sistemas de login.

//atributos privados de un usuario. Usas private para proteger los datos
public class User {
    private int Id;
    private String Name;
    private  String email;

    // Un constructor es un metodo especial dentro de una clase que se ejecuta automáticamente cuando creas un objeto de esa clase
    //Este constructor se usa cuando quieres crear un usuario sin pasarle datos de inmediato.
    public  User(){}

    //Este constructor permite crear un usuario ya con los datos listos.
    public  User(int Id, String Name, String email){
        this.Id = Id;
        this.Name = Name;
        this.email = email;
    }
    // Setters y Setters
    public int getId(){return Id; }
    public void setId(int Id){this.Id = Id; }
    public String getName(){return Name; }
    public void  setName(String Name){this.Name = Name; }
    public  String getEmail(){return  email; }
    public void setEmail(String email) {this.email = email; }

    @Override
    public String toString(){
        return  "User{" +
                "Id=" + Id +
                ",Name ='" + Name + '\'' +
                ", email='" + email + '\''+
                "}";
    }

}
