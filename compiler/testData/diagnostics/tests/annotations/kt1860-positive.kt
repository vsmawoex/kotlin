// !WITH_NEW_INFERENCE
@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
annotation class test

fun foo(@test <!UNUSED_PARAMETER!>f<!> : Int) {}

var bar : Int = 1
    set(@test v) {}

val x : (Int) -> Int = {@test <!OI;UNINITIALIZED_VARIABLE!><!TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!NI;UNINITIALIZED_VARIABLE!>x<!><!><!><!> <!SYNTAX!>: Int -> x<!>} // todo fix parser annotation on lambda parameter

class Hello(@test <!UNUSED_PARAMETER!>args<!>: Any) {
}
