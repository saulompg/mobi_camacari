package com.icti.mobi_camacari.data.classes

data class UsersItem(
    val bairro: String,
    val bens: List<Ben>,
    val cor: String,
    val cpf: String,
    val defs: List<Def>,
    val end: String,
    val escolaridade: String,
    val id_usuario: Int,
    val idade: Int,
    val latitude: Int,
    val longitude: Int,
    val nome: String,
    val nome_social: String,
    val plusCode: String,
    val profissao: String,
    val renda_mensal: String,
    val sexo: String,
    val telefone: Long,
    val telefone_contato: Long,
    val tipo_moradia: String
)