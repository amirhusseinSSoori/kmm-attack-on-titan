package com.AmirHusseinSoori.attackOnTitan.ui


import app.cash.paging.PagingData
import app.cash.paging.cachedIn
import com.AmirHusseinSoori.attackOnTitan.data.entity.CharacterResult
import com.AmirHusseinSoori.attackOnTitan.data.repository.CharacterRepository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class AtackOnTitanViewModel(private val repository: CharacterRepository) :
    ViewModel() {
        fun getAllCharacter(): Flow<PagingData<CharacterResult>> =
        repository.getAllCharacters().cachedIn(viewModelScope).stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())

    }