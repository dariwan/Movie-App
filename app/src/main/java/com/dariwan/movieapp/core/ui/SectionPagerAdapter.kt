package com.dariwan.movieapp.core.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dariwan.movieapp.R
import com.dariwan.movieapp.view.home.nowplaying.NowPlayingFragment
import com.dariwan.movieapp.view.home.popular.PopularFragment
import com.dariwan.movieapp.view.home.toprated.TopRatedFragment
import com.dariwan.movieapp.view.home.upcoming.UpcomingFragment

class SectionPagerAdapter(private val mCtx: Context, fm: FragmentManager, data: Bundle):
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    private val TAB_TITLES = intArrayOf(
        R.string.now_playing,
        R.string.upcoming,
        R.string.top_rated,
        R.string.popular
    )

    private var fragmentBundle: Bundle

    init {
        fragmentBundle = data
    }

    override fun getCount(): Int = 4

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0 -> fragment = NowPlayingFragment()
            1 -> fragment = UpcomingFragment()
            2 -> fragment = TopRatedFragment()
            3 -> fragment = PopularFragment()
        }
        fragment?.arguments = this.fragmentBundle
        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mCtx.resources.getString(TAB_TITLES[position])
    }
}