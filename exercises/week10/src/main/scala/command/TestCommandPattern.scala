package command

object TestCommandPattern extends App {
    val pool = new ThreadPool(10)
    var email: Email = null
    val emailJob = new EmailJob
    var sms: Sms = null
    val smsJob = new SmsJob
    var fileIO: FileIO = null
    val fileIOJob = new FileIOJob()
    var logging: Logging = null

    val logJob = new LoggingJob()

    for (i <- 0.until(5)) {
      email = new Email
      emailJob.setEmail(email)
      sms = new Sms
      smsJob.setSms(sms)
      fileIO = new FileIO
      fileIOJob.setFileIO(fileIO)
      logging = new Logging
      logJob.setLogging(logging)
      pool.addJob(emailJob)
      pool.addJob(smsJob)
      pool.addJob(fileIOJob)
      pool.addJob(logJob)
    }
    pool.shutdownPool
}
