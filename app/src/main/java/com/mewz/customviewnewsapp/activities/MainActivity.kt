package com.mewz.customviewnewsapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mewz.customviewnewsapp.R
import com.mewz.customviewnewsapp.adapters.NewsListAdapter
import com.mewz.customviewnewsapp.data.vos.NewsVO
import com.mewz.customviewnewsapp.databinding.ActivityMainBinding
import com.mewz.customviewnewsapp.mvp.presenters.MainPresenter
import com.mewz.customviewnewsapp.mvp.presenters.MainPresenterImpl
import com.mewz.customviewnewsapp.mvp.views.MainView
import com.mewz.customviewnewsapp.utiles.EMPTY_IMAGE_URL
import com.mewz.customviewnewsapp.utiles.EM_NO_NEWS_AVAILABLE
import com.mewz.customviewnewsapp.views.viewpods.EmptyViewPod

class MainActivity : BaseActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mAdapter: NewsListAdapter
    private lateinit var mViewPodEmpty: EmptyViewPod
    private lateinit var mPresenter: MainPresenter

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpPresenter()

        //hideEmptyView()
        setUpSwipeRefresh()
        setUpRecyclerView()
        setUpViewPod()
        setUpListeners()
        mPresenter.onUiReady(this)
    }

    private fun setUpListeners() {
        binding.btnNavigate.setOnClickListener {
            startActivity(ModifyCustomViewActivity.newIntent(this))
        }
    }

    override fun displayNewsList(newsList: List<NewsVO>) {
        mAdapter.setNewData(newsList.toMutableList())
    }

    override fun navigateToNewsDetails(newsId: Int) {
        startActivity(NewsDetailActivity.newIntent(this, newsId))
    }

    override fun displayEmptyView() {
        // showEmptyView()
    }

    override fun enableSwipeRefresh() {
        binding.swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        binding.swipeRefreshLayout.isRefreshing = false
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    private fun setUpViewPod() {
        mViewPodEmpty = binding.vpEmptyData.root
        mViewPodEmpty.setEmptyData(EM_NO_NEWS_AVAILABLE, EMPTY_IMAGE_URL)
        mViewPodEmpty.setDelegate(mPresenter)
    }

    private fun setUpSwipeRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            mPresenter.onSwipeRefresh(this)
        }
    }

    private fun setUpRecyclerView() {
        mAdapter = NewsListAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvNews.layoutManager = linearLayoutManager
        binding.rvNews.adapter = mAdapter

        mViewPodEmpty = findViewById<EmptyViewPod>(R.id.vpEmptyData)
        binding.rvNews.setEmptyView(mViewPodEmpty)
    }



//    private fun showEmptyView() {
//       //binding.vpEmpty.visibility = View.VISIBLE
//        val view = findViewById<EmptyViewPod>(R.id.vpEmptyData)
//        view.visibility = View.VISIBLE
//    }
//
//    private fun hideEmptyView() {
//        //binding.vpEmpty.visibility = View.GONE
//        val view = findViewById<EmptyViewPod>(R.id.vpEmptyData)
//        view.visibility = View.GONE
//    }

}
