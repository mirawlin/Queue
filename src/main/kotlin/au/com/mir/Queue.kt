package au.com.mir

import au.com.mir.exception.MaxCapacityException
import java.util.*

class Queue<T>(maxCapacity: Int?) {
    private val queue = LinkedList<T>()
     private val queueMaxCapacity = maxCapacity

    fun enqueue(item: T) {
        if (this.queueMaxCapacity == null || this.queue.size < this.queueMaxCapacity)
            queue.addLast(item)
        else
            throw MaxCapacityException("Max Capacity of $queueMaxCapacity exceeded")
    }

    fun dequeue(): T {
        return queue.removeFirst()
    }

    fun size(): Int {
        return queue.size
    }

    fun getItem(int: Int): T {
        return queue[int]
    }

    override fun toString(): String {
        return "Queue(queue=$queue)"
    }
}
