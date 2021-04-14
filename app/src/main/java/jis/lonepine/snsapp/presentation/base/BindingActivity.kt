package jis.lonepine.snsapp.presentation.base

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BindingActivity<B : ViewDataBinding>(private val layoutId : Int) : AppCompatActivity() {
    lateinit var binding : B
    abstract fun initView()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(layoutInflater,layoutId,null,false)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        initView()

//        setSupportActionBar(toolbar)

        //Now show or hide according to your need
        supportActionBar?.hide()
//        supportActionBar.show();
    }
}