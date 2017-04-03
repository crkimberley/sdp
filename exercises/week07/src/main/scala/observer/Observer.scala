package observer

trait Observer {
  def update(desc: String)

  def subscribe()

  def unSubscribe()
}
