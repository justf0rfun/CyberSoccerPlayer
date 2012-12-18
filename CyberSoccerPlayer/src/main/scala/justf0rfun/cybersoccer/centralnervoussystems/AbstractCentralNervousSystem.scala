package justf0rfun.cybersoccer.centralnervoussystems
import justf0rfun.cybersoccer.model.Ball
import justf0rfun.mathematics.geometry.linear.LineSegment
import justf0rfun.mathematics.geometry.circular.Circle
import justf0rfun.mathematics.geometry.Point

abstract class AbstractCentralNervousSystem(peripheralNervousSystem: PeripheralNervousSystem) extends CentralNervousSystem(peripheralNervousSystem) {

  protected def moveTo(targetPoint: Point) = {
    val movementVector = new LineSegment(peripheralNervousSystem.body.location, targetPoint)
    peripheralNervousSystem.move(1, movementVector.angle)
  }

  //Radius / Size of intercepted object is not taken into account!
  protected def intercept(ball: Ball) = {
//    moveTo(interceptionPoint(ball.location, ball.velocityX))
  }
  
  protected def interceptionPoint(currentTargetLocation: Point, movementAngle: Double, velocity: Double): Point = {
    val movementRangeCircle = new Circle(1, peripheralNervousSystem.body.location)
    val targetMovementVector = new LineSegment(currentTargetLocation, movementAngle, velocity)
    val intersectionPoints = movementRangeCircle.intersections(targetMovementVector.line)
    if (intersectionPoints._1.distance(currentTargetLocation) < intersectionPoints._2.distance(currentTargetLocation)) {
      intersectionPoints._1
    }
    intersectionPoints._2
  }

}