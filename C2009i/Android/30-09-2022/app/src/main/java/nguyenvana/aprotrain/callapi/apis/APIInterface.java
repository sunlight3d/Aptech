package nguyenvana.aprotrain.callapi.apis;
import java.util.ArrayList;
import java.util.List;

import nguyenvana.aprotrain.callapi.pojo.Photo;
import retrofit2.*;
import retrofit2.http.*;

public interface APIInterface {

//    @POST("/api/photos")
//    Call<User> createUser(@Body User user);

    @GET("/photos")
    Call<ArrayList<Photo>> getPhotos(@Query("page") int page);

//    @FormUrlEncoded
//    @POST("/api/users?")
//    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
}