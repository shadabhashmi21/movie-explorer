import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)

    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private var currentPage = 1
    private var totalPage = 1
    private var isLoading = false

    init {
        loadMovies()
    }

    private fun loadMovies(){
        if(isLoading) return

        isLoading = true

        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading

            try {
                val result = getTopRatedMoviesUseCase(
                    page = currentPage
                )

                totalPage = result.totalPages

                _uiState.value = HomeUiState.Success(
                    movies = result.movies,
                    hasMore = currentPage < totalPage
                )
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error(
                    message = e.message ?: "Something went wrong"
                )
            }finally {
                isLoading = false
            }
        }
    }

    fun loadNextPage() {
        if(isLoading) return
        if(currentPage >= totalPage) return

        currentPage++

        viewModelScope.launch {
            isLoading = true

            _uiState.update { state ->
                if(state is HomeUiState.Success){
                    state.copy(isLoadingMore = true)
                }else{
                    state
                }
            }

            try{
                val result = getTopRatedMoviesUseCase(
                    page = currentPage
                )

                totalPage = result.totalPages

                val currentMovies = (_uiState.value as? HomeUiState.Success)
                    ?.movies
                    ?: emptyList()

                _uiState.value = HomeUiState.Success(
                    movies = currentMovies + result.movies,
                    hasMore = currentPage < totalPage,
                    isLoadingMore = false
                )
            }catch (_: Exception){
                currentPage--

                _uiState.update { state ->
                    if(state is HomeUiState.Success){
                        state.copy(isLoadingMore = false)
                    }else{
                        state
                    }
                }
            }finally {
                isLoading = false
            }
        }
    }

    fun retry() {
        currentPage = 1
        totalPage = 1

        loadMovies()
    }
}