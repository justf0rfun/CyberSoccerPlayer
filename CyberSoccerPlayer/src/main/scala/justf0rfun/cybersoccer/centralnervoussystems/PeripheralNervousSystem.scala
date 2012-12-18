package justf0rfun.cybersoccer.centralnervoussystems
import justf0rfun.cybersoccer.model.SoccerField
import justf0rfun.cybersoccer.model.MatchState
import justf0rfun.cybersoccer.model.Goal
import justf0rfun.cybersoccer.model.Body

trait PeripheralNervousSystem {

  def matchState: MatchState
  def body: Body
  def targetGoal: Goal
  def field: SoccerField
  def move(velocity: Double, angle: Double)

  //  def shout(message: Any): Unit = universe ! SoccerProtocol.Shouting(message)


}