State machines as nested Maps (state -> event -> state)
=======================================================

This is an attempt to address
1. Tomas's point that _it should be possible to understand the state machine
_in a single place_ without having to navigate and piece together the behaviour.
2. self-documenting states.

The solution is just to use a nested map. This is really simple and provides
quite nice semantics. It is also very easy to iterate over the map and generate
and _dot_ representation, which graphviz will then render as png using
```bash
dot -Tpng states.gv -o states.png
```