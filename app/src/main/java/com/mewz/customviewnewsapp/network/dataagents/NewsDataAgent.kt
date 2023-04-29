package com.mewz.customviewnewsapp.network.dataagents

import com.mewz.customviewnewsapp.data.vos.NewsVO

interface NewsDataAgent {
    fun getAllNews(
        accessToken: String,
        onSuccess: (List<NewsVO>) -> Unit,
        onFailure: (String) -> Unit
    )
}