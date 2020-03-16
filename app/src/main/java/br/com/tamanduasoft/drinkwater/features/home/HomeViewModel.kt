package br.com.tamanduasoft.drinkwater.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.tamanduasoft.drinkwater.domain.Cup
import br.com.tamanduasoft.drinkwater.domain.repository.CupRepository
import br.com.tamanduasoft.drinkwater.features.home.model.HomeAction
import br.com.tamanduasoft.drinkwater.features.home.model.HomeViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class HomeViewModel(
    private val cupRepository: CupRepository
) : ViewModel() {

    private val _state = MutableLiveData<HomeViewState>()
    val state = _state as LiveData<HomeViewState>

    private val _action = MutableLiveData<HomeAction>()
    val action = _action as LiveData<HomeAction>

    fun getInformation() {
        _state.value = HomeViewState(
            progress = 40,
            objective = "4L",
            accomplished = "1,3L",
            pending = "2,7L"
        )
    }

    fun onAddClicked() {
        viewModelScope.launch {
            cupRepository.getAll()
                .flowOn(Dispatchers.IO)
                .collect { cups ->  _action.value = HomeAction.ShowDrinkingOptions(cups) }
        }
    }

    fun onCupSelected(cup: Cup) {

    }
}