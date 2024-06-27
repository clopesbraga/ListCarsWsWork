package br.com.wsworks.listcarswswork.model

import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("ano") val ano: Int,
    @SerializedName("combustivel") val combustivel: String,
    @SerializedName("cor") val cor: String,
    @SerializedName("id") val id: Int,
    @SerializedName("modelo_id") val modelo_id: Int,
    @SerializedName("nome_modelo") val nome_modelo: String,
    @SerializedName("num_portas") val num_portas: Int,
    @SerializedName("timestamp_cadastro") val timestamp_cadastro: Long,
    @SerializedName("valor")val valor: Double
)