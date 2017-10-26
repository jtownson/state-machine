import DogStateMachineDefinition.New
import StateMachine.{Event, State, StateMachineDefinition}

object DoorStateMachineDefinition {

  case class New() extends Event
  case class OpenDoorEvent() extends Event
  case class CloseDoorEvent() extends Event

  case object Start extends State

  case object OpenState extends State {
    override def performEntryAction(): Unit =
      println("Opening the door")
  }

  case object ClosedState extends State {
    override def performEntryAction(): Unit =
      println("Closing the door")
  }

  val doorStateTransitions: StateMachineDefinition = Map(

    Start -> Map(
      classOf[New] -> ClosedState),

    ClosedState -> Map(
      classOf[OpenDoorEvent] -> OpenState,
      classOf[CloseDoorEvent] -> ClosedState),

    OpenState -> Map(
      classOf[CloseDoorEvent] -> ClosedState,
      classOf[OpenDoorEvent] -> OpenState
    )
  )

}
