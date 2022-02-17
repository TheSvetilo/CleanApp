package com.vbogd.cleanapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vbogd.cleanapp.domain.models.SaveUserName
import com.vbogd.cleanapp.domain.use_cases.GetUserUseCase
import com.vbogd.cleanapp.domain.use_cases.SaveNameUseCase

class MainViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val saveNameUseCase: SaveNameUseCase
): ViewModel() {

    private val _result: MutableLiveData<String> = MutableLiveData<String>()
    val result: LiveData<String> = _result

    fun getData() {
        val data = getUserUseCase.execute()
        _result.value = "${data.userName} ${data.lastName}"
    }

    fun saveData(data: String) {
        val param = SaveUserName(data)
        val result = saveNameUseCase.execute(param)
        _result.value = "Save Result = $result"
    }

}