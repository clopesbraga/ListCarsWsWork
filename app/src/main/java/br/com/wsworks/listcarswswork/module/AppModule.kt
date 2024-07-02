package br.com.wsworks.listcarswswork.module

import br.com.wsworks.listcarswswork.viewmodel.ListCarViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { ListCarViewModel(get()) }
}