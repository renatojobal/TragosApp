package com.renatojobal.tragosapp.di

import com.renatojobal.tragosapp.data.DataSourceImpl
import com.renatojobal.tragosapp.domain.DataSource
import com.renatojobal.tragosapp.domain.Repo
import com.renatojobal.tragosapp.domain.RepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ActivityModule {

    @Binds
    abstract fun bindRepoImpl(repoImpl: RepoImpl): Repo

    @Binds
    abstract fun bindDatasourceImpl(dataSourceImpl: DataSourceImpl) : DataSource



}