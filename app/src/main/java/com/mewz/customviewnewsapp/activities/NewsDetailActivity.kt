package com.mewz.customviewnewsapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.mewz.customviewnewsapp.data.models.NewsModel
import com.mewz.customviewnewsapp.data.models.NewsModelImpl
import com.mewz.customviewnewsapp.data.vos.NewsVO
import com.mewz.customviewnewsapp.databinding.ActivityNewsDetailBinding
import java.util.function.LongFunction

class NewsDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityNewsDetailBinding
    private var mNewsModel: NewsModel = NewsModelImpl

    companion object{
        const val NEWS_ID_EXTRA = "News Id Extra"
        fun newIntent(context: Context, newsId: Int): Intent {
            val intent = Intent(context, NewsDetailActivity::class.java)
            intent.putExtra(NEWS_ID_EXTRA, newsId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsId = intent.getIntExtra(NEWS_ID_EXTRA, 0 )
        mNewsModel.getNewsById(newsId)
            .observe(this, Observer {
                bindData(it)
            })
    }

    private fun bindData(news: NewsVO) {
        binding.tvNewsHeadLine.text = news.title

        Glide.with(this)
            .load(news.heroImage)
            .into(binding.ivNewsImage)

        binding.tvNewsDescription.text = news.description
        news.comments.forEach {
            Log.e("ccc", it.commentMessage)
        }

    }
}

