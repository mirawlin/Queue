package au.com.mir

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class QueueTest {
    @Test
    fun `enqueue should take an item and add it to the queue`() {
        // GIVEN
        val queue = Queue<String>()
        val item0 = "first Item"
        val item1 = "another Item"
        val item2 = "last Item"

        // WHEN
        queue.enqueue(item0)
        queue.enqueue(item1)
        queue.enqueue(item2)

        // THEN
        assertEquals("first Item", queue.getItem(0))
        assertEquals("another Item", queue.getItem(1))
        assertEquals("last Item", queue.getItem(2))
        assertEquals(3,queue.size())
    }

    @Test
    fun `dequeue should remove the first item that was added to the queue and return the queue`() {
        // GIVEN
        val queue = Queue<String>()
        val item0 = "first Item"
        val item1 = "2nd Item"
        val item2 = "last Item"

        queue.enqueue(item0)
        queue.enqueue(item1)
        queue.enqueue(item2)

        // WHEN
        val removedFirstItem = queue.dequeue()

        // THEN
        assertEquals(2, queue.size())
        assertEquals("2nd Item", queue.getItem(0))
        assertEquals("last Item", queue.getItem(1))
        assertEquals("first Item", removedFirstItem)
    }

    @Test
    fun `size should return the `() {

    }
}
