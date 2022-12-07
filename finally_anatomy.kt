fun withFinally(callback: (Int)-> Int) : Int {
    try{
        println("before return");
        return callback(10);
        println("after return");
    } finally {
        println("in finally");
    }
}
fun main() {
    val result = withFinally{ it ->
        println("main");
        it * 10
    }
    println(result)
}

//before return
//main            - неверно предполагать перестановку вызова
//in finally
//100

// ЭКВИВАЛЕНТ:
fun withNoFinallyJavaStyle(callback: (Int)-> Int) : Int {
    try{
        println("before return");
        val ___result = callback(10);
        println("in finally");
        return ___result
        println("after return");
    } catch(e: Throwable) {
        println("in finally");
        throw e;
    }
}

fun withNoFinallyGolangStyle(callback: (Int)-> Int) : Int {
    fun defer() { println("in finally") }
    try{
        println("before return");
        val ___result = callback(10);
        defer()
        return ___result
        println("after return");
    } catch(e: Throwable) {
        defer()
        throw e;
    }
}

// Теперь понятно и с return из finally

fun withFinallyReturn() : Int {
    try{
        return 1;
    } finally {
        return 2;
    }
}

// это по факту

fun with_NO_FinallyReturn() : Int {
    try{
        val ___result =  return 1;
        return 2;
        return ___result;
    } catch(_: Throwable) {
        return 2; //!!!  no rethrow!!!
    }
}

fun withFinallyAction() : Int {
    try{
        return 1;
    } finally {
        println(2)
    }
}

fun with_NO_FinallyAction() : Int {
    try{
         val ___result =  return 1;
        println(2)
        return ___result;
    } catch(e: Throwable) {
        println(2)
        throw e // а теперь уже все, исключение не потеряно
    }
}