package jis.lonepine.snsapp.presentation.di

import dagger.Module
import dagger.Provides
import jis.lonepine.snsapp.data.remote.SnsAppApi
import retrofit2.Retrofit
import jis.lonepine.snsapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideInterceptor(): Interceptor
    {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideOkHttpClient(interceptor: Interceptor):OkHttpClient
    {
        return OkHttpClient.Builder().addInterceptor(interceptor)
            .build()
    }


    @Provides
    fun provideSnsApi(okHttpClient: OkHttpClient):SnsAppApi
    {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(SnsAppApi::class.java)
    }
}