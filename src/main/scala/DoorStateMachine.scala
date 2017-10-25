import StateMachines.{Event, State}

object DoorStateMachine {

  case object New extends Event
  case object OpenDoorEvent extends Event
  case object CloseDoorEvent extends Event

  case object Start extends State

  case object OpenState extends State {
    override def performEntryAction(): Unit =
      println("Opening the door")
  }

  case object ClosedState extends State {
    override def performEntryAction(): Unit =
      println("Closing the door")
  }

  val doorStateTransitions: Map[State, Map[Event, State]] = Map(

    Start -> Map(
      New -> ClosedState),

    ClosedState -> Map(
      OpenDoorEvent -> OpenState),

    OpenState -> Map(
      CloseDoorEvent -> ClosedState
    )
  )

}
