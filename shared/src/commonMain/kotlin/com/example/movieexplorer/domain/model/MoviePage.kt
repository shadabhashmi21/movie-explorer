import com.example.movieexplorer.domain.model.Movie

data class MoviePage(
    val movies: List<Movie>,
    val page: Int,
    val totalPages: Int
)