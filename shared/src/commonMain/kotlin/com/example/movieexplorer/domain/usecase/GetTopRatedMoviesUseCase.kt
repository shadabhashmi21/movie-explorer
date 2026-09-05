import com.example.movieexplorer.domain.model.Movie

class GetTopRatedMoviesUseCase(
    private val repository: MovieRepository
){
    suspend operator fun invoke(): List<Movie>{
        return repository.getTopRatedMovies()
    }
}