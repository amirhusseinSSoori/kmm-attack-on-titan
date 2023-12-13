package com.AmirHusseinSoori.attackOnTitan.data.entity

data class TitanEntity(
    val info: CharacterInfo,
    val results: List<Result>
)

data class Result(
    val abilities: List<String>,
    val allegiance: String,
    val current_inheritor: String,
    val former_inheritors: List<String>,
    val height: String,
    val id: Int,
    val img: String,
    val name: String
)

data class Info(
    val count: Int,
    val next_page: Any,
    val pages: Int,
    val prev_page: Any
)
