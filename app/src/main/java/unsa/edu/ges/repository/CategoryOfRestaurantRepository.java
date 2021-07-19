package unsa.edu.ges.repository;

import unsa.edu.ges.model.CategoryOfRestaurant;

public class CategoryOfRestaurantRepository extends FirestoreRepository<CategoryOfRestaurant> {
    private static CategoryOfRestaurantRepository instance;

    public synchronized static CategoryOfRestaurantRepository getInstance() {
        if (CategoryOfRestaurantRepository.instance == null) {
            CategoryOfRestaurantRepository.instance = new CategoryOfRestaurantRepository();
        }
        return CategoryOfRestaurantRepository.instance;
    }

    private CategoryOfRestaurantRepository() {
        super(CategoryOfRestaurant.class);
    }
}
