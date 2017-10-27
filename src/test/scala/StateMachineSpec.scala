import org.scalatest.FlatSpec
import org.scalatest.Matchers._

import DoorStateMachineDefinition._
import DogStateMachineDefinition._

class StateMachineSpec extends FlatSpec {

  "State machine" should "support door states" in {

    val s0 = StateMachine(doorStateTransitions, Start)
    val s1 = s0.apply(NewEvent())
    val s2 = s1.apply(OpenDoorEvent())

    s0.state shouldBe Start
    s1.state shouldBe ClosedState
    s2.state shouldBe OpenState
  }

  it should "chain a series of events" in {

    StateMachine(doorStateTransitions, Start).apply(NewEvent()).apply(OpenDoorEvent()).state shouldBe OpenState
  }

  it should "provide actions upon transition" in {

    val s0 = StateMachine(dogStateTransitions, Sitting)

    val s1 = s0.apply(SeesSquirrel("red"))
    val s2 = s0.apply(SeesSquirrel("grey"))

    s1.state shouldBe Sitting
    s2.state shouldBe Barking
  }
}
