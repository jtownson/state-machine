import StateMachine.{Event, State, StateMachineDefinition}

object StateMachine {

  trait Event

  trait State {
    def performEntryAction(): Unit = {}
  }

  type StateMachineDefinition = Map[State, Map[Class[_ <: Event], State]]
}

case class StateMachine(definition: StateMachineDefinition, state: State) {
  val stateMachine: Map[Class[_ <: Event], State] = definition(state)

  // Since state machine definitions are immutable maps,
  // state transitions look like the application of ordinary functions
  // so it's very pretty.
  def apply(event: Event): StateMachine =
    StateMachine(definition, stateMachine(event.getClass))
}
