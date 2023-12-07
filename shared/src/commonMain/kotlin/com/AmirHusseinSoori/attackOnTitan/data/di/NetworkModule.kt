package com.AmirHusseinSoori.attackOnTitan.data.di

import com.AmirHusseinSoori.attackOnTitan.data.network.AttackOnTitanClient
import com.AmirHusseinSoori.attackOnTitan.data.network.AttackOnTitanClientImp
import com.AmirHusseinSoori.attackOnTitan.data.network.services.CharacterServices
import com.AmirHusseinSoori.attackOnTitan.data.network.services.CharacterServicesImp

object NetworkModule {
    private fun injectClient(): AttackOnTitanClient {
        return AttackOnTitanClientImp()
    }

    fun injectCharacterServices(): CharacterServices {
        return CharacterServicesImp(injectClient())
    }

}