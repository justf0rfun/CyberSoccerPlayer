package justf0rfun.cybersoccer.centralnervoussystems

abstract class CentralNervousSystem(private val peripheralNervousSystem: PeripheralNervousSystem) {
  
  def think(): Unit
  
}