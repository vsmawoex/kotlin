// !WITH_NEW_INFERENCE
// JET-81 Assertion fails when processing self-referring anonymous objects

class Test {
  private val y = object {
    val a = <!OI;UNINITIALIZED_VARIABLE!><!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!><!NI;DEBUG_INFO_MISSING_UNRESOLVED!>y<!><!><!>;
  }

  val z = y.<!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>a<!>;

}

object A {
  val x = A
}

class Test2 {
  private val a = object {
    init {
      <!UNINITIALIZED_VARIABLE!><!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>b<!><!> <!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>+<!> 1
    }
    val x = <!UNINITIALIZED_VARIABLE!><!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>b<!><!>
    val y = 1
  }

  val b = <!NI;TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!><!OI;TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!><!NI;DEBUG_INFO_MISSING_UNRESOLVED!>a<!><!>.<!OI;DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!><!NI;DEBUG_INFO_MISSING_UNRESOLVED!>x<!><!><!>
  val c = a.y
}