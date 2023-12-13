package com.AmirHusseinSoori.attackOnTitan.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class CharacterEntity(
    val info: CharacterInfo,
    val results: List<CharacterResult>
)

@Serializable
data class Group(
    val name: String,
    val sub_groups: List<String>
)

@Serializable
data class CharacterInfo(
    val count: Int,
    val next_page: String,
    val pages: Int,
    val prev_page: Int? = 0
)

@Serializable
data class Relative(
    val family: String,
    val members: List<String>
)

@Serializable
data class CharacterResult(
    val alias: List<String>,
    val birthplace: String,
    val episodes: List<String>,
    val gender: String,
    val groups: List<Group>,
    val height: String,
    val id: Long,
    val img: String? = LimaCharacter,
    val name: String,
    val occupation: String,
    val relatives: List<Relative>,
    val residence: String,
    val roles: List<String>,
    val species: List<String>,
    val status: String
)

//In this api image Of Lima is null
const val LimaCharacter= "https://otakulevel10.fr/wp-content/uploads/2023/03/Lima.webp"