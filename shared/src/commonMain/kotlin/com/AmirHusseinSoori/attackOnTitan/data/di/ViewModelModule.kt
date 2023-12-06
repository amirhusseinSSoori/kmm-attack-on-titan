package com.AmirHusseinSoori.attackOnTitan.data.di

import com.AmirHusseinSoori.attackOnTitan.ui.ImageScreen.AtackOnTitanViewModel


object ViewModelModule {
    fun injectAttackOnTitanViewModel(): AtackOnTitanViewModel {
        return AtackOnTitanViewModel(RepositoriesModule.injectCharacterRepository())
    }
}