import kotlin.system.exitProcess


private fun userfun(): String {
    var wasCatch: Boolean = false
    try {
        error("it's error")
    } catch (e: Throwable) {
        wasCatch = true
        return "catch"
    } finally {
        if (!wasCatch) {
            exitProcess(-1)
        }
        return "finally"
    }
    return "after try"
}

fun main() {
    val result = userfun()
    println(result)
}


/*  Должно `finally`

25% человек ответили неправильн:

1. `catch`
2. `finally;after try`
3. `after try`

*/