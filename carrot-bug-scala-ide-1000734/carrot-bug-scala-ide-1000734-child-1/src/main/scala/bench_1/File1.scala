package bench_1
import bench_0.Klaz0
import com.weiglewilczek.slf4s.Logging

class Klaz1 extends Klaz0 {

  override def test {

    val some = null

  }

}

object Klaz1 extends Logging {

  def main(args: Array[String]) {

    logger.debug("init 1")

  }

}
