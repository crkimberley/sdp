package functions

import org.scalatest.FunSuite
import functions.Funcs._
import support.TreeTraversals

class FunctionsTestSuite extends FunSuite {
    // Basics
    test("Tail removes the first element") {
        assert(tail(List(1,2,3,4)) == List(2,3,4))
    }

    test("setHead changes the first element of the list") {
        assert(setHead(List("A", "B", "C"), "0") == List("0", "B", "C"))
    }

    test("drop removes N elements from the front of the list") {
        assert(drop(List(1,2,3), 2) == List(3))
    }

    test("init removes the last element") {
        assert(init(List("A","B","C","D")) == List("A","B","C"))
    }

    // Folding
    test("foldLeft computes the correct value") {
        assert(foldLeft(List("H","e","l","l","o"), "")(_ + _) == "Hello")
    }

    test("sum produces the correct sum") {
        assert(sum(List(1.0,2.0,3.0,-3.0,-2.0,-1.0)) == 0.0)
    }

    test("product produces the correct product") {
        assert(product(List(1.0,2.0,3.0,4.0,5.0)) == 120.0)
    }

    test("length calculates the length") {
        assert(length("Hello".toList) == 5)
    }

    test("reverse reverses the list") {
        assert(reverse("Hello".toList) == "olleH".toList)
    }

    test("flatten flattens the nested list") {
        assert(flatten(List(List(1,2,3),List(4,5,6))) == List(1,2,3,4,5,6))
    }

    // Map and Filter
    test("map creates a new list of the correct values") {
        assert(map((1 to 10).toList)(_ + 1) == (2 to 11).toList)
    }

    test("filter filters the list") {
        assert(filter((-5 to 5).toList)(_ > 0) == (1 to 5).toList)
    }

    test("flatMap maps and flattens") {
        assert(flatMap((1 to 5).toList)(x => (x to 5).toList) ==
            List(1,2,3,4,5, 2,3,4,5, 3,4,5, 4,5, 5))
    }

    // Combined

    test("maxAverage calculates the max average") {
        val list = List(1.0,2.0,3.0,4.0,5.0).map(x => (x, x+10))
        assert(maxAverage(list) == 13.0)
    }

    test("variance calculates the correct variance") {
        val v = variance(List(1.0,2.0,3.0,4.0,5.0))
        assert(v == 2.0, "If you got 2.5, you divided by the wrong thing, probably.")
    }
}
