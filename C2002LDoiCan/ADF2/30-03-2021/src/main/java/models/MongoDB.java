package models;
 import com.mongodb.*;
 import com.mongodb.client.*;
 import com.mongodb.client.model.Filters;

 import com.mongodb.client.model.UpdateOptions;
 import com.mongodb.client.result.*;
 import org.bson.Document;
 import org.bson.types.ObjectId;

 import java.util.List;
 import java.util.Arrays;
 import java.util.ArrayList;

 import static com.mongodb.client.model.Filters.*;
 import static com.mongodb.client.model.Updates.*;
import java.util.ArrayList;

public class MongoDB {
    public static final String MONGO_URL = "mongodb+srv://hoangnd:hoangnd123456@cluster0.pjz6j.mongodb.net/myFirstDatabase";
    //mongo "mongodb+srv://cluster0.pjz6j.mongodb.net/myFirstDatabase" --username hoangnd
    //pass hoangnd123456
    public static final String DB_NAME = "shop";
    private MongoDB() {}
    private static MongoDB instance;
    public static MongoDB getInstance(){
        if(instance == null) {
            instance = new MongoDB();
        }
        instance.getConnection();
        return instance;
    }
    public MongoDatabase getConnection() {
        try {
            MongoClient client = MongoClients.create(MONGO_URL);
            MongoDatabase database = client.getDatabase(DB_NAME);
            return database;
        }catch (Exception exception){
            System.err.println("Cannot connect to db.Error: "+exception.toString());
            return null;
        }
    }
    /*
    public ArrayList<Film> getAllFilms() {

    }
    */
    public MongoCollection<Document> getAllFilms() {
        try {

            MongoCollection<Document> films = this.getConnection().getCollection("films");

            MongoCursor<Document> cursor = films.find().iterator();
            while(cursor.hasNext()) {
                //cursor.next()
                Document document = cursor.next();
                String name = (String)document.get("name");
                System.out.println("aa");
            }
            System.out.println("success");
            return films;
        }catch (Exception exception) {
            System.err.println("cannot connect DB.Error: "+exception.toString());
            return null;
        }
    }

    public void saveFilms(ArrayList<Film> films) {
        try {
            for (Film film: films) {

            }
        }catch (Exception exception) {
            System.err.println("Cannot save to db.Error: "+exception.toString());
        }
    }
}
