import StateMachine.{EventType, State, StateMachineDefinition}

object DogStateMachineDefinition {

  case class SeesSquirrel(colour: String) extends EventType
  case class Waits() extends EventType
  case class GetsPetted() extends EventType


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

  def not[T](predicate: T => Boolean): T => Boolean = !predicate(_)

  val isGreySqirrel: EventType => Boolean = {
    case SeesSquirrel(colour) => "grey" == colour
  }

  val dogStateTransitions: StateMachineDefinition = Map(

    Sitting -> Map(
      classOf[SeesSquirrel] -> Set((isGreySqirrel, Barking), (not(isGreySqirrel), Sitting))),

    Barking -> Map(
      classOf[GetsPetted] -> Set((_ => true, WaggingTail))),

    WaggingTail -> Map(
      classOf[Waits] -> Set((_ => true, Barking)),
      classOf[GetsPetted] -> Set((_ => true, Sitting)))
  )

}
