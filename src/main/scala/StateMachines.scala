import java.io.{FileOutputStream, OutputStreamWriter, PrintWriter}

object StateMachines {

  trait Event

  trait State {
    def performEntryAction(): Unit = {}
  }

  // TODO get working then look at StateMachine = Map[Event, State] i.e. a partially applied lookup with current
  // state applied
  def transition(stateMachine: Map[State, Map[Event, State]], currentState: State, event: Event): State =
    stateMachine(currentState)(event)

  def describe(stateMachine: Map[State, Map[Event, State]], name: String): String = {

    def stateNode(state: State): String =
      s"""$state [label = "$state"];\n"""

    def edge(initialState: State, event: Event, endState: State): String =
      s"""$initialState -> $endState [label="$event", fontsize="10"];\n"""


    val out = new StringBuilder
    out.append(s"digraph $name {\n")
    out.append("node [shape = box, color = grey, fillcolor = \"#A0A0FF\", style = filled];\n")

    stateMachine.keys.foreach(state => out.append(stateNode(state)))

    for ((initialState,eventTable) <- stateMachine) {
      for ((event, endState) <- eventTable) {
        out.append(edge(initialState, event, endState))
      }
    }

    out.append("}\n")
    out.toString()
  }

  def write(stateMachine: Map[State, Map[Event, State]], name: String): Unit = {
    val out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(s"$name.gv")))
    try {
      out.print(describe(stateMachine, name))
    } finally {
      out.close()
    }
  }
}
