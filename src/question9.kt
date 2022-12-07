private fun userfun(): String {
    try {
        try {
            error("body")
        } finally {
            return "inner"
        }
    }finally {
    }
    return "body"
}

fun main() {
    println(userfun())
}

/**
Должно быть `inner`

12%
ответы `body`

 */