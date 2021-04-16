package jis.lonepine.snsapp.data.datasource

import io.reactivex.rxjava3.core.Single
import jis.lonepine.snsapp.data.remote.reponse.HomeResponse

interface HomeDataSource {
    fun getHomeData(): Single<HomeResponse>
}