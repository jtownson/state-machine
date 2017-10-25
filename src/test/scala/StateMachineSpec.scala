import org.scalatest.FlatSpec

import org.scalatest.Matchers._

import DoorStateMachine._

class StateMachineSpec extends FlatSpec {

  "State machine" should "provide next state" in {
    doorStateTransitions(Start)(New) shouldBe ClosedState
    doorStateTransitions(ClosedState)(OpenDoorEvent) shouldBe OpenState
    doorStateTransitions(OpenState)(CloseDoorEvent) shouldBe ClosedState
  }

  it should "provide actions upon transition" in {
    doorStateTransitions(Start)(New).performEntryAction()
    doorStateTransitions(ClosedState)(OpenDoorEvent).performEntryAction()
    doorStateTransitions(OpenState)(CloseDoorEvent).performEntryAction()
  }

  it should "document itself" in {
    StateMachines.write(doorStateTransitions, "Doors")
  }
}
