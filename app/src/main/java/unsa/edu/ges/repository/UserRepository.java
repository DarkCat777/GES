package unsa.edu.ges.repository;

import unsa.edu.ges.model.User;

public class UserRepository extends FirestoreRepository<User> {
    private static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null) {
            UserRepository.instance = new UserRepository();
        }
        return instance;
    }

    private UserRepository() {
        super(User.class);
    }
}
