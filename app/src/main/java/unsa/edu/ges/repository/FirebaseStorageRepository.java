package unsa.edu.ges.repository;

import android.graphics.Bitmap;
import android.net.Uri;

import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

//For charge img in ui component check this documentation: https://firebase.google.com/docs/storage/android/download-files?hl=es

public abstract class FirebaseStorageRepository<E> {
    private final StorageReference storageReference;
    private final Class<E> entityClass;

    public FirebaseStorageRepository(Class<E> entityClass) {
        this.entityClass = entityClass;
        this.storageReference = FirebaseStorage.getInstance().getReference(entityClass.getName());
    }

    public UploadTask uploadBitmap(String fileName, Bitmap.CompressFormat imageFormat, Bitmap bitmap) {
        StorageReference fileReference = this.storageReference.child(fileName + "." + imageFormat.name().toLowerCase());
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        bitmap.compress(imageFormat, 100, byteStream);
        return fileReference.putBytes(byteStream.toByteArray());
    }

    public UploadTask uploadFile(String fileNameWithExtension, Uri uriFile) {
        StorageReference fileReference = this.storageReference.child(fileNameWithExtension);
        return fileReference.putFile(uriFile);
    }

    public UploadTask uploadStream(String fileNameWithExtension, InputStream fileStream) {
        StorageReference fileReference = this.storageReference.child(fileNameWithExtension);
        return fileReference.putStream(fileStream);
    }

    public Task<byte[]> downloadBytes(String fileNameWithExtension) {
        StorageReference fileReference = this.storageReference.child(fileNameWithExtension);
        // Download max 10 MB
        return fileReference.getBytes(1024 * 1024 * 10);
    }

    public FileDownloadTask downloadFile(String fileNameWithExtension, File destinationFile) {
        StorageReference fileReference = this.storageReference.child(fileNameWithExtension);
        return fileReference.getFile(destinationFile);
    }
}
