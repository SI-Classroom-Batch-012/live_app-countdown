package com.example.liveappcountdown

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CountdownViewmodel : ViewModel() {

    private var timerJob: Job? = null

    //Timer, der die Anzahl an verbleibenden Sekunde enthält
    private val _timer: MutableLiveData<Int> = MutableLiveData(30)
    val timer: LiveData<Int>
        get() = _timer

    init {
        startTimer()
    }

    fun startTimer(){

        timerJob = viewModelScope.launch {

            var localTimer = 30
            while(localTimer > 0){

                //Eine Sekunde warten
                delay(1000)

                //Timer um 1 reduzieren
                localTimer--

                //Neuen Wert in die LiveData posten
                _timer.postValue(localTimer)
            }
        }
    }






    fun stopTimer(){

        Log.d("CoroutineTest", timerJob.toString())

        //Wenn es den timerJob gibt(ungleich null) -> Stopp den Job, cancel()
        timerJob?.cancel()
    }

}