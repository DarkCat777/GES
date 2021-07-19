package unsa.edu.ges.repository;

import unsa.edu.ges.model.UserExperience;

public class UserExperienceRepository extends FirestoreRepository<UserExperience> {
    private static UserExperienceRepository instance;

    public synchronized static UserExperienceRepository getInstance() {
        if (UserExperienceRepository.instance == null) {
            UserExperienceRepository.instance = new UserExperienceRepository();
        }
        return UserExperienceRepository.instance;
    }

    private UserExperienceRepository() {
        super(UserExperience.class);
    }
}
