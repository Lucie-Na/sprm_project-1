package dao.daoFireBase;

import com.google.firebase.firestore.FirebaseFirestore;

public class Connection {
    private Connection myConnection;
    public static Connection instance;

    private void createConnection(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
    }
}
