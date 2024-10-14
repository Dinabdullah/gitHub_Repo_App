package com.example.odcgithubrepoapp.presentation.screens.repo_issues_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.odcgithubrepoapp.R
import com.example.odcgithubrepoapp.presentation.common_component.AppBar
import com.example.odcgithubrepoapp.presentation.screens.repo_issues_screen.components.IssueItem
import com.example.odcgithubrepoapp.presentation.theme.ODCGithubRepoAppTheme

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RepoIssuessScreen(
//    modifier: Modifier = Modifier,
//    owner: String,
//    name: String,
//    onClickBack: () -> Unit,
//) {
//    val repoIssuesViewModel: RepoIssuesViewModel = hiltViewModel()
//
//    LaunchedEffect(Unit) {
//        repoIssuesViewModel.requestRepoDetails(ownerName = owner, name = name)
//    }
//
//    val repoIssuesUiState by repoIssuesViewModel.repoIssuesStateFlow.collectAsStateWithLifecycle()
//
//    Scaffold(modifier = modifier.fillMaxSize(),
//        topBar = {
//            AppBar(
//                onBackButtonClicked = onClickBack,
//                title = R.string.details_app_bar_title
//            )
//        }
//    ) { innerPadding ->
//
//        when (val result = repoIssuesUiState) {
//            is RepoDetailsUiState.InitialState -> {}
//
//            is RepoDetailsUiState.Loading -> {
//                if (result.isLoading)
//                    AnimateShimmerDetails(
//                        innerPadding = innerPadding
//                    )
//            }
//
//            is RepoIssuesUiState.RepoIssuesUiModelData -> {
//                IssueScreen(
//                    innerPadding = innerPadding,
//                    repoIssuesUiModel = result.repositoryIssues,
//
//                )
//            }
//            is RepoDetailsUiState.Error -> {
//                ErrorSection(
//                    innerPadding = innerPadding,
//                    customErrorExceptionUiModel = result.customErrorExceptionUiModel,
//                    onRefreshButtonClicked = {
//                        repoIssuesViewModel.requestRepoDetails(ownerName = owner, name = name)
//                    }
//                )
//            }
//        }
//    }
//}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepoIssuesScreen(
//    innerPadding: PaddingValues,
//    repoIssuesUiModel: RepoIssuesUiModel,
    navController:NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            AppBar(
                title = R.string.issues_app_bar_title,
                showBackButton = true,
                onBackButtonClicked = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
        ) {
            items(listOf("Repo1", "Repo2")) { issueItem ->
                IssueItem()
            }
        }
    }

}

@Preview
@Composable
private fun PreviewIssueScreen() {
    ODCGithubRepoAppTheme {
        RepoIssuesScreen(rememberNavController())
    }
}


