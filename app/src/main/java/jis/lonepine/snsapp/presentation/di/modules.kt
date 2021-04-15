package jis.lonepine.snsapp.presentation.di

import jis.lonepine.snsapp.BuildConfig
import jis.lonepine.snsapp.data.remote.SnsAppApi
import jis.lonepine.snsapp.domain.repository.CardsRepository
import jis.lonepine.snsapp.domain.repository.HomeRepository
import jis.lonepine.snsapp.domain.repository.UserRepository
import jis.lonepine.snsapp.domain.usecase.*
import jis.lonepine.snsapp.presentation.ui.card.CardViewModel
import jis.lonepine.snsapp.presentation.ui.common.CardItemViewModel
import jis.lonepine.snsapp.presentation.ui.common.UserItemViewModel
import jis.lonepine.snsapp.presentation.ui.feed.FeedViewModel
import jis.lonepine.snsapp.presentation.ui.home.HomeViewModel
import jis.lonepine.snsapp.presentation.ui.main.MainViewModel
import jis.lonepine.snsapp.presentation.ui.signin.SignInViewModel
import jis.lonepine.snsapp.presentation.ui.signup.SignUpViewModel
import jis.lonepine.snsapp.presentation.ui.userinfo.UserInfoViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

//TODO: dagger 이전 koin 으로 미리 작업 후 dagger 로 전환 예정..
val interceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

val client = OkHttpClient.Builder().addInterceptor(interceptor)
    .build()

val retrofit: Retrofit = Retrofit
    .Builder()
    .baseUrl(BuildConfig.API_URL)
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    .build()

private val api: SnsAppApi = retrofit.create(SnsAppApi::class.java)

val networkModule = module {
    single { api }
}

val repositoryModule = module {
    factory { CardsRepository(get()) }
    factory { HomeRepository(get()) }
    factory { UserRepository(get()) }
}

val useCaseModule = module {
    factory { GetCardDetailUseCase(get()) }
    factory { GetCardListUseCase(get()) }
    factory { GetHomeUseCase(get()) }
    factory { GetUserInfoUseCase(get()) }
    factory { SignInUseCase(get()) }
    factory { SignUpUseCase(get()) }
    factory { LoginCheckUseCase(get()) }
    factory { LogOutUseCase(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get(),get()) }
    viewModel { FeedViewModel(get()) }
    viewModel { SignUpViewModel(get()) }
    viewModel { SignInViewModel(get()) }
    viewModel { CardViewModel(get()) }
    viewModel { UserInfoViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { CardItemViewModel() }
    viewModel { UserItemViewModel() }
}

val moduleList = listOf(
    viewModelModule, useCaseModule, repositoryModule,networkModule
)