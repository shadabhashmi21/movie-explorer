class GetTopRatedMoviesUseCase(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(page: Int): MoviePage {
        return repository.getTopRatedMovies(page)
    }
}