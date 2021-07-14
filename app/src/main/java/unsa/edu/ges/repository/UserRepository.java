package unsa.edu.ges.repository;

import com.google.android.gms.tasks.Task;

import unsa.edu.ges.model.User;

public class UserRepository extends FirestoreRepository<User> {
    private static UserRepository instance;

    public synchronized static UserRepository getInstance() {
        if (UserRepository.instance == null) {
            UserRepository.instance = new UserRepository();
        }
        return instance;
    }

    private UserRepository() {
        super(User.class);
    }

    @Override
    public Task<Void> save(User entity) {
        // Es necesario para la vinculadción de data adicional del usuario que sera la misma id del
        // usuario autenticado con firebase.
        return this.collectionReference.document(entity.getIdentifier()).set(entity);
    }
}
