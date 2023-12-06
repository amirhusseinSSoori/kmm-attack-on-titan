package com.AmirHusseinSoori.attackOnTitan.data.repository


import app.cash.paging.PagingData
import com.AmirHusseinSoori.attackOnTitan.data.Result
import com.AmirHusseinSoori.attackOnTitan.data.network.CharacterServices
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getAllCharacters(): Flow<PagingData<Result>>
}

class CharacterRepositoryImp(private val services: CharacterServices) :
    CharacterRepository {
    override fun getAllCharacters(): Flow<PagingData<Result>> {
        return services.getAllCharacters()
    }


}