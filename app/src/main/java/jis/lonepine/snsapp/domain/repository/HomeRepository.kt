package jis.lonepine.snsapp.domain.repository

import io.reactivex.rxjava3.core.Single
import jis.lonepine.snsapp.data.datasource.HomeDataSource
import jis.lonepine.snsapp.data.remote.reponse.HomeResponse
import jis.lonepine.snsapp.data.remote.SnsAppApi
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api:SnsAppApi):HomeDataSource {
    override fun getHomeData(): Single<HomeResponse> {
        return api.getHome()
    }
}