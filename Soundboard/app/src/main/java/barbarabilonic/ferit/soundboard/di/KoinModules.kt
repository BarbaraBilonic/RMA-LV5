package barbarabilonic.ferit.soundboard.di

import barbarabilonic.ferit.soundboard.sound.AudioPlayer
import barbarabilonic.ferit.soundboard.sound.SoundPoolPlayer
import barbarabilonic.ferit.soundboard.ui.SoundboardViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<AudioPlayer> { SoundPoolPlayer(androidContext()) }
}

val viewModelModule = module {
    viewModel<SoundboardViewModel> {SoundboardViewModel(get()) }
}