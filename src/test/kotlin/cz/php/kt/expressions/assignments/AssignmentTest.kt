package cz.php.kt.expressions.assignments

import cz.php.kt.expressions.`$`
import cz.php.kt.expressions.scalars.phpObj
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class AssignmentTest : StringSpec({

    "Assignments render correctly" {
        Assignment(`$`("x"), "x".phpObj).toPhpStr() shouldBe "\$x = \"x\""
    }

    "Helper function creates assignments correctly" {
        (`$`("x") `=` 3.14) shouldBe Assignment(`$`("x"), 3.14.phpObj)
    }

    "Nested assignments work when parenthesised correctly" {
        (`$`("x") `=` (`$`("y") `=` "x")).toPhpStr() shouldBe "\$x = \$y = \"x\""
    }
})
