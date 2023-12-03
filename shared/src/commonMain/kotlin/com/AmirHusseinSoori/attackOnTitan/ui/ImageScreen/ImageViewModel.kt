package com.AmirHusseinSoori.attackOnTitan.ui.ImageScreen

import com.AmirHusseinSoori.attackOnTitan.data.di.initImageRepository
import com.AmirHusseinSoori.attackOnTitan.data.repository.ImageRepository
import moe.tlaster.precompose.viewmodel.ViewModel

class ImageViewModel(private val repository: ImageRepository = initImageRepository()) : ViewModel() {

    fun getUrl():String{
        return repository.getUrl()
    }

}