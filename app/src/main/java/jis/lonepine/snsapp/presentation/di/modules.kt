package jis.lonepine.snsapp.presentation.di

import jis.lonepine.snsapp.BuildConfig
import jis.lonepine.snsapp.data.remote.SnsAppApi
import jis.lonepine.snsapp.domain.repository.CardsRepository
import jis.lonepine.snsapp.domain.repository.HomeRepository
import jis.lonepine.snsapp.domain.repository.UserRepository
import jis.lonepine.snsapp.domain.usecase.*
import jis.lonepine.snsapp.presentation.ui.card.CardViewModel
import jis.lonepine.snsapp.presentation.ui.feed.FeedViewModel
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

val interceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

//val tls = ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
//    .allEnabledTlsVersions()
//    .allEnabledCipherSuites()
//    .build()

val client = OkHttpClient.Builder().addInterceptor(interceptor)
//    .connectionSpecs(
//        listOf(ConnectionSpec.CLEARTEXT,tls)
//    )
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
}

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { FeedViewModel(get()) }
    viewModel { SignUpViewModel(get()) }
    viewModel { SignInViewModel(get()) }
    viewModel { CardViewModel(get()) }
    viewModel { UserInfoViewModel(get()) }

//    viewModel { SplashViewModel(get(),get(),get(),get(),get()) }
//    viewModel { SplashViewModel(get(),get(),get(),get(),get()) }
//    viewModel { MainViewModel(get(),get()) }
//    viewModel { HomeViewModel(get()) }
//
//    viewModel { AccessPermissionInfoViewModel(get()) }
//
//    viewModel { GnbMenuViewModel(get()) }
//    viewModel { GnbHeaderViewModel() }
//    viewModel { MyServiceViewModel(get(),get(),get()) }
//    viewModel { SettingViewModel(get(),get()) }
//    viewModel { LoginViewModel(get(),get()) }
//    viewModel { SignUpViewModel(get(),get(),get(),get()) }
//    viewModel { SelectGenderAndAgeViewModel(get(),get()) }
//    viewModel { SignUpCompletedViewModel() }
//    viewModel { AllMenuViewModel() }
//    viewModel { VersionInfoViewModel() }
//    viewModel { FindIdViewModel(get(),get()) }
//    viewModel { FindPasswordViewModel(get(),get()) }
//    viewModel { ChangePasswordViewModel(get()) }
//    viewModel { FavoriteBoxViewModel() }
//    viewModel { ShopViewModel(get(),get(),get()) }
//    viewModel { MyPageViewModel(get(),get(),get()) }
//
//    viewModel { VerificationEditProfileViewModel(get()) }

}

//val preference = module {
//    single { androidx.preference.PreferenceManager.getDefaultSharedPreferences(get()) }
//}

val moduleList = listOf(
    viewModelModule, useCaseModule, repositoryModule,networkModule
)