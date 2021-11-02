package id.nadiar.kotlin
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlin.system.measureTimeMillis

class App {
}

fun main() {
    myChannel()
    runningJob()
    runMyBlocking()
    val time1 = measureTimeMillis { calculateCapital() }
    val time2 = measureTimeMillis { calculateCapital2() }
    println("Completed in time1: $time1 vs time2: $time2")
}

fun runMyBlocking() {
    runBlocking {
        launch {
            delay(1000L)
            println("Coroutines!")
        }
        println("Hello")
        delay(1000L)
    }
}

fun calculateCapital() {
    runBlocking {
        val capital = getCapital()
        val income = getIncome()
        println("Your profit is ${income - capital}")
    }
}

fun calculateCapital2() {
    runBlocking {
        val capital = async { getCapital() }
        val income = async { getIncome() }
        println("Your profit is ${income.await() - capital.await()}")
    }
}

suspend fun getCapital(): Int {
    delay(1000L)
    return 50_000
}

suspend fun getIncome(): Int {
    delay(1000L)
    return 75_000
}

// Job

fun runningJob() {
    runBlocking {
        val job = launch {
            delay(5000)
            println("A new job")
        }

        delay(2000)
        job.cancel()
        println("Canceling job")
        if (job.isCancelled) {
            println("Job is canceled")
        }
    }
}

// Channel

fun myChannel() {
    runBlocking(CoroutineName("main")) {
        val channel = Channel<Int>()
        launch(CoroutineName("v1coroutine")) {
            println("Sending from ${Thread.currentThread().name}")
            for (x in 1..5) channel.send(x * x)
        }

        repeat(5) {
            println(channel.receive())
        }
        println("received in ${Thread.currentThread().name}")
    }
}

