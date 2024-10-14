package com.example.odcgithubrepoapp.data.data_sources.remote

import com.example.odcgithubrepoapp.data.data_sources.remote.retrofit.api.RepoDetailsApi
import com.example.odcgithubrepoapp.data.data_sources.remote.retrofit.api.RepositoriesListApi
import com.example.odcgithubrepoapp.data.data_sources.remote.retrofit.data_model.repo_details.RepoDetailsDataModel
import com.example.odcgithubrepoapp.data.data_sources.remote.retrofit.data_model.repo_list.GithubReposDataModel
import com.example.odcgithubrepoapp.data.mapper.toCustomRemoteExceptionDomainModel
import javax.inject.Inject

class GithubRemoteDataSource @Inject constructor(
    private val repositoryListApi: RepositoriesListApi,
    private val repositoryDetailsApi: RepoDetailsApi
) {

   suspend fun fetchRepositoriesList(): GithubReposDataModel {
       try {
           return repositoryListApi.fetchRepositoriesList().body() as GithubReposDataModel
       } catch (e: Exception) {
           throw e.toCustomRemoteExceptionDomainModel()
       }
    }

    suspend fun fetchRepoDetails(ownerName: String, name: String): RepoDetailsDataModel {
        try {
             return repositoryDetailsApi.fetchRepoDetails(ownerName, name).body() as RepoDetailsDataModel
        } catch (e: Exception) {
            // Convert and rethrow the exception as a custom remote exception
            throw e.toCustomRemoteExceptionDomainModel()
        }
    }
}