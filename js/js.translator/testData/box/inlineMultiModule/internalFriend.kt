// EXPECTED_REACHABLE_NODES: 1110
// MODULE: lib
// FILE: lib.kt
internal fun bar() = "OK"

internal inline fun foo() = bar()

// MODULE: main(lib)(lib)
// FILE: main.kt
fun box(): String = foo()