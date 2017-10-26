import StateMachine.{Event, State, StateMachineDefinition}

object DogStateMachineDefinition {

  case class New(dogName: String) extends Event
  case class SeesSquirrel(dogName: String) extends Event
  case class Waits(dogName: String) extends Event
  case class GetsPetted(dogName: String) extends Event


  case object Sitting extends State {
    override def performEntryAction(): Unit =
      println("Sitting down")
  }

  case object Barking extends State {
    override def performEntryAction(): Unit =
      println("Barking")
  }

  case object WaggingTail extends State {
    override def performEntryAction(): Unit =
      println("Wagging tail")
  }

  val dogStateTransitions: StateMachineDefinition = Map(

    Sitting -> Map(
      classOf[SeesSquirrel] -> Barking),

    Barking -> Map(
      classOf[GetsPetted] -> WaggingTail),

    WaggingTail -> Map(
      classOf[Waits] -> Barking,
      classOf[GetsPetted] -> Sitting
    )
  )

}
