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
        // println("after return");
    } catch(e: Throwable) {
        println("in finally");
        throw e;
    }
}

fun withNoFinallyGolangStyle(callback: (Int)-> Int) : Int {
    fun defer() { println("in finally"); }
    try{
        println("before return");
        val ___result = callback(10);
        defer()
        return ___result
        //println("after return");
    } catch(e: Throwable) {
        defer()
        throw e;
    }
}

// Теперь понятно и с return из finally
fun someFun() : Int = 1


fun withFinallyReturn() : Int {
    try{
        return someFun();
    } finally {
        return 2;
    }
}

// это по факту

fun with_NO_FinallyReturn() : Int {
    try{
        someFun(); // ignore result  _ = someFun()
        return 2;
        //return ___result; // нет следов такого возврата
    } catch(_: Throwable) {
        return 2; //!!!  нет перевыброса исключения
    }
}

fun withNoFinally() : Int {
    return someFun();
    println(2) // удалится оптимизатором
}

fun withFinallyAction() : Int {
    try{
        return someFun();
    } finally {
        println(2)
    }
}

fun with_NO_FinallyAction() : Int {
    try{
        val ___result =  someFun();
        println(2)
        return ___result;
    } catch(e: Throwable) {
        println(2)
        throw e // а теперь уже все, исключение не потеряно
    }
}
