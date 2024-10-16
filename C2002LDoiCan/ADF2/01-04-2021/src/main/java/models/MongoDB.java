package models;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MongoDB {
    public static final String MONGO_URL = "mongodb+srv://DESKTOP-7PS7HG8:27017";
    public static final String DB_NAME = "test";
    private Datastore datastore;
    private MongoDB() {}
    private static MongoDB instance;
    public static MongoDB getInstance(){
        if(instance == null) {
            instance = new MongoDB();
        }
        instance.getConnection();
        return instance;
    }
    public Datastore getConnection() {
        try {
            Morphia morphia = new Morphia();
            morphia.map(Film.class);
            //morphia.mapPackage("models");
            datastore = morphia.createDatastore(new MongoClient(MONGO_URL), DB_NAME);
            //datastore.ensureIndexes();
            return datastore;
        }catch (Exception exception){
            System.err.println("Cannot connect to db.Error: "+exception.toString());
            return null;
        }
    }
    public ArrayList<Film> getAllFilms() {
        ArrayList<Film> films = (ArrayList<Film>)this.getConnection().createQuery(Film.class)
          .field("title")
          .contains("Learning Java")
          .find()
          .toList();
        return films;
    }
    public void saveFilms(ArrayList<Film> films) {
        try {
            for (Film film: films) {
                datastore.save(film);
            }
        }catch (Exception exception) {
            System.err.println("Cannot save to db.Error: "+exception.toString());
        }
    }
}
