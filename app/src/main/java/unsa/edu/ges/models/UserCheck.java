package unsa.edu.ges.models;

public class UserCheck {
    public static boolean checkUser(User user,String repeat_password){
        if(user.getEmail().contains("@")){
            if(user.getPassword().equals(repeat_password)){
                if(UserStorage.findUser(user.getUsername())==null) {
                    return true;
                }
            }
        }
        return false;
    }
}
