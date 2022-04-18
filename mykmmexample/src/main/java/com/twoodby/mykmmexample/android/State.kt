package com.twoodby.mykmmexample.android

import com.twoodby.mykmmexample.ComicModel

sealed class State {
    object Loading : State()
    class Success(val result: ComicModel) : State()
    object Error : State()
}
