package unsa.edu.ges.repository;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.Query;

public interface CrudRepository<ID, E> {
    Task<Void> save(E entity);

    Task<Void> update(E entity);

    DocumentReference fetchById(ID identifier);

    Query fetchAll();

    Task<Void> deleteById(ID identifier);
}
