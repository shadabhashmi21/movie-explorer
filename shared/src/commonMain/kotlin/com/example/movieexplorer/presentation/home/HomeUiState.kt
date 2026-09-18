import com.example.movieexplorer.domain.model.Movie

sealed interface HomeUiState {
    data object Loading : HomeUiState

    data class Success(
        val movies: List<Movie>,
        val isLoadingMore: Boolean = false,
        val hasMore: Boolean = true
    ) : HomeUiState

    data class Error(val message: String) : HomeUiState
}