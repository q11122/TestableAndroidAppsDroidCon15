package it.cosenonjaviste.testableandroidapps.v6;

import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import it.cosenonjaviste.testableandroidapps.v3.WordPressService;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

@Module
public class MainModule {
    @Provides WordPressService provideWordPressService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://www.cosenonjaviste.it/")
                .setConverter(new GsonConverter(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()))
                .build();
        return restAdapter.create(WordPressService.class);
    }
}
