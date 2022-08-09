package network;

import java.util.List;

import model.ListModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("products")
   Call<List<ListModel>>getList();


}
