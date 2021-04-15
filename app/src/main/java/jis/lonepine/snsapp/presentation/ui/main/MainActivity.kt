package jis.lonepine.snsapp.presentation.ui.main

import android.graphics.Color
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import jis.lonepine.snsapp.R
import jis.lonepine.snsapp.databinding.ActivityMainBinding
import jis.lonepine.snsapp.presentation.base.BindingActivity
import jis.lonepine.snsapp.presentation.extension.observe
import jis.lonepine.snsapp.presentation.extension.add
import jis.lonepine.snsapp.presentation.extension.replace
import jis.lonepine.snsapp.presentation.ui.feed.FeedFragment
import jis.lonepine.snsapp.presentation.ui.home.HomeFragment
import jis.lonepine.snsapp.presentation.ui.signin.SignInFragment
import jis.lonepine.snsapp.presentation.ui.signup.SignUpFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel:MainViewModel by viewModel()
    override fun initView() {
        binding.viewModel = viewModel.apply {
            observe(showSignIn){
                replace(R.id.fragment_container_view,SignInFragment())
            }

            observe(showSignUp){
                replace(R.id.fragment_container_view,SignUpFragment())
            }
        }

        supportFragmentManager.addOnBackStackChangedListener {
            viewModel.checkLogin()
        }

        binding.viewPager.adapter = ScreenSlidePagerAdapter(supportFragmentManager)
        binding.pagerTitleStrip.setTextColor(Color.WHITE)
        binding.pagerTitleStrip.setGravity(Gravity.CENTER_VERTICAL)
    }

    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getCount(): Int = 2

        override fun getItem(position: Int): Fragment
        {
            return if (position == 0){
                HomeFragment()
            }else{
                FeedFragment()
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return if (position == 0 )
            {
                "홈"
            }
            else
            {
                "사진피드"
            }
        }

    }
}