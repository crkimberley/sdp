package command

class EmailJob extends Job {

  private var email: Email = _

  def setEmail(email: Email): Unit = this.email = email

  override def run(): Unit = {
    println("executing email jobs.")
    email.sendEmail()
  }
}