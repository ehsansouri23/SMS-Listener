package com.example.domain

abstract class BaseUseCase<I, O> {

    abstract suspend fun run(input: I): O
}