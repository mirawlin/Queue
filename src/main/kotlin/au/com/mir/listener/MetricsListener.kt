package au.com.mir.listener

import au.com.mir.observer.IUpdate
import org.slf4j.LoggerFactory
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*

class MetricsListener : IUpdate {
    companion object {
        private val logger = LoggerFactory.getLogger(MetricsListener::class.java)
    }

    private var enqueueCounter = 0
    private var dequeueCounter = 0

    private val enqueueTime = LinkedList<LocalDateTime>()
    private val dequeueTime = LinkedList<LocalDateTime>()

    override fun update(action: String) {
        if (action == "enqueue") {
            enqueueCounter++
            enqueueTime.addLast(LocalDateTime.now())
        } else {
            dequeueCounter++
            dequeueTime.addLast(LocalDateTime.now())
        }
    }

    fun getEnqueueRate() {
        if (enqueueCounter != 0) {
            val time = ChronoUnit.SECONDS.between(enqueueTime.first, LocalDateTime.now())

            val enqueueRate = if (time > 0)
                enqueueCounter / time
            else
                enqueueCounter / 1

            logger.info("The average Enqueue Rate per second is: ${enqueueRate.toFloat()}/sec, total messages: $enqueueCounter, seconds elapsed: $time")
            enqueueCounter = 0
            enqueueTime.clear()
        } else
            logger.info("There are no messages in the queue: enqueue rate is 0/sec")
    }

    fun getDequeueRate() {
        if (dequeueCounter != 0) {
            val time = ChronoUnit.SECONDS.between(dequeueTime.first, LocalDateTime.now())

            val dequeueRate = if (time > 0)
                dequeueCounter / time
            else
                dequeueCounter / 1

            logger.info("The average Dequeue Rate per second is: ${dequeueRate.toFloat()}/sec, total messages: $dequeueCounter, seconds elapsed: $time")

            dequeueCounter = 0
            dequeueTime.clear()
        } else
            logger.info("There are no messages: dequeue rate is 0/sec")
    }
}
