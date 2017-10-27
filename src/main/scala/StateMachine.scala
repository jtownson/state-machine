import StateMachine.{EventType, State, StateMachineDefinition, TransitionCondition}

object StateMachine {

  trait EventType

  trait State {
    def performEntryAction(): Unit = {}
  }

  type TransitionCondition = EventType => Boolean

  type StateMachineDefinition = Map[State, Map[Class[_ <: EventType], Set[(TransitionCondition, State)]]]
}

case class StateMachine(definition: StateMachineDefinition, state: State) {
  val allowableStates: Map[Class[_ <: EventType], Set[(TransitionCondition, State)]] = definition(state)

  def apply(event: EventType): StateMachine = {

    val transitionConditionApplies: ((TransitionCondition, State)) => Boolean =
      {case (condition, _) => condition.apply(event)}

    val (_, finalState) = allowableStates(event.getClass).find(transitionConditionApplies).getOrElse(???)

    StateMachine(definition, finalState)
  }
}
