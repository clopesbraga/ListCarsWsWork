package br.com.wsworks.listcarswswork.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class WsWorksApi {

    companion object {
        private lateinit var instance: Retrofit
        private var baseUrl = "https://wswork.com.br/"

        private fun getInstance(): Retrofit {

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val httpClient = OkHttpClient.Builder()
            if (!::instance.isInitialized) {
                instance = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return instance

        }

        fun <S> createService(servicesClass: Class<S>): S {
            return getInstance().create(servicesClass)
        }

    }

}