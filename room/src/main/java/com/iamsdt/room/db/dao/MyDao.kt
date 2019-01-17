package com.iamsdt.room.db.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.iamsdt.room.db.User

@Dao
interface MyDao : BaseDao<User> {


    @Transaction
    fun updateData(users: List<User>) {
        deleteAllUsers()
        insert(users)
    }

    @Query("DELETE FROM User")
    fun deleteAllUsers()

    @Query("SELECT * FROM User WHERE userid = :id")
    fun getUserById(id: String): LiveData<User>

    fun getDistinctUserById(id: String):
            LiveData<User> = getUserById(id).getDistinct()
}

fun <T> LiveData<T>.getDistinct(): LiveData<T> {
    val distinctLiveData = MediatorLiveData<T>()
    distinctLiveData.addSource(this, object : Observer<T> {
        private var initialized = false
        private var lastObj: T? = null
        override fun onChanged(obj: T?) {
            if (!initialized) {
                initialized = true
                lastObj = obj
                distinctLiveData.postValue(lastObj)
            } else if ((obj == null && lastObj != null)
                || obj != lastObj
            ) {
                lastObj = obj
                distinctLiveData.postValue(lastObj)
            }
        }
    })
    return distinctLiveData
}