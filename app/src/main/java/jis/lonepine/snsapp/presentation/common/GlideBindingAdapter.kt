package jis.lonepine.snsapp.presentation.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setGlideImageUrl")
fun setGlideImageUrl(imageView: ImageView,imageUrl:String?)
{
    imageUrl?.let {
        Glide.with(imageView.context).load(it).into(imageView)
    }

}