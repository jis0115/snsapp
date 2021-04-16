package jis.lonepine.snsapp.presentation.di

import dagger.Subcomponent
import jis.lonepine.snsapp.presentation.ui.card.CardFragment
import jis.lonepine.snsapp.presentation.ui.feed.FeedFragment
import jis.lonepine.snsapp.presentation.ui.home.HomeFragment
import jis.lonepine.snsapp.presentation.ui.main.MainActivity

@ActivityScope
@Subcomponent
interface CardComponent
{
    @Subcomponent.Factory
    interface Factory{
        fun create():CardComponent
    }
    fun inject(fragment: CardFragment)
}