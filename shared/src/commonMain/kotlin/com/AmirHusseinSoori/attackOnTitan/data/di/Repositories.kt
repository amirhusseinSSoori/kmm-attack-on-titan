package com.AmirHusseinSoori.attackOnTitan.data.di

import com.AmirHusseinSoori.attackOnTitan.data.repository.ImageRepository
import com.AmirHusseinSoori.attackOnTitan.data.repository.ImageRepositoryImp



fun initImageRepository(): ImageRepository {
    return ImageRepositoryImp()
}