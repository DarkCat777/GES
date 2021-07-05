package unsa.edu.ges.models;

import android.util.Log;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class UserStorage {

    private static ArrayList<User> users;

    private UserStorage userStorage;
    public static void init(){
        if(users == null){
            users=new ArrayList<User>();
        }
    }
    public static void addUser(User user){
        users.add(user);
        //Comprobación de Almacenamiento
        Log.e("Usuarios:",getUsers());
    }
    public static String getUsers(){
        String jsonString = "{";
        for (User userItem:users){
            jsonString+=userItem.getJson()+",";
        }
        jsonString += "}";
        return jsonString;
    }
    public static User findUser(String username){
        for(User userItem:users){
            if(userItem.getUsername().equals(username)){
                return userItem;
            }
        }
        return null;
    }
}
