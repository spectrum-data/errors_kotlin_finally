import kotlin.system.exitProcess

fun main(){
    println("Open Transaction")
    try{
        println("Do some work")
        exitProcess(1)
    }finally{
        println("Finish Transaction")
    }
}