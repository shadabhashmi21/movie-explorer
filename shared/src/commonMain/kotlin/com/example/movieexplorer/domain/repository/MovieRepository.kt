import com.example.movieexplorer.domain.model.Movie

interface MovieRepository{
    suspend fun getTopRatedMovies(): List<Movie>
}