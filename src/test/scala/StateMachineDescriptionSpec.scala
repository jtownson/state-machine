import DoorStateMachineDefinition.doorStateTransitions
import DogStateMachineDefinition.dogStateTransitions
import org.scalatest.FlatSpec

class StateMachineDescriptionSpec extends FlatSpec {

  "StateMachineDescription" should "write a dot file" in {
    StateMachineDescription.describeAsDotFile(doorStateTransitions, "Doors")
    StateMachineDescription.describeAsDotFile(dogStateTransitions, "Dogs")
  }
}
