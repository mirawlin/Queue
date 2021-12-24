package au.com.mir.observer

import au.com.mir.listener.MetricsListener

interface ISubscription {
    fun subscribe(listener: MetricsListener)

    fun unsubscribe(listener: MetricsListener)

    fun notify( metricName: String)
}
