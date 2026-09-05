import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)

    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadMovies()
    }

    private fun loadMovies(){
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading

            try {
                val movies = getTopRatedMoviesUseCase()

                _uiState.value = HomeUiState.Success(
                    movies = movies
                )
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error(
                    message = e.message ?: "Something went wrong"
                )
            }
        }
    }

    fun retry() {
        loadMovies()
    }
}