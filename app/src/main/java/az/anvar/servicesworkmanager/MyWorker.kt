package az.anvar.servicesworkmanager

import android.content.Context
import android.util.Log
import androidx.work.*

class MyWorker(
    context: Context,
    private val workerParameters: WorkerParameters
) : Worker(context, workerParameters) {

    override fun doWork(): Result {
        log("doWork")
        val page = workerParameters.inputData.getInt(PAGE, 0)
        for (i in 0 until 100) {
            Thread.sleep(1000)
            log("Timer: $i page: $page")
        }
        return Result.success()
    }

    private fun log(message: String) {
        Log.d("SERVICE_TAG", "MyWorker: $message")
    }

    companion object {
        private const val PAGE = "page"
        const val WORK_NAME = "workName"

        fun makeRequest(page: Int) = OneTimeWorkRequestBuilder<MyWorker>()
            .setInputData(workDataOf(PAGE to page))
            .setConstraints(makeConstraint())
            .build()


        private fun makeConstraint(): Constraints {
            return Constraints.Builder()
                .setRequiresCharging(true)
                .build()
        }
    }
}