package com.mewz.customviewnewsapp.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.mewz.customviewnewsapp.data.models.NewsModel
import com.mewz.customviewnewsapp.data.models.NewsModelImpl

abstract class BaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    val mNewsModel : NewsModel = NewsModelImpl
}