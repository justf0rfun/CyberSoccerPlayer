package justf0rfun.cybersoccer.centralnervoussystems
import justf0rfun.cybersoccer.model.Body
import justf0rfun.cybersoccer.model.Goal
import justf0rfun.cybersoccer.model.MatchState
import justf0rfun.cybersoccer.model.Move
import justf0rfun.cybersoccer.model.SoccerField
import justf0rfun.cybersoccer.model.Kick
import justf0rfun.cybersoccer.model.RefereeDecision

trait PeripheralNervousSystem {

  def matchState: MatchState
  def body: Body
  def move(move: Move)
  def kickBall(kick: Kick)
  def nextRefereeDecision: Option[RefereeDecision]

  //  def shout(message: Any): Unit = universe ! SoccerProtocol.Shouting(message)


}