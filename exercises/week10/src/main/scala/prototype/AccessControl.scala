package prototype

case class AccessControl(val controlLevel: String,
                    var access: String)
    extends Prototype {

  override def clone(): AccessControl = this.copy()
}