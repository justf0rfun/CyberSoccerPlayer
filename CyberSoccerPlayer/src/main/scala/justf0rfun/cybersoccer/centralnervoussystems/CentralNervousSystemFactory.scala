package justf0rfun.cybersoccer.centralnervoussystems

trait CentralNervousSystemFactory {

  def createCentralNervousSystem(peripheralNervousSystem: PeripheralNervousSystem): CentralNervousSystem
  
}