package com.example.data.util


fun interface Mapper<F, T> {
    suspend fun map(from: F): T
}

fun interface IndexedMapper<F, T> {
    suspend fun map(index: Int, from: F): T
}

internal fun <F, T1, T2> pairMapperOf(
    firstMapper: Mapper<F, T1>,
    secondMapper: IndexedMapper<F, T2>
): suspend (List<F>) -> List<Pair<T1, T2>> = { from ->
    from.mapIndexed { index, value ->
        firstMapper.map(value) to secondMapper.map(index, value)
    }
}