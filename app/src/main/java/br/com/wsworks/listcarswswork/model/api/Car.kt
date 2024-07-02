package br.com.wsworks.listcarswswork.model.api

import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("id") val id: Int,
    @SerializedName("timestamp_cadastro") val timestamp_cadastro: Double,
    @SerializedName("modelo_id") val modelo_id:Int,
    @SerializedName("ano") val ano: Int,
    @SerializedName("combustivel") val combustivel: String,
    @SerializedName("num_portas") val num_portas: Int,
    @SerializedName("cor") val cor: String,
    @SerializedName("nome_modelo") val nome_modelo: String,
    @SerializedName("valor")val valor: Double
)