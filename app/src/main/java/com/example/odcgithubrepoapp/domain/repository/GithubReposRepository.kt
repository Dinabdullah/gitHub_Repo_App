package com.example.odcgithubrepoapp.domain.repository

import com.example.odcgithubrepoapp.domain.model.GithubReposDomainModel
import com.example.odcgithubrepoapp.domain.model.RepoDetailsDomainModel

interface GithubReposRepository {
    suspend fun fetchReposList(): List<GithubReposDomainModel>
    suspend fun fetchRepoDetails(ownerName: String, name: String): RepoDetailsDomainModel
}