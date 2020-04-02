package android.latihan.modul_8

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommuViewModel  : ViewModel() {
    private val mName = MutableLiveData<String>()
    private val mWeb = MutableLiveData<String>()
    val name: LiveData<String>
        get() = mName
    val linkWeb: LiveData<String>
        get() = mWeb
    fun setName(name: String) {
        mName.value = name
    }
    fun setWeb(url: String){
        mWeb.value = url
    }
}