import DogStateMachineDefinition._

import org.scalatest.Matchers._
import org.scalatest.FlatSpec

class MultiStateMachineSpec extends FlatSpec {

  "State machine" should "handle events with data" in {
    val s0 = StateMachine(dogStateTransitions, Sitting)

    val s1 = s0.apply(SeesSquirrel("grey"))
    val s2 = s1.apply(GetsPetted())
    val s3 = s2.apply(GetsPetted())

    s0.state shouldBe Sitting
    s1.state shouldBe Barking
    s2.state shouldBe WaggingTail
    s3.state shouldBe Sitting
  }
}
