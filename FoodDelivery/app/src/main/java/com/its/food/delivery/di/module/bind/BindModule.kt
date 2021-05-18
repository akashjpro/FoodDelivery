package com.its.food.delivery.di.module.bind

import com.its.food.delivery.repository.Repo
import com.its.food.delivery.repository.RepoImp
import com.its.food.delivery.repository.local.LocalService
import com.its.food.delivery.repository.local.LocalServiceImp
import com.its.food.delivery.repository.setting.Setting
import com.its.food.delivery.repository.setting.SettingImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
abstract class BindModule {

    @Singleton
    @Binds
    abstract fun bindRepo(impl: RepoImp): Repo

    @Binds
    abstract fun bindLocalService(impl: LocalServiceImp): LocalService

    @Singleton
    @Binds
    abstract fun bindSetting(impl: SettingImp): Setting

}