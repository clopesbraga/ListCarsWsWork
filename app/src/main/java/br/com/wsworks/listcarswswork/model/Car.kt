package br.com.wsworks.listcarswswork.model

data class Car(
    val ano: Int,
    val combustivel: String,
    val cor: String,
    val id: Int,
    val modelo_id: Int,
    val nome_modelo: String,
    val num_portas: Int,
    val timestamp_cadastro: Long,
    val valor: Double
)