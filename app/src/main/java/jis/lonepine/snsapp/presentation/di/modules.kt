package jis.lonepine.snsapp.presentation.di

import jis.lonepine.snsapp.BuildConfig
import jis.lonepine.snsapp.data.remote.SnsAppApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
//    factory { CommonRepository(get(),get()) }
//    factory { NotificationRepository(get()) }
//    factory { ShopRepository(get()) }
//    factory { GenieBoxRepository(get(),get()) }
//    factory { UserRepository(get(),get()) }
//    factory { CustomerServiceRepository(get()) }
}

val useCaseModule = module {

//    factory { LoadConfigUseCase(get()) } //앱 초기 실행시 API-001	앱기본설정정보 로그
//
//    factory { HomeUseCase(get()) } // API-002	Home 정보노출
//
//    factory { (TickerUseCase(get())) } // API-003	Ticker 정보
//
//    factory { MyServiceUseCase(get()) } // API-004	나의서비스
//
//    factory { LogoutUseCase(get()) } // API-005	로그아웃
//
//    factory { LoginUseCase(get()) } // API-006	로그인
//
//    factory { ChangePasswordUseCase(get()) } // API-007	비밀번호 변경
//
//    factory { AuthenticationNumberUseCase(get()) } // API-008	sms 인증번호 받기
//
//    factory { UnLockUseCase(get()) } // API-009	잠금해제
//
//    factory { SignUpUseCase(get()) } // API-010	회원가입
//
//    factory { UpdateProfileUseCase(get()) } // API-011	회원정보 업데이트
//
//    factory { SendSMSCheckUseCase(get()) } // API-012	아이디찾기
//    factory { JoinCheckUseCase(get()) } // API-013	회원가입정보 체크
//
//    factory { ReceiveTempPasswordUseCase(get()) } // API-014	임시비밀번호 받기
//
//    factory { ChangeAppSettingUseCase(get()) } // API-015	앱 설정 변경
//
//    factory { MyPageUseCase(get()) } // API-016	마이페이지
//
//    factory { MyProfileUseCase(get()) } // API-017	회원정보
//
//    factory { ChangeMyProfileUseCase(get()) } // API-018	회원정보 수정
//
//    factory { MyCombinationListUseCase(get()) } //API-019	나의 조합내역(조합번호)
//
//    factory { DeleteCombinationUseCase(get()) } // API-020	조합 삭제
//    factory { MyCombinationMarkingPaperUseCase(get()) } // API-021	나의조합내역(마킹용지보기)
//
//    factory { WithdrawalMemberInfoUseCase(get()) } // API-022	탈퇴회원정보
//    factory { WithdrawalMemberUseCase(get()) } // API-023	회원탈퇴
//
//    factory { GenieBoxMainUseCase(get()) } //API-024	지니박스 정보
//
//
//    factory { (GenieBoxSelectUseCase(get())) } //API-025	지니박스 선택상자 정보
//
//    factory { OpenGenieBoxUseCase(get()) } // API-026	지니박스 추천조합 받기
//
//    factory { GenieBoxResultInfoUseCase(get()) }// API-027	지니박스 성적
//
//    factory { GenieBoxCombinationInfoUseCase(get()) } // API-028	조합설명
//
//    factory { InAppItemListUseCase(get()) } // API-029	인앱상품 리스트
//
//    factory { BuyInAppUseCase(get()) } // API-030	상품 구매
//    factory { BuyFreeInAppUseCase(get()) } // API-040 // 무료상품구매
//
//    factory { NoticeUseCase(get()) } // API-031	공지사항
//
//    factory { GetQuestionOptionUseCase(get()) } // api-032 질문유형 가져오기
//
//    factory { WritePersonalInquiryUseCase(get()) } // API-033	1:1 문의 등록
//    factory { LoadPersonalInquiryListUseCase(get()) } // API-034	1:1 문의 내역
//
//    factory { NotificationUseCase(get()) } //API-035	알림
//    factory { DeletePushListUseCase(get()) } // API-036
//
//    factory { GetGradeSearchUseCase(get()) } // API-038
//
//
//
//
//
//    factory { CheckPermissionVisibleUseCase(get()) }
//    factory { SetVisiblePermissionUseCase(get()) }
//
//    factory { CheckMainCoachMarkUseCase(get()) }
//    factory { SetVisibleMainCoachMarkUseCase(get()) }
//
//
//    //local에 ci 저장
//    factory { InsertCIUseCase(get()) }
//    //local에 ci 삭제
//    factory { DeleteCIUseCase(get()) }
//
//    factory { LoadCIUseCase(get()) }

}

val viewModelModule = module {
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