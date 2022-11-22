package tech.antee.products.common.utils.coroutines.ktx

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun launchSecurely(
    scope: CoroutineScope,
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    onLoading: ((Boolean) -> Unit)? = null,
    onError: ((Throwable) -> Unit)? = null,
    onFinally: (() -> Unit)? = null,
    block: suspend CoroutineScope.() -> Unit
): Job = scope.launch(context, start) {
    try {
        onLoading?.invoke(true)
        block()
    } catch (e: Throwable) {
        if (e is CancellationException) throw e
        e.printStackTrace()
        onError?.invoke(e)
    } finally {
        onLoading?.invoke(false)
        onFinally?.invoke()
    }
}
