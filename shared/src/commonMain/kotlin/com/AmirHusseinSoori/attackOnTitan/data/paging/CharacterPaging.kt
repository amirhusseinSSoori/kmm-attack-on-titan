package com.AmirHusseinSoori.attackOnTitan.data.paging

import androidx.paging.PagingState
import app.cash.paging.PagingSource
import com.AmirHusseinSoori.attackOnTitan.data.entity.CharacterEntity
import com.AmirHusseinSoori.attackOnTitan.data.entity.Result
import com.AmirHusseinSoori.attackOnTitan.data.network.AttackOnTitanClient
import io.ktor.client.call.body
import io.ktor.client.request.get

const val BASE_URL = "https://api.attackontitanapi.com/characters"

class CharacterPagingSource(
    private val httpClient: AttackOnTitanClient,
) : PagingSource<Int, Result>() {

    override fun getRefreshKey(state: PagingState<Int, Result>) = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val position = params.key ?: 1
        return try {
            val response = httpClient.getHttpClient().get(BASE_URL).body<CharacterEntity>()
            val results = response.results
            LoadResult.Page(
                data = results,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (results.isEmpty()) null else position + 1
            )
        } catch (exception: Throwable) {
            LoadResult.Error(exception)
        }
    }
}