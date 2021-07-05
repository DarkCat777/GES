package unsa.edu.ges.models;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class User {
    private String user_name;
    private String password;
    private String email;
    private String direccion;

    public User(String user_name,String password,String email,String direccion){
        setUsername(user_name);
        setPassword(password);
        setEmail(email);
        setDireccion(direccion);
    }

    public JsonElement getJson(){
        String StringJson = "{\"username\":\""+getUsername()+"\"," +
                "\"password\":\""+getPassword()+"\"," +
                "\"email\":\""+getEmail()+"\"," +
                "\"direccion\":\""+getDireccion()+"\"}";
        return JsonParser.parseString(StringJson);
    }

    public void setUsername(String user_name){
        this.user_name=user_name;
    }
    public String getUsername(){
        return this.user_name;
    }

    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return this.password;
    }

    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return this.email;
    }

    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    public String getDireccion(){
        return this.direccion;
    }
}
