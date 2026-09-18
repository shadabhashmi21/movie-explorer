interface MovieRepository {
    suspend fun getTopRatedMovies(page: Int): MoviePage
}