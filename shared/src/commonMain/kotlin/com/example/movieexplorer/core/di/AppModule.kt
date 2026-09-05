import com.example.movieexplorer.core.network.httpClient
import com.example.movieexplorer.data.remote.MovieApi
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { httpClient }

    single { MovieApi(get()) }

    single<MovieRepository>{
        MovieRepositoryImpl(get())
    }

    factory { GetTopRatedMoviesUseCase(get()) }

    viewModel { HomeViewModel(get()) }
}