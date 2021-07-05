package unsa.edu.ges.models;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private static FirebaseFirestore db;
    private static ArrayList<User> users;

    private UserStorage userStorage;
    public static void init(){
        if(users == null){
            users=new ArrayList<User>();
        }
        if(db==null){
            db = FirebaseFirestore.getInstance();
        }
    }
    public static void addUser(User user){
        users.add(user);
        //Comprobación de Almacenamiento Local
        Log.e("Usuarios:",getUsers());
        //Creando Map para Google FireStore
        Map<String, String> userMap = new HashMap<String,String>();
        userMap.put("username",user.getUsername());
        userMap.put("password",user.getPassword());
        userMap.put("email",user.getEmail());
        userMap.put("adress",user.getDireccion());
        //Guardando en Google FireStore
        db.collection("users").document(user.getUsername()).set(userMap);
    }
    public static String getUsers(){
        String jsonString = "{";
        for (User userItem:users){
            jsonString+=userItem.getJson()+",";
        }
        jsonString += "}";

        //Obtener Datos de Firestore
        db.collection("cities").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.e("FireStoreResults",document.toString());
                            }
                        } else {
                        }
                    }
                });

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