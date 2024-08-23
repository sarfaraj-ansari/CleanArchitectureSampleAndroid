package com.example.kotlincleanarchitecture.core.data.repository

import com.example.kotlincleanarchitecture.core.domain.repository.CoreRepo
import kotlinx.coroutines.flow.Flow

class CoreRepoImpl: CoreRepo {
    override suspend fun getData(): Flow<Any> {
        TODO("Not yet implemented")
    }

}