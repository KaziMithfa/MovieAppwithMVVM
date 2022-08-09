package viewmodel;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import model.ListModel;
import network.ApiInterface;
import network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListViewModel extends ViewModel {

    public MutableLiveData<List<ListModel>>list;

    public ListViewModel(){

        list = new MutableLiveData<>();

    }

    public MutableLiveData<List<ListModel>> getMovieListObserver(){
        return  list;
    }

    public void makeApiCall(){
        ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        Call<List<ListModel>> call = apiInterface.getList();

        call.enqueue(new Callback<List<ListModel>>() {
            @Override
            public void onResponse(Call<List<ListModel>> call, Response<List<ListModel>> response) {

                list.postValue(response.body());
                

            }

            @Override
            public void onFailure(Call<List<ListModel>> call, Throwable t) {
                
                list.postValue(null);



            }
        });
    }
}
