// !WITH_NEW_INFERENCE
// !DIAGNOSTICS: -UNUSED_PARAMETER

fun <T, R> apply(x: T, f: (T) -> R): R = f(x)

fun foo(i: Int) {}
fun foo(s: String) {}

val x1 = apply(1, ::foo)
val x2 = apply("hello", ::foo)
val <!NI;IMPLICIT_NOTHING_PROPERTY_TYPE!>x3<!> = <!OI;TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>apply<!>(true, ::<!OI;NONE_APPLICABLE!><!NI;DEBUG_INFO_MISSING_UNRESOLVED!>foo<!><!>)