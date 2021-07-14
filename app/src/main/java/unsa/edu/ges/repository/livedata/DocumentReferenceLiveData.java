package unsa.edu.ges.repository.livedata;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;

public class DocumentReferenceLiveData<E> extends MutableLiveData<E> implements EventListener<DocumentSnapshot> {
    private final DocumentReference documentReference;
    private final Class<E> entityClass;
    private final String TAG = DocumentReferenceLiveData.class.getSimpleName();
    private ListenerRegistration listenerRegistration;

    public DocumentReferenceLiveData(DocumentReference documentReference, Class<E> entityClass) {
        this.documentReference = documentReference;
        this.entityClass = entityClass;
    }

    @Override
    protected void onActive() {
        this.listenerRegistration = this.documentReference.addSnapshotListener(this);
        super.onActive();
    }

    @Override
    protected void onInactive() {
        this.listenerRegistration.remove();
        super.onInactive();
    }

    @Override
    public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException error) {
        if (documentSnapshot != null && documentSnapshot.exists()) {
            Log.d(TAG, "Updating data");
            this.setValue(documentSnapshot.toObject(this.entityClass));
        } else if (error != null) {
            Log.e(TAG, error.getMessage(), error.getCause());
        }
    }
}
