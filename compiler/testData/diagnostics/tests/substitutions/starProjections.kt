// !WITH_NEW_INFERENCE
// !CHECK_TYPE

interface A<R, T: A<R, T>> {
    fun r(): R
    fun t(): T
}

fun testA(a: A<*, *>) {
    a.r().checkType { _<Any?>() }
    a.t().checkType { _<A<*, *>>() }
}

interface B<R, T: B<List<R>, <!UPPER_BOUND_VIOLATED!>T<!>>> {
    fun r(): R
    fun t(): T
}

fun testB(b: B<*, *>) {
    <!OI;TYPE_MISMATCH(B<out Any?, out B<List<*>, *>>; B<*, *>)!>b<!>.r().checkType { _<Any?>() }
    <!OI;TYPE_MISMATCH(B<out Any?, out B<List<*>, *>>; B<*, *>)!>b<!>.t().checkType { <!NI;UNRESOLVED_REFERENCE_WRONG_RECEIVER!><!NI;DEBUG_INFO_UNRESOLVED_WITH_TARGET!>_<!><!><B<List<*>, *>>() }

    <!OI;TYPE_MISMATCH(B<List<Any?>, out B<List<*>, *>>; B<List<*>, *>)!><!OI;TYPE_MISMATCH(B<out Any?, out B<List<*>, *>>; B<*, *>)!>b<!>.t()<!>.r().size
}

