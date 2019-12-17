package cz.php.kt

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class PhpTest : StringSpec({

    class StringNode(val name: String) : Node(mutableListOf()) {
        override fun toPhpStr(): String = name
    }

    "The php function should add <?php at the beginning of the code" {
        val code = php {
            +StringNode("first")
        }.toPhpStr()

        code shouldBe "<?php\n\nfirst"
    }
})
