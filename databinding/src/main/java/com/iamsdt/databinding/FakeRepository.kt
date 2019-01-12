package com.iamsdt.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

object FakeRepository {

    private val programmingLanName: List<String> = listOf(
        "Kotlin", "C", "Python", "Java", "C#", "Dart",
        "Perl", "Go", "Ruby", "Swift"
    )

    private val currentRandomName = MutableLiveData<String>()

    val currentRandomProName: LiveData<String>
        get() = currentRandomName

    init {
        currentRandomName.value = programmingLanName.first()
    }

    fun getRandomName(): String {
        val random = Random()
        return programmingLanName[random.nextInt(programmingLanName.size)]
    }

    fun changeCurrentRandomName() {
        currentRandomName.value = getRandomName()
    }
}