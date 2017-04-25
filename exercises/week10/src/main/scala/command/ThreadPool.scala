package command

import java.util.concurrent.BlockingQueue

import java.util.concurrent.LinkedBlockingQueue

class ThreadPool(n: Int) {

  private val jobQueue: BlockingQueue[Job] = new LinkedBlockingQueue()

  private val jobThreads = new Array[Thread](n)

  @volatile private var shutdown: Boolean = _

  for (i <- 0 until n) {
    jobThreads(i) = new Worker("Pool Thread " + i)
    jobThreads(i).start()
  }

  def addJob(r: Job): Unit = {
    try jobQueue.put(r)
    catch {
      case e: InterruptedException => Thread.currentThread().interrupt()
    }
  }

  def shutdownPool: Unit = {
    while (!jobQueue.isEmpty) 
    try {
        Thread.sleep(1000)
    } catch {
      case e: InterruptedException => e.printStackTrace()
    }
    shutdown = true
    for (workerThread <- jobThreads) {
      workerThread.interrupt()
    }
  }

  private class Worker(name: String) extends Thread(name) {

    override def run = {
      while (!shutdown) 
      try {
        val r: Job = jobQueue.take()
        println(name)
        r.run
      } catch {
        case e: InterruptedException => {}
      }
    }
  }
}
