package com.example.cheezycode

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class Observer: LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun ON_RESUME() {
        Log.d("lifecycle", "Observer - ON_RESUME")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun ON_CREATE() {
        Log.d("lifecycle", "Observer - ON_CREATE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun ON_DESTROY() {
        Log.d("lifecycle", "Observer - ON_DESTROY")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun ON_PAUSE() {
        Log.d("lifecycle", "Observer - ON_PAUSE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun ON_STOP() {
        Log.d("lifecycle", "Observer - ON_STOP")
    }
}