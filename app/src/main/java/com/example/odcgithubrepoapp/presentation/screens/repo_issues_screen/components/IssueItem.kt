package com.example.odcgithubrepoapp.presentation.screens.repo_issues_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.odcgithubrepoapp.R

@Composable
fun IssueItem() {
    val imageCrossFadeAnimationDuration = 1000
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.medium
            )
            .clickable {

            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_issues),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 12.dp, start = 12.dp)
                .size(50.dp)
                .clip(CircleShape)
        )

        Column(
            Modifier.padding(12.dp)
        ) {
            Row {
                Text(text = "Francais", modifier = Modifier.weight(1f))
                Text(text = "Open")
            }

            Text("None", color = MaterialTheme.colorScheme.onSurface)
            Row(modifier = Modifier.padding(top = 8.dp)) {
                Text(text = "Created At:")
                Text(text = "2023-11-9 , 9:38 AM")
            }
        }

    }
}

@Preview
@Composable
private fun PreviewRepoItem() {
    //  ODCGithubRepoAppTheme {
    IssueItem()
    // }
}