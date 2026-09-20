import com.example.movieexplorer.domain.model.MovieDetails

class GetMovieDetailsUseCase(private val repository: MovieRepository){
    suspend operator fun invoke(movieId: Int): MovieDetails {
        return repository.getMovieDetails(movieId)
    }
}