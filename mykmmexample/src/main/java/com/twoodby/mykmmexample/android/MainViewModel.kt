package com.twoodby.mykmmexample.android

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.twoodby.mykmmexample.GetLatestComicUseCase
import com.twoodby.mykmmexample.XkcdApi
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val getLatestComicUseCase = GetLatestComicUseCase(XkcdApi())
    val comic = MutableLiveData<State>()

    fun fetchComic() {
        viewModelScope.launch {
            comic.value = State.Loading
            runCatching { getLatestComicUseCase.run() }
                .onSuccess { comic.value = State.Success(it) }
                .onFailure {
                    Log.d("TAG", "fetchComic: ${it.localizedMessage})")
                    comic.value = State.Error
                }
        }
    }
}
