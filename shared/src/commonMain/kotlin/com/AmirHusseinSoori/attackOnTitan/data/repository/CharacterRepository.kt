package com.AmirHusseinSoori.attackOnTitan.data.repository


import app.cash.paging.PagingData
import com.AmirHusseinSoori.attackOnTitan.data.entity.CharacterResult
import com.AmirHusseinSoori.attackOnTitan.data.network.services.CharacterServices
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getAllCharacters(): Flow<PagingData<CharacterResult>>
}

class CharacterRepositoryImp(private val services: CharacterServices) :
    CharacterRepository {
    override fun getAllCharacters(): Flow<PagingData<CharacterResult>> {
        return services.getAllCharacters()
    }


}