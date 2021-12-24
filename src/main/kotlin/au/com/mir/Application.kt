package au.com.mir

import au.com.mir.listener.MetricsListener

fun main(args: Array<String>) {
    val metrics = MetricsListener()

    val queue = Queue<String>(50)

    queue.queueManager.subscribe(metrics)

    queue.enqueue("1")
    queue.enqueue("2")
    queue.enqueue("1")
    queue.enqueue("2")
    queue.enqueue("1")
    queue.enqueue("2")
    queue.enqueue("1")
    queue.enqueue("2")
    Thread.sleep(3000)
    queue.enqueue("2")
    queue.enqueue("1")
    queue.enqueue("2")

    queue.dequeue()

    metrics.getEnqueueRate()
    metrics.getDequeueRate()
}
