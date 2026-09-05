import com.example.movieexplorer.domain.model.Movie

sealed interface HomeUiState {
    data object Loading: HomeUiState

    data class Success(val movies: List<Movie>): HomeUiState

    data class Error(val message: String): HomeUiState
}