package singleton

import java.io.ObjectStreamException
import java.io.Serializable

// TRANSLATION OF JAVA CODE BELOW USING INTELLIJ

@SerialVersionUID(-1093810940935189395L)
object SingletonProtected {
  private val sc = new SingletonProtected

  @throws[ClassNotFoundException]
  private def getClass(classname: String) = {
    var classLoader = Thread.currentThread.getContextClassLoader
    if (classLoader == null) classLoader = classOf[SingletonProtected].getClassLoader
    classLoader.loadClass(classname)
  }

  def getInstance: SingletonProtected = sc
}

@SerialVersionUID(-1093810940935189395L)
class SingletonProtected private() extends Serializable {
  if (SingletonProtected.sc != null) throw new IllegalStateException("Already created.")

  @throws[ObjectStreamException]
  private def readResolve = SingletonProtected.sc

  @throws[ObjectStreamException]
  private def writeReplace = SingletonProtected.sc

  @throws[CloneNotSupportedException]
  override def clone = throw new CloneNotSupportedException("Singleton, cannot be cloned")
}

/*
ORIGINAL JAVA CODE FROM KEITH'S REPO

package singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingletonProtected implements Serializable {
    private static final long serialVersionUID = -1093810940935189395L;
    private static SingletonProtected sc = new SingletonProtected();

    private SingletonProtected() {
        if (sc != null) {
            throw new IllegalStateException("Already created.");
        }
    }

    private static Class getClass(String classname) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null)
            classLoader = SingletonProtected.class.getClassLoader();
        return (classLoader.loadClass(classname));


    }

    public static SingletonProtected getInstance() {
        return sc;
    }

    private Object readResolve() throws ObjectStreamException {
        return sc;
    }

    private Object writeReplace() throws ObjectStreamException {
        return sc;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton, cannot be cloned");
    }

}
 */