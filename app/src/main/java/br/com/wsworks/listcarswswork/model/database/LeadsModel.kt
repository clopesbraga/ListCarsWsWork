package br.com.wsworks.listcarswswork.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Leads")
class LeadsModel(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id") var id: Int,
    @ColumnInfo("timestamp_cadastro") var timestamp_cadastro: Double,
    @ColumnInfo("modelo_id") var modelo_id: Int,
    @ColumnInfo("ano") var ano: Int,
    @ColumnInfo("combustivel") var combustivel: String,
    @ColumnInfo("num_portas") var num_portas: Int,
    @ColumnInfo("cor") var cor: String,
    @ColumnInfo("nome_modelo") var nome_modelo: String,
    @ColumnInfo("valor") var valor: Double,
    @ColumnInfo("user_email") var user_email: String
)