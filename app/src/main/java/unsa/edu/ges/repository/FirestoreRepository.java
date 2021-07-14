package unsa.edu.ges.repository;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import unsa.edu.ges.model.DocumentDatabase;

public abstract class FirestoreRepository<E extends DocumentDatabase> implements CrudRepository<String, E> {
    protected final CollectionReference collectionReference;

    public FirestoreRepository(Class<E> entityClass) {
        collectionReference = FirebaseFirestore.getInstance().collection(entityClass.getSimpleName());
    }

    @Override
    public Task<Void> save(E entity) {
        return this.collectionReference.document().set(entity);
    }

    @Override
    public Task<Void> update(E entity) {
        return this.collectionReference.document(entity.getIdentifier()).set(entity);
    }

    @Override
    public DocumentReference fetchById(String identifier) {
        return this.collectionReference.document(identifier);
    }

    @Override
    public Query fetchAll() {
        return this.collectionReference;
    }

    @Override
    public Task<Void> deleteById(String identifier) {
        return this.collectionReference.document(identifier).delete();
    }
}
