package com.twoodby.mykmmexample

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}