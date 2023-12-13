package com.AmirHusseinSoori.attackOnTitan.data.network.services




import app.cash.paging.Pager
import app.cash.paging.PagingConfig
import app.cash.paging.PagingData
import com.AmirHusseinSoori.attackOnTitan.data.paging.CharacterPagingSource
import com.AmirHusseinSoori.attackOnTitan.data.entity.CharacterResult
import com.AmirHusseinSoori.attackOnTitan.data.network.AttackOnTitanClient
import kotlinx.coroutines.flow.Flow
interface CharacterServices {
    fun getAllCharacters(): Flow<PagingData<CharacterResult>>
}

class CharacterServicesImp(private val client: AttackOnTitanClient) : CharacterServices {
    override fun getAllCharacters() = Pager(
        config = PagingConfig(
            pageSize = 10,
            maxSize = 100
        ),
        pagingSourceFactory = { CharacterPagingSource(client) }
    ).flow


}


