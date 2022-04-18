package com.twoodby.mykmmexample

class GetLatestComicUseCase(private val xkcdApi: XkcdApi) {
    suspend fun run() = xkcdApi.fetchLatestComic().let {
        ComicModel(it.img, it.title)
    }
}
