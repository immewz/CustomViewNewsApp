package com.mewz.customviewnewsapp.workers

import android.content.Context
import androidx.work.WorkerParameters

class GetNewsWorker(context: Context, workerParameters: WorkerParameters)
    : BaseWorker(context, workerParameters) {

    override fun doWork(): Result {
        var result = Result.failure()

        mNewsModel.getAllNewsFromApiAndSaveToDatabase(
            onSuccess = { result = Result.success() },
            onError = { result = Result.failure() }
        )

        return result
    }

}