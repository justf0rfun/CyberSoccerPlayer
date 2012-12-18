package justf0rfun.cybersoccer.centralnervoussystems
import scala.util.Random
import justf0rfun.mathematics.geometry.Point

class RandomCentralNervousSystem(peripheralNervousSystem: PeripheralNervousSystem) extends AbstractCentralNervousSystem(peripheralNervousSystem) {
  
  def think(): Unit = {
    moveTo(new Point(Random.nextDouble(), Random.nextDouble()))
  }
  
}