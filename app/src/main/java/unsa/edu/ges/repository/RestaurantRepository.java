package unsa.edu.ges.repository;

import unsa.edu.ges.model.Restaurant;

public class RestaurantRepository extends FirestoreRepository<Restaurant> {
    private static RestaurantRepository instance;

    public synchronized static RestaurantRepository getInstance() {
        if (RestaurantRepository.instance == null) {
            RestaurantRepository.instance = new RestaurantRepository();
        }
        return RestaurantRepository.instance;
    }

    private RestaurantRepository() {
        super(Restaurant.class);
    }
}
