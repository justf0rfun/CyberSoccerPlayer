package justf0rfun.cybersoccer.centralnervoussystems

abstract class CentralNervousSystem(protected val peripheralNervousSystem: PeripheralNervousSystem) {
  
  def think(): Unit
  
}