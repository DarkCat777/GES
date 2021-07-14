package unsa.edu.ges.repository.livedata;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import unsa.edu.ges.model.DocumentDatabase;

public class MultipleDocumentReferenceLiveData<E extends DocumentDatabase, D extends Query>
        extends MutableLiveData<List<E>>
        implements EventListener<QuerySnapshot> {
    private final D multipleDocumentReference;
    private final Class<E> entityClass;
    private final String TAG = MultipleDocumentReferenceLiveData.class.getSimpleName();
    private ListenerRegistration listenerRegistration;

    public MultipleDocumentReferenceLiveData(D multipleDocumentReference, Class<E> entityClass) {
        this.multipleDocumentReference = multipleDocumentReference;
        this.entityClass = entityClass;
    }

    @Override
    protected void onActive() {
        this.listenerRegistration = this.multipleDocumentReference.addSnapshotListener(this);
        super.onActive();
    }

    @Override
    protected void onInactive() {
        this.listenerRegistration.remove();
        super.onInactive();
    }

    @Override
    public void onEvent(QuerySnapshot querySnapshot, FirebaseFirestoreException error) {
        if (querySnapshot != null && !querySnapshot.isEmpty()) {
            Log.d(TAG, "Updating data");
            List<E> entities = querySnapshot.toObjects(this.entityClass);
            // Update this identifiers on current entity
            for (int i = 0; i < entities.size(); i++)
                entities.get(i).setIdentifier(querySnapshot.getDocuments().get(i).getId());
            this.setValue(entities);
        } else if (error != null)
            Log.e(TAG, error.getMessage(), error.getCause());
    }
}
