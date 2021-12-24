package au.com.mir.observer

import au.com.mir.listener.MetricsListener
import java.util.*

class QueueManager: ISubscription {
    private val listeners = ArrayList<MetricsListener>()

    override fun subscribe(listener: MetricsListener) {
        listeners.add(listener)
    }

    override fun unsubscribe(listener: MetricsListener) {
        listeners.remove(listener)
    }

    override fun notify(metricName: String) {
        for (i in listeners) {
            i.update(metricName)
        }
    }

    override fun toString(): String {
        return "QueueManager(listeners=$listeners)"
    }
}
