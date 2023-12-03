package com.AmirHusseinSoori.attackOnTitan.data.repository

interface ImageRepository{
    fun getUrl():String
}
class ImageRepositoryImp : ImageRepository {
    override fun getUrl(): String {
        return "https://m.media-amazon.com/images/M/MV5BNDFjYTIxMjctYTQ2ZC00OGQ4LWE3OGYtNDdiMzNiNDZlMDAwXkEyXkFqcGdeQXVyNzI3NjY3NjQ@._V1_FMjpg_UX1000_.jpg"
    }
}