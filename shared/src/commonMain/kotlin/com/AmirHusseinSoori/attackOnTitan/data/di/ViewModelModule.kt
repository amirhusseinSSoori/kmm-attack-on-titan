package com.AmirHusseinSoori.attackOnTitan.data.di

import com.AmirHusseinSoori.attackOnTitan.ui.AtackOnTitanViewModel


object ViewModelModule {
    fun injectAttackOnTitanViewModel(): AtackOnTitanViewModel {
        return AtackOnTitanViewModel(RepositoriesModule.injectCharacterRepository())
    }
}