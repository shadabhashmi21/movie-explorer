import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val getMovieDetailsUseCase: GetMovieDetailsUseCase) :
    ViewModel() {
    private val _uiState = MutableStateFlow<MovieDetailsUiState>(MovieDetailsUiState.Loading)

    val uiState: StateFlow<MovieDetailsUiState> = _uiState.asStateFlow()

    fun loadMovieDetails(movieId: Int){
        viewModelScope.launch {
            _uiState.value = MovieDetailsUiState.Loading

            try {
                val movie = getMovieDetailsUseCase(movieId)

                _uiState.value = MovieDetailsUiState.Success(
                    movie = movie
                )
            }catch (e: Exception){
                _uiState.value = MovieDetailsUiState.Error(
                    message = e.message ?: "Something went wrong"
                )
            }
        }
    }
}