import com.example.movieexplorer.domain.model.MovieDetails

interface MovieRepository {
    suspend fun getTopRatedMovies(page: Int): MoviePage

    suspend fun getMovieDetails(movieId: Int): MovieDetails
}