package com.iamsdt.paging

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.iamsdt.paging.db.MyDB
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DataInsert(val context: Context, pram: WorkerParameters) :
    Worker(context, pram) {

    override fun doWork(): Result {
        val dao = MyDB.getDao(context)
        val ret = RestServices.instance()

        val response = ret.getPhotos().execute()

        if (response.isSuccessful) {
            GlobalScope.launch {
                val body = response.body()
                body?.let { dao.insert(it) }
            }
        }

        return Result.success()
    }

}