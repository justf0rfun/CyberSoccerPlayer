package justf0rfun.cybersoccer.centralnervoussystems
import justf0rfun.cybersoccer.model.RefereeDecision
import justf0rfun.mathematics.geometry.linear.Vector
import justf0rfun.cybersoccer.model.Team
import justf0rfun.mathematics.geometry.Point

abstract class StructuredCentralNervousSystem(peripheralNervousSystem: PeripheralNervousSystem) extends CentralNervousSystem(peripheralNervousSystem) {

	protected var lastRefereeDecision: Option[RefereeDecision] = None

	override def think() = {
		peripheralNervousSystem.nextRefereeDecision match {
			case Some(decision) => lastRefereeDecision = Some(decision)
			case None =>
		}
		if (peripheralNervousSystem.matchState.ball.move.vector != Vector.zeroVector) {
			lastRefereeDecision = None
		}
		lastRefereeDecision match {
			case Some(RefereeDecision.KickOff(team)) => kickOff(team)
			case Some(RefereeDecision.Goal(team)) => {
				goal(team)
				kickOff(peripheralNervousSystem.matchState.oponent(team))
			}
			case Some(RefereeDecision.ThrowIn(team, throwInPoint)) => throwIn(team, throwInPoint)
			case Some(RefereeDecision.CornerKick(team, point)) => cornerKick(team, point)
			case Some(RefereeDecision.FreeKick(team, point)) => freeKick(team, point)
			case Some(RefereeDecision.Penalty(team)) => penalty(team)
			case Some(RefereeDecision.GoalKick(team)) => goalKick(team)
			case Some(RefereeDecision.Finish(winner)) => finish(winner)
			case _ => play
		}
	}

	def kickOff(team: Team): Unit
	def goal(team: Team): Unit
	def throwIn(team: Team, throwInPoint: Point): Unit
	def cornerKick(team: Team, point: Point): Unit
	def freeKick(team: Team, point: Point): Unit
	def penalty(team: Team): Unit
	def goalKick(team: Team): Unit
	def finish(winner: Option[Team]): Unit
	def play: Unit

}