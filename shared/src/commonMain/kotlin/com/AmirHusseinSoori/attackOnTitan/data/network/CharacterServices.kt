package com.AmirHusseinSoori.attackOnTitan.data.network




import app.cash.paging.Pager
import app.cash.paging.PagingConfig
import app.cash.paging.PagingData
import com.AmirHusseinSoori.attackOnTitan.data.CharacterPagingSource
import com.AmirHusseinSoori.attackOnTitan.data.Result
import kotlinx.coroutines.flow.Flow
interface CharacterServices {
    fun getAllCharacters(): Flow<PagingData<Result>>
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


