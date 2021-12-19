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
    fun `size should return the size of the queue`() {
        // GIVEN
        val queue = Queue<String>()
        queue.enqueue("apple")
        queue.enqueue("orange")
        queue.enqueue("pear")
        queue.enqueue("xmas tree")

        val expectedSize = 4

        // WHEN
        val result = queue.size()

        // THEN
        assertEquals(expectedSize, result)
    }

    @Test
    fun `getItem should return the item located at index n in queue`() {
        // GIVEN
        val queue = Queue<String>()
        queue.enqueue("apple")
        queue.enqueue("orange")
        queue.enqueue("pear")
        queue.enqueue("xmas tree")

        val expected = "pear"

        // WHEN
        val result = queue.getItem(2)

        // THEN
        assertEquals(expected, result)
    }
}
