import com.example.movieexplorer.data.remote.MovieApi
import com.example.movieexplorer.data.remote.mapper.toMovieDetails
import com.example.movieexplorer.domain.model.MovieDetails

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

    override suspend fun getMovieDetails(movieId: Int): MovieDetails {
        return movieApi
            .getMovieDetails(movieId)
            .toMovieDetails()
    }
}