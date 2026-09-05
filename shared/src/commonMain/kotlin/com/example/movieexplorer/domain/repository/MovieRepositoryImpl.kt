import com.example.movieexplorer.data.remote.MovieApi
import com.example.movieexplorer.domain.model.Movie

class MovieRepositoryImpl(
    private val movieApi: MovieApi
): MovieRepository{
    override suspend fun getTopRatedMovies(): List<Movie> {
        return movieApi.getTopRatedMovies().results.map { it.toMovie() }
    }
}