package au.com.mir.exception

import java.lang.RuntimeException

data class MaxCapacityException(override val message: String): RuntimeException(message)
