package com.iamsdt.room.db.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.iamsdt.room.db.MyData

@Dao
interface MyDao : BaseDao<MyData> {


    @Transaction
    fun updateData(users: List<MyData>) {
        deleteAllUsers()
        insert(users)
    }

    @Query("DELETE FROM MyData")
    fun deleteAllUsers()

    @Query("SELECT * FROM MyData WHERE userid = :id")
    fun getUserById(id: String): LiveData<MyData>

    fun getDistinctUserById(id: String):
            LiveData<MyData> = getUserById(id).getDistinct()
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