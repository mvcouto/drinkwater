package br.com.tamanduasoft.drinkwater.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.tamanduasoft.drinkwater.home.model.HomeAction
import br.com.tamanduasoft.drinkwater.home.model.HomeState

class HomeViewModel : ViewModel() {

    private val _state = MutableLiveData<HomeState>()
    val state = _state as LiveData<HomeState>

    private val _action = MutableLiveData<HomeAction>()
    val action = _action as LiveData<HomeAction>

    fun getInformation() {
        _state.value = HomeState(
            progress = 40,
            objective = "4L",
            accomplished = "1,3L",
            pending = "2,7L"
        )
    }

    fun onAddClicked() {

    }
}