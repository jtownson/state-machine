
import org.scalatest.FlatSpec
import java.io.{FileOutputStream, OutputStreamWriter, PrintWriter}
import StateMachines._

class StateMachineGraphVizSpec extends FlatSpec {

//  private def stateNode(state: State): String =
//    s"""$state [label = "$state"];"""
//
//  private def edge(initialState: State, event: Event, endState: State): String =
//    s"""$initialState -> $endState [label="$event", fontsize="10"];"""

  "StateMachine" should "be described as a dot file" in {
//    val out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("state-machine.gv")))
//    out.println("digraph StateMachineName {")
//    out.println("node [shape = box, color = grey, fillcolor = \"#A0A0FF\", style = filled];")
//
//    doorStateTransitions.keys.foreach(state => out.println(stateNode(state)))
//
//    for ((initialState,eventTable) <- doorStateTransitions) {
//      for ((event, endState) <- eventTable) {
//        out.println(edge(initialState, event, endState))
//      }
//    }
//
//    out.println("}")
//    out.close()
  }
}

