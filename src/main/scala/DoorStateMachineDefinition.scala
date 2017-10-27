import StateMachine.{EventType, State, StateMachineDefinition}

object DoorStateMachineDefinition {

  case class NewEvent() extends EventType

  case class OpenDoorEvent() extends EventType

  case class CloseDoorEvent() extends EventType

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
      classOf[NewEvent] -> Set((_ => true, ClosedState))),

    ClosedState -> Map(
      classOf[OpenDoorEvent] -> Set((_ => true, OpenState)),
      classOf[CloseDoorEvent] -> Set((_ => true, ClosedState))),

    OpenState -> Map(
      classOf[CloseDoorEvent] -> Set((_ => true, ClosedState)),
      classOf[OpenDoorEvent] -> Set((_ => true, OpenState)))
  )

}
