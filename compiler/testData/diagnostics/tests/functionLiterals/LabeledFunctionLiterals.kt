// !WITH_NEW_INFERENCE
package h

//traits to make ambiguity with function literal as an argument
interface A
interface B
interface C: A, B

fun <T> foo(<!UNUSED_PARAMETER!>a<!>: A, f: () -> T): T = f()
fun <T> foo(<!UNUSED_PARAMETER!>b<!>: B, f: () -> T): T = f()

fun test(c: C) {
    <!OI;CANNOT_COMPLETE_RESOLVE!><!NI;OVERLOAD_RESOLUTION_AMBIGUITY!>foo<!><!>(c) f@ {
        c<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>
    }
}
