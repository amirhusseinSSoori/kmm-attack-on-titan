package com.AmirHusseinSoori.attackOnTitan.data.di


import com.AmirHusseinSoori.attackOnTitan.data.repository.CharacterRepository
import com.AmirHusseinSoori.attackOnTitan.data.repository.CharacterRepositoryImp


object RepositoriesModule {
    fun injectCharacterRepository(): CharacterRepository {
        return CharacterRepositoryImp(NetworkModule.injectCharacterServices())
    }
}

