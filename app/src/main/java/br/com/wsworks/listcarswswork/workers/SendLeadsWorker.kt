//package br.com.wsworks.listcarswswork.workers
//
//import android.content.Context
//import androidx.appcompat.widget.AppCompatDrawableManager.get
//import androidx.work.CoroutineWorker
//import androidx.work.WorkerParameters
//import br.com.wsworks.listcarswswork.viewmodel.LeadsViewModel
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//import org.koin.java.KoinJavaComponent.inject
//
//class SendLeadsWorker(appContext: Context, workerParams: WorkerParameters) :
//    CoroutineWorker(appContext, workerParams) {
//
//    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
//        val viewModel: LeadsViewModel by inject(LeadsViewModel::class.java)
//
//        // Call the sendLeads function
//        viewModel.sendLeads()
//
//        Result.success()
//    }
//}