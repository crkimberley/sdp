package command

class LoggingJob extends Job {

  private var logging: Logging = _

  def setLogging(logging: Logging): Unit = this.logging = logging

  override def run(): Unit = {
    println("executing logging jobs.")
    logging.log
  }
}