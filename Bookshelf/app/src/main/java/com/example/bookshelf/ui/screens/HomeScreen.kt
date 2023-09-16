import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookshelf.ui.screens.BooksGridScreen
import com.example.bookshelf.ui.screens.ErrorScreen
import com.example.bookshelf.ui.screens.LoadingScreen

@Composable
fun HomeScreen(
    booksUiState: BooksUiState,
    retryAction: () -> Unit,
    modifier: Modifier
) {
    when (booksUiState) {
        is BooksUiState.Loading -> LoadingScreen(modifier)
        is BooksUiState.Success -> BooksGridScreen(
            books = booksUiState.bookSearch,
            modifier = modifier
        )
        is BooksUiState.Error -> ErrorScreen(retryAction = retryAction, modifier)
        else -> ErrorScreen(retryAction = retryAction, modifier)
    }
}