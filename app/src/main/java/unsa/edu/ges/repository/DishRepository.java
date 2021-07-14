package unsa.edu.ges.repository;

import com.google.firebase.firestore.DocumentReference;

import unsa.edu.ges.model.Dish;

public class DishRepository extends FirestoreRepository<Dish> {
    private static DishRepository instance;

    public synchronized static DishRepository getInstance() {
        if (DishRepository.instance == null) {
            DishRepository.instance = new DishRepository();
        }
        return DishRepository.instance;
    }

    private DishRepository() {
        super(Dish.class);
    }

    @Override
    public DocumentReference fetchById(String identifier) {
        return super.fetchById(identifier);
    }
}
