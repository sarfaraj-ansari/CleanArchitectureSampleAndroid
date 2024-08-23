package com.example.kotlincleanarchitecture.core.domain.repository

import kotlinx.coroutines.flow.Flow


interface CoreRepo {
    suspend fun getData(): Flow<Any>
}