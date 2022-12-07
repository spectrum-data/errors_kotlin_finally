private fun userfun(): String {
    try {
        try {
            error("body")
        } finally {
            return "inner"
        }
    }finally {
        return "outer"
    }
}

fun main() {
    println(userfun())
}

/**
Должно быть `outer`

16%

1. `inner`
2. один ответ `завалится`
 */