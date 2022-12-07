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
    }
    return "after try"
}

fun main() {
    val result = userfun()
    println(result)
}


/*  должно быть `catch`

16%

1. `after try`
2. `ничего, завалится`

*/