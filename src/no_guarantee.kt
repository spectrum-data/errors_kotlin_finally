import java.io.Closeable
import kotlin.system.exitProcess

class CloseMe: Closeable {

    fun doWork() {
        println("Open Transaction")
        println("Do some work")
        // вы можете оказаться заложником
        // недоверенного внешнего API
        callSomeExternalApi()
    }
    override fun close() {
        // и эта штука не будет вызвана
        println("Finish Transaction")
    }
}
fun main(){
    CloseMe().use{ // даже USE никакой не спасет
        it.doWork()
    }
}

fun callSomeExternalApi() {
    // раньше мы тут кидали исключение но
    // это настолько все ужасно что надо просто завершать срочно программу
    // это признак хакерской атаки
    exitProcess(1)
}
