package com.example.retrofitcrud_fragments.di.modules;

import com.example.retrofitcrud_fragments.api.BookInterface;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

//    public static final String BASE_URL = "https://spring-boot-mysql-server-part0.herokuapp.com/";
//    public Retrofit retrofit = null;
//
//    @Provides
//    BookInterface getBookInterface(Retrofit retrofit) {
//        return retrofit.create(BookInterface.class);
//    }
//
//    @Provides
//    Retrofit getRetrofit() {
//        if (retrofit == null) {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
//    }
}