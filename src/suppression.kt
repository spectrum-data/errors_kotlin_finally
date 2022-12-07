import java.io.Closeable

class BadSomeCloseable() : Closeable {
    fun dowork() {
        error("Work")
    }
    override fun close() {
        println("Close called")
        error("Closed")
    }
}

fun main() {

    val resource = BadSomeCloseable()

    runCatching { resource.use {
        it.dowork()
    }}.exceptionOrNull()!!.also {
        println("Error:${it.message}, Suppress: ${it.suppressed[0].message}")
    }

    println(
        runCatching {
            try {
                resource.dowork()
            } finally {
                resource.close()
            }
        }.exceptionOrNull()!!.suppressed.size
    )
}
