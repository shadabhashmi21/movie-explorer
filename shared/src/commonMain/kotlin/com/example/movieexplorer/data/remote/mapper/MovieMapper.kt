import com.example.movieexplorer.data.remote.dto.MovieDto
import com.example.movieexplorer.domain.model.Movie

fun MovieDto.toMovie(): Movie{
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath,
        backdropPath = backdropPath,
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}