package au.com.mir

import au.com.mir.exception.MaxCapacityException
import au.com.mir.observer.QueueManager
import java.util.*

class Queue<T>(maxCapacity: Int? = null) {
    private val queue = LinkedList<T>()
    private val queueMaxCapacity = maxCapacity

    val queueManager: QueueManager = QueueManager()

    fun enqueue(item: T) {
        if (this.queueMaxCapacity == null || this.queue.size < this.queueMaxCapacity) {
            queue.addLast(item)
            queueManager.notify("enqueue")
        } else
            throw MaxCapacityException("Max Capacity of $queueMaxCapacity exceeded")
    }

    fun dequeue(): T {
        queueManager.notify("dequeue")
        return queue.removeFirst()
    }

    fun size(): Int {
        return queue.size
    }

    fun getItem(int: Int): T {
        return queue[int]
    }

    override fun toString(): String {
        return "Queue(queue=$queue, queueMaxCapacity=$queueMaxCapacity, queueManager=$queueManager)"
    }
}
