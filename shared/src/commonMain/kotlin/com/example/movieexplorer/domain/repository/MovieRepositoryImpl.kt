import com.example.movieexplorer.data.remote.MovieApi

class MovieRepositoryImpl(
    private val movieApi: MovieApi
) : MovieRepository {
    override suspend fun getTopRatedMovies(page: Int): MoviePage {
        val response = movieApi.getTopRatedMovies(page)

        return MoviePage(
            movies = response.results.map { it.toMovie() },
            page = response.page,
            totalPages = response.totalPages
        )
    }
}