import java.io.{FileOutputStream, OutputStreamWriter, PrintWriter}

import StateMachine.{Event, State}

object StateMachineDescription {

  def describeAsDotFile(stateMachine: Map[State, Map[Event, State]], name: String): Unit = {
    val out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(s"$name.gv")))
    try {
      out.print(describeAsDot(stateMachine, name))
    } finally {
      out.close()
    }
  }

  def describeAsDot(stateMachine: Map[State, Map[Event, State]], name: String): String = {

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
}
