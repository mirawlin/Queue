package au.com.mir

import java.util.*

class Queue<T> {
    private val queue = LinkedList<T>()

    fun enqueue(item: T) {
        queue.addLast(item)
    }

    fun dequeue(): T {
        return queue.removeFirst()
    }

    fun size(): Int {
        return queue.size
    }

    fun getItem(int:Int): T {
        return queue[int]
    }

    override fun toString(): String {
        return "Queue(queue=$queue)"
    }
}
